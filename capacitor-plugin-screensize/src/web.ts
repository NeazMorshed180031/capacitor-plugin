import { WebPlugin } from '@capacitor/core';

import type { screensizePlugin } from './definitions';

export class screensizeWeb extends WebPlugin implements screensizePlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getScreenSize(): Promise<{ width: number; height: number }> {
    const width = window.innerWidth;
    const height = window.innerHeight;

    console.log('Screen Size:', { width, height });

    return { width, height };
  }
}
