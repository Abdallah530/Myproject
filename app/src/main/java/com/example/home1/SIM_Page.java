package com.example.home1;

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

import androidx.appcompat.app.AppCompatActivity;

import com.example.home1.SQLLite.Item;
import com.example.home1.SQLLite.SQLItem;

public class SIM_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_s_i_m__page);

        RadioButton smart = (RadioButton) findViewById(R.id.Smartline);
        RadioButton shababi = (RadioButton) findViewById(R.id.shababi);
        Button addSim = findViewById(R.id.add_sim);
        final Spinner simsp = (Spinner) findViewById(R.id.spinner_SIM);
        TextView contactsim=(TextView)findViewById(R.id.textView14);
        contactsim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(SIM_Page.this, ContactUs.class);
                startActivity(i);
            }
        });
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SIM_Page.this, R.array.planets_array, android.R.layout.simple_spinner_item);
        simsp.setAdapter(adapter);
        simsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                int position = simsp.getSelectedItemPosition();
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
        smart.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SIM_Page.this, R.array.planets_array, android.R.layout.simple_spinner_item);
                    simsp.setAdapter(adapter);
                    simsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            int position = simsp.getSelectedItemPosition();
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
        shababi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(SIM_Page.this, R.array.planet_array2, android.R.layout.simple_spinner_item);
                    simsp.setAdapter(adapter);
                    simsp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            int position = simsp.getSelectedItemPosition();
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
        addSim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLItem sqlItem = new SQLItem(SIM_Page.this);
                Item x = new Item(SIM_Page.this);
                x.setName(simsp.getSelectedItem().toString());
                sqlItem.insertItem(x);
                Toast.makeText(getBaseContext(), "Thank you for using our Application", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}