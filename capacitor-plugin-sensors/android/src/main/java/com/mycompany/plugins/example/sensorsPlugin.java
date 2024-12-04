package com.mycompany.plugins.example;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

import java.util.List;

@CapacitorPlugin(name = "sensors")
public class sensorsPlugin extends Plugin {

    @PluginMethod
    public void getSensorCount(PluginCall call) {
        // Get the SensorManager
        SensorManager sensorManager = (SensorManager) getContext().getSystemService(Context.SENSOR_SERVICE);

        if (sensorManager != null) {
            // Get the list of all available sensors
            List<Sensor> sensorList = sensorManager.getSensorList(Sensor.TYPE_ALL);
            
            // Get the total count of sensors
            int sensorCount = sensorList.size();

            // Create the result object
            JSObject ret = new JSObject();
            ret.put("count", sensorCount);

            // Resolve the call with the sensor count
            call.resolve(ret);
        } else {
            // Handle the case where SensorManager is null
            call.reject("SensorManager not available");
        }
    }
}
