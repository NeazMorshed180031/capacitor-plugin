export interface appsizePlugin {
  /**
   * Echoes the provided value.
   * @param options An object containing a `value` string to echo.
   * @returns A promise that resolves to an object containing the echoed value.
   */
  echo(options: { value: string }): Promise<{ value: string }>;

  /**
   * Retrieves the app's memory usage (space used) in KB.
   * @returns A promise that resolves to an object containing the app's memory usage as a string.
   */
  getAppSpace(): Promise<{ appSpace: string }>;
}
