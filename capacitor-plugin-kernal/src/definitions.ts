export interface KernelInfoPluginPlugin {
   getKernelVersion(): Promise<{ kernelVersion: string }>;
}
