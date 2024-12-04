package com.mycompany.plugins.example;

import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.util.Size;

import com.getcapacitor.JSObject;
import com.getcapacitor.Plugin;
import com.getcapacitor.PluginCall;
import com.getcapacitor.PluginMethod;
import com.getcapacitor.annotation.CapacitorPlugin;

@CapacitorPlugin(name = "camera")
public class cameraPlugin extends Plugin {

    private camera implementation = new camera();

    @PluginMethod
    public void echo(PluginCall call) {
        String value = call.getString("value");

        JSObject ret = new JSObject();
        ret.put("value", implementation.echo(value));
        call.resolve(ret);
    }

    @PluginMethod
    public void getCameraInfo(PluginCall call) {
        JSObject ret = new JSObject();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            CameraManager cameraManager = (CameraManager) getContext().getSystemService(Context.CAMERA_SERVICE);
            if (cameraManager == null) {
                ret.put("error", "CameraManager not available.");
                call.resolve(ret);
                return;
            }

            try {
                String[] cameraIds = cameraManager.getCameraIdList();
                if (cameraIds.length == 0) {
                    ret.put("message", "No cameras found on this device.");
                    call.resolve(ret);
                    return;
                }

                JSObject cameras = new JSObject();
                for (String cameraId : cameraIds) {
                    CameraCharacteristics characteristics = cameraManager.getCameraCharacteristics(cameraId);
                    if (characteristics == null) {
                        continue; // Skip if characteristics are null
                    }

                    Integer lensFacing = characteristics.get(CameraCharacteristics.LENS_FACING);
                    if (lensFacing != null && lensFacing == CameraCharacteristics.LENS_FACING_FRONT) {
                        continue; // Skip front-facing cameras
                    }

                    Size pixelArraySize = characteristics.get(CameraCharacteristics.SENSOR_INFO_PIXEL_ARRAY_SIZE);
                    if (pixelArraySize != null) {
                        float megapixels = (pixelArraySize.getWidth() * pixelArraySize.getHeight()) / 1_000_000f;
                        cameras.put(cameraId, String.format("%.1f MP", megapixels));
                    } else {
                        cameras.put(cameraId, "Unknown MP");
                    }
                }

                ret.put("cameras", cameras);
            } catch (Exception e) {
                e.printStackTrace();
                ret.put("error", "Error fetching camera details: " + e.getMessage());
            }
        } else {
            ret.put("error", "Camera info not available for this device.");
        }
        call.resolve(ret);
    }
}
