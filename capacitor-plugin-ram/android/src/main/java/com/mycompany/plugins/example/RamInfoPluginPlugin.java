package com.mycompany.plugins.example;

import android.app.ActivityManager;
import android.content.Context;
import android.os.Build;
import android.os.Debug;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "RamInfoPlugin")
public class RamInfoPluginPlugin extends Plugin {

    @PluginMethod
    public void getRamInfo(PluginCall call) {
        JSObject ret = new JSObject();

        try {
            Context context = getContext();
            ActivityManager activityManager = (ActivityManager) context.getSystemService(Context.ACTIVITY_SERVICE);
            ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();

            if (activityManager != null) {
                activityManager.getMemoryInfo(memoryInfo);

                long totalMemory;
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                    totalMemory = memoryInfo.totalMem; // Available on API Level 16+
                } else {
                    totalMemory = getLegacyTotalMemory(activityManager);
                }

                // Convert bytes to gigabytes
                double totalMemoryInGB = (double) totalMemory / (1024 * 1024 * 1024);
                ret.put("totalRamInGB", Math.round(totalMemoryInGB * 100.0) / 100.0); // Rounded to 2 decimal places
                call.resolve(ret);
            } else {
                call.reject("Unable to access ActivityManager.");
            }
        } catch (Exception e) {
            call.reject("Error fetching RAM information: " + e.getMessage());
        }
    }

    private long getLegacyTotalMemory(ActivityManager activityManager) {
        Debug.MemoryInfo[] memoryInfoArray = activityManager.getProcessMemoryInfo(new int[]{android.os.Process.myPid()});
        if (memoryInfoArray.length > 0) {
            return memoryInfoArray[0].getTotalPss() * 1024L;
        }
        return 0L;
    }
}
