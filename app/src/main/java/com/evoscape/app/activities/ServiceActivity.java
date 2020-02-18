package com.evoscape.app.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.evoscape.app.R;
import com.evoscape.app.adapters.ServiceAdapter;
import com.evoscape.app.models.service.Service;

import java.util.ArrayList;

public class ServiceActivity extends AppCompatActivity {
    private RecyclerView recyclerViewServices;
    private Toolbar toolbar;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.appbar_menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.settings:
                startActivity(new Intent(getBaseContext(), ProfileActivity.class));
                return true;

                default:
                    return super.onOptionsItemSelected(item);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        toolbar = findViewById(R.id.toolbarServices);
        setSupportActionBar(toolbar);

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
        recyclerViewServices.setLayoutManager(new GridLayoutManager(this, 1));
        ServiceAdapter adapter = new ServiceAdapter(this, services);
        recyclerViewServices.setAdapter(adapter);
    }
}
