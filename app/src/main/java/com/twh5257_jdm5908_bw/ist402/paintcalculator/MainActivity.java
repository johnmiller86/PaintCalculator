package com.twh5257_jdm5908_bw.ist402.paintcalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private InteriorRoom room;
    private EditText lengthET, widthET, heightET, doorsET, windowsET;
    private TextView gallonsV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obtaining references to UI components
        referenceUIcomponents();

        // Create room
        room = new InteriorRoom();
    }

    private void referenceUIcomponents(){
        lengthET = (EditText) findViewById(R.id.editText1);
        widthET = (EditText) findViewById(R.id.editText2);
        heightET = (EditText) findViewById(R.id.editText3);
        doorsET = (EditText) findViewById(R.id.editText4);
        windowsET = (EditText) findViewById(R.id.editText5);
        gallonsV = (TextView) findViewById(R.id.textView9);
    }

    public void computeGallons(View view){
        // Set room dimensions from input
        double l = Double.valueOf(lengthET.getText().toString());
        double w = Double.valueOf(widthET.getText().toString());
        double h = Double.valueOf(heightET.getText().toString());
        room.setLength(l);
        room.setWidth(w);
        room.setHeight(h);

        // Set number of doors and windows from input
        int doors = Integer.valueOf(doorsET.getText().toString());
        int windows = Integer.valueOf(windowsET.getText().toString());
        room.setDoors(doors);
        room.setWindows(windows);

        // Display the area to be painted and gallons required
        gallonsV.setText("Interior surface area: " + room.surfaceArea() + " feet" + "\nGallons needed: " + room.gallons());
    }

    public void gotoHelp(View view){
        Intent helpIntent = new Intent(MainActivity.this, HelpActivity.class);
        startActivity(helpIntent);
    }
}
