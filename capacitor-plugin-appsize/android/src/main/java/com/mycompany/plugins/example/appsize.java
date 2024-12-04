package com.mycompany.plugins.example;

import android.util.Log;

public class appsize {

    private static final String TAG = "AppSizePlugin"; // Use a consistent tag for logging

    /**
     * Echoes the given value and logs it.
     * 
     * @param value The input string to echo.
     * @return The same string as provided in the input.
     */
    public String echo(String value) {
        if (value == null) {
            Log.w(TAG, "Received null value in echo method.");
            return "Input value is null"; // Provide meaningful feedback in case of null input
        }

        Log.i(TAG, "Echoing value: " + value); // Improved log message for clarity
        return value;
    }
}
