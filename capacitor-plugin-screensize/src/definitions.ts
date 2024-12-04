export interface screensizePlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getScreenSize(): Promise<{ width: number; height: number }>;
}
