import { registerPlugin } from '@capacitor/core';

import type { KernelInfoPluginPlugin } from './definitions';

const KernelInfoPlugin = registerPlugin<KernelInfoPluginPlugin>('KernelInfoPlugin', {
  web: () => import('./web').then((m) => new m.KernelInfoPluginWeb()),
});

export * from './definitions';
export { KernelInfoPlugin };
