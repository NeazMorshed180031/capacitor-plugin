import { WebPlugin } from '@capacitor/core';
import type { KernelInfoPluginPlugin } from './definitions';

export class KernelInfoPluginWeb extends WebPlugin implements KernelInfoPluginPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getKernelVersion(): Promise<{ kernelVersion: string }> {
    // Provide a fallback value since kernel version is unavailable on the web
    return { kernelVersion: 'Web: Kernel info not available' };
  }
}
