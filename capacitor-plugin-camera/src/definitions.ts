export interface cameraPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getCameraInfo(): Promise<{
    cameras?: Record<string, string>;
    error?: string;
  }>;
}
