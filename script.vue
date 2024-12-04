<script setup>
import { ref, onMounted } from "vue";
import { Device } from "@capacitor/device";
import { Plugins } from "@capacitor/core";

const { KernelInfoPlugin, RamInfoPlugin, screensize, sensors, camera, appsize } = Plugins;

// Reactive variables for device metrics
const deviceModel = ref("Loading...");
const osVersion = ref("Loading...");
let kernelVersion = ref("Loading...");
const ramSize = ref("Loading...");
const screenWidth = ref("Calculating...");
const screenHeight = ref("Calculating...");
const sensorsTotal = ref("Calculating...");
let batteryLevel = ref("Loading...");
let fontCamera = ref("Loading...");
let loading = ref(false);
let appMemoryUsage = ref(null)
// Fetch kernel version
const fetchKernelVersion = async () => {
  try {
    const result = await KernelInfoPlugin.getKernelVersion();
    kernelVersion.value = result.kernelVersion;
  } catch (error) {
    console.error("Kernel Version Error:", error);
  }
};

// Fetch device info
const fetchDeviceInfo = async () => {
  const info = await Device.getInfo();
  deviceModel.value = info.model || "Unknown";
  osVersion.value = info.osVersion || "Unknown";
};

// Fetch RAM size
async function fetchRamInfo() {
  try {
    const result = await RamInfoPlugin.getRamInfo();
    ramSize.value = `${Math.ceil(result.totalRamInGB)} GB`;
  } catch (error) {
    console.error("RAM Info Error:", error);
  }
}

// Fetch screen size
async function fetchScreenSize() {
  try {
    const result = await screensize.getScreenSize();
    screenWidth.value = result.width;
    screenHeight.value = result.height;
  } catch (error) {
    console.error("Screen Size Error:", error);
  }
}

// Fetch sensor count
async function fetchSensorCount() {
  try {
    const result = await sensors.getSensorCount();
    sensorsTotal.value = result.count;
  } catch (error) {
    console.error("Sensor Count Error:", error);
  }
}

// Fetch camera details
async function fetchCameraDetails() {
  try {
    const result = await camera.getCameraInfo();
    const { cameras } = result;
    if (cameras) {
      for (const [cameraId, cameraInfo] of Object.entries(cameras)) {
        if (cameraId == 0) {
          fontCamera.value = cameraInfo;
        }
      }
    }
  } catch (error) {
    console.error("Camera Info Error:", error);
  }
}

// Fetch battery info
const logBatteryInfo = async () => {
  const info = await Device.getBatteryInfo();
  batteryLevel.value = Math.round(info.batteryLevel * 100);
};

// Log memory usage
const fetchAppMemoryUsage = async () => {
  try {
    // Fetch the app's memory usage from the appsize plugin
    const result = await appsize.getAppSpace();
    appMemoryUsage.value = result.appSpace
    // Log the memory usage result

  } catch (error) {
    // Handle error and log it
    console.error("App Memory Usage Error:", error);
  }
};

// On component mount, fetch all data and measure performance
onMounted(async () => {
  loading.value = true;

  const startTime = performance.now();

  await fetchDeviceInfo();
  await fetchKernelVersion();
  await fetchRamInfo();
  await logBatteryInfo();
  await fetchScreenSize();
  await fetchSensorCount();
  await fetchCameraDetails();
  await fetchAppMemoryUsage(); // Fetch app memory usage
  const endTime = performance.now();
  loading.value = false;

  // console.log(`Time taken to fetch all metrics: ${(endTime - startTime).toFixed(2)} ms`);
  // console.log("Memory Usage:", result.appSpace); // Use result.appSpace to log the app space in KB
  console.log(`Time taken to fetch all metrics: ${(endTime - startTime).toFixed(2)} ms | Memory Usage: ${appMemoryUsage.value}`);


});
</script>