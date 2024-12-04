package com.mycompany.plugins.example;

import android.util.DisplayMetrics;
import android.content.Context;
import android.view.WindowManager;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "screensize")
public class screensizePlugin extends Plugin {

    @PluginMethod
    public void getScreenSize(PluginCall call) {
        // Get the WindowManager service
        WindowManager windowManager = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        
        // Create a DisplayMetrics object
        DisplayMetrics displayMetrics = new DisplayMetrics();
        
        // Populate the DisplayMetrics object
        if (windowManager != null) {
            windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        }
        
        // Retrieve screen width and height in pixels
        int width = displayMetrics.widthPixels;
        int height = displayMetrics.heightPixels;

        // Create a response object
        JSObject ret = new JSObject();
        ret.put("width", width);
        ret.put("height", height);
        
        // Resolve the call with the screen size
        call.resolve(ret);
    }
}
