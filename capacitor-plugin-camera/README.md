# capacitor-plugin-camera

Get Front Camera Capacity in MP

## Install

```bash
npm install capacitor-plugin-camera
npx cap sync
```

## API

<docgen-index>

* [`echo(...)`](#echo)
* [`getCameraInfo()`](#getcamerainfo)
* [Type Aliases](#type-aliases)

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


### getCameraInfo()

```typescript
getCameraInfo() => Promise<{ cameras?: Record<string, string>; error?: string; }>
```

**Returns:** <code>Promise&lt;{ cameras?: <a href="#record">Record</a>&lt;string, string&gt;; error?: string; }&gt;</code>

--------------------


### Type Aliases


#### Record

Construct a type with a set of properties K of type T

<code>{ [P in K]: T; }</code>

</docgen-api>
