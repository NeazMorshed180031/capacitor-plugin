import { WebPlugin } from '@capacitor/core';
import type { appsizePlugin } from './definitions';

export class appsizeWeb extends WebPlugin implements appsizePlugin {
  /**
   * Echoes the provided value.
   * @param options An object containing a `value` string to echo.
   * @returns A promise resolving to the same `value`.
   */
  async echo(options: { value: string }): Promise<{ value: string }> {
    console.log('ECHO:', options.value);
    return { value: options.value };
  }

  /**
   * Retrieves the app's memory usage (space used) in KB.
   * Currently not implemented for the web.
   * @returns A placeholder indicating unavailability on the web.
   */
  async getAppSpace(): Promise<{ appSpace: string }> {
    console.warn('getAppSpace is not implemented for the web platform.');
    return { appSpace: 'Not available on web' };
  }
}
