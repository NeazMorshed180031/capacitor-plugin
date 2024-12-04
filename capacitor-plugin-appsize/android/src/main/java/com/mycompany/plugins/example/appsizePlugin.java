package com.mycompany.plugins.example;

import android.os.Debug;
import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "appsize")
public class appsizePlugin extends Plugin {

    // Existing echo method
    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");
        if (value == null) {
            call.reject("Value is required.");
            return;
        }

        JSObject ret = new JSObject();
        ret.put("value", value); // Directly return the provided value
        call.resolve(ret);
    }

    // New method to get app's space in KB
    @PluginMethod
    public void getAppSpace(PluginCall call) {
        try {
            String appSpace = getAppSpaceInKB();
            JSObject ret = new JSObject();
            ret.put("appSpace", appSpace);  // Return the app space in KB
            call.resolve(ret);  // Resolving the plugin call
        } catch (Exception e) {
            call.reject("Error getting app space", e);
        }
    }

    // Method to calculate the app space in KB
    private String getAppSpaceInKB() {
        long totalPss = Debug.getPss(); // Get the total PSS (proportional set size) in KB
        if (totalPss <= 0) {
            return "Data unavailable"; // Handle cases where PSS data might not be retrievable
        }
        return totalPss + " KB";  // Return the space in KB
    }
}
