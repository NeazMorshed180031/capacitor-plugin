import { registerPlugin } from '@capacitor/core';

import type { screensizePlugin } from './definitions';

const screensize = registerPlugin<screensizePlugin>('screensize', {
  web: () => import('./web').then((m) => new m.screensizeWeb()),
});

export * from './definitions';
export { screensize };
