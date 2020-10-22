package com.example.home1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.home1.SQLLite.Item;
import com.example.home1.SQLLite.SQLItem;

public class Fiber_Page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fiber__page);
        CheckBox cfiber = (CheckBox) findViewById(R.id.c_fiber);
        final Button addfiber = findViewById(R.id.add_Fiber);
        addfiber.setEnabled(false);
        final Spinner simsp3 = (Spinner) findViewById(R.id.spinner_fiber);
        TextView contactFiber=(TextView)findViewById(R.id.textView11);
        contactFiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Fiber_Page.this, ContactUs.class);
                startActivity(i);
            }
        });
        addfiber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SQLItem sqlItem = new SQLItem(Fiber_Page.this);
                Item x = new Item(Fiber_Page.this);
                x.setName(simsp3.getSelectedItem().toString());
                sqlItem.insertItem(x);
                Toast.makeText(getBaseContext(), "Thank you for using our Application", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
        simsp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
//                int position = simsp3.getSelectedItemPosition();
//                switch (position) {
//                    case 0:
//                        break;
//                    case 1:
//                        break;
//                    case 2:
//                        break;
//                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        cfiber.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b) {
                    addfiber.setEnabled(true);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Fiber_Page.this, R.array.planet_array5, android.R.layout.simple_spinner_item);
                    simsp3.setAdapter(adapter);
                } else {
                    addfiber.setEnabled(false);
                    ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(Fiber_Page.this,  R.array.empty_array, android.R.layout.simple_spinner_item);
                    simsp3.setAdapter(adapter);
                }
            }
        });
    }
}
