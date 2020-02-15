package com.evoscape.app.models.connection;

import android.app.Activity;
import android.content.Intent;

import com.evoscape.app.activities.MainActivity;
import com.evoscape.app.utils.Utils;

import org.java_websocket.WebSocket;
import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;

import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;

public class ConnectionClient {
    private static WebSocketClient client;
    private static PublicKey publicKey;
    private static SecretKey secretKey;
    private static Activity currentActivity;

    public static void newClient() throws URISyntaxException {
        client = new WebSocketClient(new URI("ws://realmlands.com:7804")) { //change to 42069
            @Override
            public void onOpen(ServerHandshake handshakedata) {

            }

            @Override
            public void onMessage(String s) {
                if (publicKey == null) {
                    Message publicKeyMessage = Utils.getGson().fromJson(s, Message.class);

                    if (publicKeyMessage != null) {
                        publicKey = Utils.getPublicKey(Utils.getGson().fromJson(publicKeyMessage.getPayload(), KeyPayLoad.class).getPublicKey());

                        KeyGenerator keygenerator = null;
                        try {
                            keygenerator = KeyGenerator.getInstance("AES");
                            keygenerator.init(256);
                            secretKey = keygenerator.generateKey();
                        } catch (NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }

                        Message secretKeyMsg = new Message("connection:secret_key", Utils.getGson().toJson(secretKey.getEncoded()));

                        try {
                            client.send("{" + "encoded:" + Utils.getGson().toJson(Utils.encryptRSA(Utils.getGson().toJson(secretKeyMsg), publicKey)) + "}");
                        } catch (BadPaddingException | IllegalBlockSizeException | InvalidKeyException | NoSuchPaddingException | NoSuchAlgorithmException e) {
                            e.printStackTrace();
                        }

                        ConnectionClient.getCurrentActivity().finish();
                        ConnectionClient.getCurrentActivity().startActivity(new Intent(ConnectionClient.getCurrentActivity().getBaseContext(), MainActivity.class));
                    }
                } else {
                    Message message = null;
                    EncodedMessage encodedMessage = Utils.getGson().fromJson(s, EncodedMessage.class);

                    if (encodedMessage != null) {
                        message = Utils.getGson().fromJson(Utils.decryptAES(encodedMessage.getEncoded(), secretKey), Message.class);
                    }

                    if (message != null) {
                        System.out.println("Rec: " + message.getType());
                        switch (message.getModule()) {

                        }
                    }
                }
            }

            @Override
            public void onClose(int code, String reason, boolean remote) {
                System.out.println("closed socket: " + code + " " + reason);
            }

            @Override
            public void onError(Exception ex) {
                ex.printStackTrace();
            }
        };

        client.connect();
    }

    public static SecretKey getSecretKey() {
        return secretKey;
    }

    public static WebSocket getWebSocket() {
        return client.getConnection();
    }

    public static Activity getCurrentActivity() {
        return currentActivity;
    }

    public static void setCurrentActivity(Activity currentActivity) {
        ConnectionClient.currentActivity = currentActivity;
    }
}
