# capacitor-plugin-ram

none

## Install

```bash
npm install capacitor-plugin-ram
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getRamInfo()`](#getraminfo)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

| Param         | Type                            |
| ------------- | ------------------------------- |
| **`options`** | <code>{ value: string; }</code> |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getRamInfo()

```typescript
getRamInfo() => Promise<{ totalRamInGB: number; }>
```

**Returns:** <code>Promise&lt;{ totalRamInGB: number; }&gt;</code>

--------------------

</docgen-api>
