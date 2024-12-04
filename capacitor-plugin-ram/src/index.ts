import { registerPlugin } from '@capacitor/core';

import type { RamInfoPluginPlugin } from './definitions';

const RamInfoPlugin = registerPlugin<RamInfoPluginPlugin>('RamInfoPlugin', {
  web: () => import('./web').then((m) => new m.RamInfoPluginWeb()),
});

export * from './definitions';
export { RamInfoPlugin };
