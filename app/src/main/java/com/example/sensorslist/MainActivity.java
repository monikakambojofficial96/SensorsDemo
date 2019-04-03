package com.example.sensorslist;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static android.widget.AdapterView.*;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        SensorManager sensorManager=(SensorManager)getSystemService ( Context.SENSOR_SERVICE );
        List <Sensor> sensors= sensorManager.getSensorList ( Sensor.TYPE_ALL );
        List<String> listOfSensorNames = new ArrayList <> ( );

        for (int i=0; i<sensors.size (); i++){
            listOfSensorNames.add(sensors.get ( i ).getName ());
        }
        ListView listview =(ListView)findViewById ( R.id.list_view );
        ArrayAdapter<String> adapter = new ArrayAdapter <String> (MainActivity.this, android.R.layout.simple_list_item_1,  listOfSensorNames);
        listview.setAdapter ( adapter );

        listview.setOnItemClickListener ( new OnItemClickListener () {
            @Override
            public void onItemClick(AdapterView <?> parent , View view , int position , long id) {
                String string= " clicking "+position;
                Toast toast=Toast.makeText (getApplicationContext (),string,Toast.LENGTH_LONG );
                toast.show ();
            }
        } );
    }
}
