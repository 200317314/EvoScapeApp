package com.evoscape.app.adapters;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evoscape.app.R;
import com.evoscape.app.adapters.adapters.ServiceAdapter;
import com.evoscape.app.adapters.models.Service;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {
    private RecyclerView recyclerViewServices;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);
        initRecyclerView();
    }

    private void initRecyclerView() {
        //TODO: Get rid of premade items
        ArrayList<Service> services = new ArrayList<Service>(){{
            add(new Service("1", "Service 1", ""));
            add(new Service("2", "Service 2", ""));
            add(new Service("3", "Service 3", ""));
            add(new Service("4", "Service 4", ""));
            add(new Service("5", "Service 5", ""));
        }};

        recyclerViewServices = findViewById(R.id.rvServices);
        recyclerViewServices.setLayoutManager(new GridLayoutManager(this, 2));
        ServiceAdapter adapter = new ServiceAdapter(this, services);
        recyclerViewServices.setAdapter(adapter);
    }
}
