import { WebPlugin } from '@capacitor/core';
import type { RamInfoPluginPlugin } from './definitions';

export class RamInfoPluginWeb extends WebPlugin implements RamInfoPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  // Implementing the required getRamInfo method
  async getRamInfo(): Promise<{ totalRamInGB: number }> {
    // Simulate getting RAM size. In reality, this won't be accessible directly in the browser.
    const totalRamInGB = 0; // Placeholder value, you can customize this if needed
    return { totalRamInGB };
  }
}
