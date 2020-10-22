package com.example.home1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home1.SQLLite.Item;
import com.example.home1.SQLLite.SQLItem;

public class Router_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_router__page);
        RadioButton Router = (RadioButton) findViewById(R.id.r_Router);
        RadioButton mifi = (RadioButton) findViewById(R.id.r_Mifi);
        Button addrouter = findViewById(R.id.add_Router);
        final Spinner simsp2 = (Spinner) findViewById(R.id.spinner_Router);
        TextView contactRouter=(TextView)findViewById(R.id.textView13);
        contactRouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Router_Page.this, ContactUs.class);
                startActivity(i);
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Router_Page.this, R.array.planet_array3, android.R.layout.simple_spinner_item);
        simsp2.setAdapter(adapter);
        simsp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int position = simsp2.getSelectedItemPosition();
                switch (position) {
                    case 0:

                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
        Router.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Router_Page.this, R.array.planet_array3, android.R.layout.simple_spinner_item);
                    simsp2.setAdapter(adapter);
                    simsp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            int position = simsp2.getSelectedItemPosition();
                            switch (position) {
                                case 0:

                                    break;
                                case 1:
                                    break;
                                case 2:
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }
        });
        mifi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Router_Page.this, R.array.planet_array4, android.R.layout.simple_spinner_item);
                    simsp2.setAdapter(adapter);
                    simsp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            int position = simsp2.getSelectedItemPosition();
                            switch (position) {
                                case 0:
                                    break;
                                case 1:
                                    break;
                                case 2:
                                    break;
                            }
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }
        });
        addrouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLItem sqlItem = new SQLItem(Router_Page.this);
                Item x = new Item(Router_Page.this);
                x.setName(simsp2.getSelectedItem().toString());
                sqlItem.insertItem(x);

                Toast.makeText(getBaseContext(), "Thank you for using our Application", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}