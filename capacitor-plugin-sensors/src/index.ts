import { registerPlugin } from '@capacitor/core';

import type { sensorsPlugin } from './definitions';

const sensors = registerPlugin<sensorsPlugin>('sensors', {
  web: () => import('./web').then((m) => new m.sensorsWeb()),
});

export * from './definitions';
export { sensors };
