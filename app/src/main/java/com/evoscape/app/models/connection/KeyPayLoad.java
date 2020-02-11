package com.evoscape.app.models.connection;

public class KeyPayLoad {
    private String publicKey;

    public KeyPayLoad(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
}

