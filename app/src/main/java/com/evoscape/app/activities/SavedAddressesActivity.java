package com.evoscape.app.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.evoscape.app.R;
import com.evoscape.app.adapters.AddressAdapter;

import java.util.ArrayList;

public class SavedAddressesActivity extends AppCompatActivity {
    private RecyclerView rvAddresses;
    private TextView textViewHomeAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_addresses);

        textViewHomeAddress = findViewById(R.id.textViewHomeAddress);
        initRecyclerView();
    }

    private void initRecyclerView() {
        ArrayList<String> addresses = new ArrayList<String>(){{
            add("11 Little Ave");
            add("109 Holy Crescent");
            add("98 Blain Court");
            add("4 Side Road");
            add("1790 Left St");
        }};

        rvAddresses = findViewById(R.id.rvAddresses);
        rvAddresses.setLayoutManager(new LinearLayoutManager(getBaseContext()));
        AddressAdapter adapter = new AddressAdapter(getBaseContext(), addresses, textViewHomeAddress);
        rvAddresses.setAdapter(adapter);
    }
}
