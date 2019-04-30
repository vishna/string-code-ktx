# string-code-ktx

string-code-ktx is a set of String Kotlin extensions related to template based code generation.

## Getting started

This repository is hosted via [jitpack](https://jitpack.io/) since it's by far the easiest delivery method while also being pretty transparent to the developer.

Make sure you have added jitpack to the list of your repositories:

```kotlin
maven("https://jitpack.io")
```

Then simply add the `mvel-ktx` dependency

```kotlin
dependencies {
    compile("com.github.vishna:string-code-ktx:master-SNAPSHOT")
}
```

## Example usage

```kotlin
val className  = "main_activity".camelize()

print(className) // prints "MainActivity"
```

For more documentation on API see [string_code.kt](https://github.com/vishna/string-code-ktx/blob/master/src/main/kotlin/dev/vishna/stringcode/string_code.kt) and for more use examples see [string_code_tests.kt](https://github.com/vishna/string-code-ktx/blob/master/src/test/kotlin/dev/vishna/stringcode/string_code_tests.kt)