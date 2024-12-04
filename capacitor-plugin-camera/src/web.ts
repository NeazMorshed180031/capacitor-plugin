import { WebPlugin } from '@capacitor/core';
import type { cameraPlugin } from './definitions';

export class cameraWeb extends WebPlugin implements cameraPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getCameraInfo(): Promise<{ cameras?: Record<string, string>; error?: string }> {
    console.warn('getCameraInfo is not implemented for the web.');
    return {
      error: 'Camera info is not available on the web platform.',
    };
  }
}
