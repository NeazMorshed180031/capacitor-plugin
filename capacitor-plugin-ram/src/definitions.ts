export interface RamInfoPluginPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getRamInfo(): Promise<{ totalRamInGB: number }>;
}
