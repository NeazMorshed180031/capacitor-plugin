import { registerPlugin } from '@capacitor/core';

import type { appsizePlugin } from './definitions';

const appsize = registerPlugin<appsizePlugin>('appsize', {
  web: () => import('./web').then((m) => new m.appsizeWeb()),
});

export * from './definitions';
export { appsize };
