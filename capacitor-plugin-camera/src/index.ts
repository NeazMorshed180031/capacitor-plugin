import { registerPlugin } from '@capacitor/core';

import type { cameraPlugin } from './definitions';

const camera = registerPlugin<cameraPlugin>('camera', {
  web: () => import('./web').then((m) => new m.cameraWeb()),
});

export * from './definitions';
export { camera };
