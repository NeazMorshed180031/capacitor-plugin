import { WebPlugin } from '@capacitor/core';

import type { sensorsPlugin } from './definitions';

export class sensorsWeb extends WebPlugin implements sensorsPlugin {
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO', options);
    return options;
  }

  async getSensorCount(): Promise<{ count: number }> {
    console.warn('getSensorCount is not implemented on the web platform. Returning a default value.');

    // Return a default value since actual sensors are not available on the web
    return { count: 0 };
  }
}
