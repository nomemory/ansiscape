# AsciiScape

**AsciiScape** is a simple Java library that allows the user to format the output of the applications using ASCII Escape Codes.

*Note:* The library is still work in progress:
- Only the MVP features where implemented;
- No Unit Tests;
- Code needs additional refactoring.


### Example

```java
AsciiScape asciiScape = new AsciiScape();

String formatted = asciiScape.format("{b Some Bold Text {u Also Underlined}}");
String formatted2 = asciiScape.format("Romanian Flag {redBg    }{yellowBg    }{blueBg    }");

System.out.println(formatted);
System.out.println(formatted2);
```

The output:

