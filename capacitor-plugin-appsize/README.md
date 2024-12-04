# capacitor-plugin-appsize

get the installed app size in device

## Install

```bash
npm install capacitor-plugin-appsize
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getAppSpace()`](#getappspace)

</docgen-index>

<docgen-api>
<!--Update the source file JSDoc comments and rerun docgen to update the docs below-->

### echo(...)

```typescript
echo(options: { value: string; }) => Promise<{ value: string; }>
```

Echoes the provided value.

| Param         | Type                            | Description                                    |
| ------------- | ------------------------------- | ---------------------------------------------- |
| **`options`** | <code>{ value: string; }</code> | An object containing a `value` string to echo. |

**Returns:** <code>Promise&lt;{ value: string; }&gt;</code>

--------------------


### getAppSpace()

```typescript
getAppSpace() => Promise<{ appSpace: string; }>
```

Retrieves the app's memory usage (space used) in KB.

**Returns:** <code>Promise&lt;{ appSpace: string; }&gt;</code>

--------------------

</docgen-api>
