# AsciiScape

**AsciiScape** is a simple Java library that allows the user to format the output of the applications using [ASCII Escape Codes](https://en.wikipedia.org/wiki/ANSI_escape_code).

#### Example (1)

```java
AsciiScape asciiScape = new AsciiScape();

String formatted = asciiScape.format("{b Some Bold Text {u Also Underlined}}");

// The Romanian Flag
String formatted2 = asciiScape.format("{redBg    }{yellowBg    }{blueBg    }");

System.out.println(formatted);
System.out.println(formatted2);
```

The output:

![Example1Simple.png](https://github.com/nomemory/asciiscape/blob/master/examples/Example1Simple.png)

#### Example (2)

In this example we are defining our own escape codes classes (in a way similar to CSS classes):

```java
AsciiScapeContext context = new AsciiScapeContext();

AsciiClass title = AsciiClass.withName("title").add(BOLD);
AsciiClass url = AsciiClass.withName("url").add(UNDERLINE, BLUE);
AsciiClass text = AsciiClass.withName("text").add(RED);

// We register all the classes in the AsciiEscape context.
// Those classes will become available in String template.
context.add(title).add(url).add(text);

AsciiScape asciiScape = new AsciiScape(context);

String format = asciiScape.format("{title Bold title}\n" +
                                         "-{text Some url: {url www.google.com}};\n" +
                                         "-{text Some other url: {url {redBg www.redbackground.com}}}");

System.out.println(format);
```
The output:

![Example2Simple.png](https://github.com/nomemory/asciiscape/blob/master/examples/Example2Simple.png)

#### Notes

- Library woks well with Linux and Mac terminals. It wasn't tested on Windows, but as far as I know it won't work on Windows XP or older `cmd.exe` terminals without additional hacks ;
- In this stage the library is **experimental** - there are no unit tests for the moment;
- Some terminals (like IntelliJ Output Console) do not implement all the ascii codes. 
