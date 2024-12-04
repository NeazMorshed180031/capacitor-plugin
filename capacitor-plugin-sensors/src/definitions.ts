export interface sensorsPlugin {
  echo(options: { value: string }): Promise<{ value: string }>;
  getSensorCount(): Promise<{ count: number }>;
}
