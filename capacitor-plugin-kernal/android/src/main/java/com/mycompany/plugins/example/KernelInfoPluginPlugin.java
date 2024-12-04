package com.mycompany.plugins.example;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "KernelInfoPlugin")
public class KernelInfoPluginPlugin extends Plugin {

    @PluginMethod
    public void getKernelVersion(PluginCall call) {
        try {
            // Fetch the kernel version from system properties
            String kernelVersion = System.getProperty("os.version");

            // Create a JSON object to return the result
            JSObject ret = new JSObject();
            ret.put("kernelVersion", kernelVersion != null ? kernelVersion : "Unknown");

            // Resolve the call with the result
            call.resolve(ret);
        } catch (Exception e) {
            // Handle any potential errors
            call.reject("Unable to fetch kernel version", e);
        }
    }
}
