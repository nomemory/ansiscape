# AnsiScape

**AnsiScape** is a simple Java library that allows the user to format the output of the applications using [ANSI Escape Codes](https://en.wikipedia.org/wiki/ANSI_escape_code).


### Example (1)

```java
AnsiScape asciiScape = new AnsiScape();

String formatted = asciiScape.format("{b Some Bold Text {u Also Underlined}}");
String formatted2 = asciiScape.format("Romanian Flag {redBg    }{yellowBg    }{blueBg    }");

System.out.println(formatted);
System.out.println(formatted2);
```

The output:

![Example1Simple.png](https://github.com/nomemory/asciiscape/blob/master/examples/Example1Simple.png)

### Example (2)

In this example we are defining our own escape codes classes (in a way similar to CSS classes):

```java
AnsiScapeContext context = new AnsiScapeContext();

// Create new escape classes that can be used as tags inside the text
AnsiClass title = AnsiClass.withName("title").add(AnsiSequence.BOLD);
AnsiClass url = AnsiClass.withName("url").add(AnsiSequence.UNDERLINE, AnsiSequence.BLUE);
AnsiClass text = AnsiClass.withName("text").add(AnsiSequence.RED);

context.add(title).add(url).add(text);

AnsiScape ansiScape = new AnsiScape(context);

String format = ansiScape.format("{title Bold title}\n" +
                                                 "-{text Some url: {url www.google.com}};\n" +
                                                 "-{text Some other url: {url {redBg www.redbackground.com}}}");

System.out.println(format);
```
The output:

![Example2Simple.png](https://github.com/nomemory/asciiscape/blob/master/examples/Example2Simple.png)

### Supported classes

By default the following escape classes can be used:

| Escape Class  |  Description |
| ------------- | -------------|
| `{b }` | Bold text |
| `{bold }` | Bold text |
| `{dim }` | Dim text |
| `{u }` | Underlined text |
| `{underline }` | Underlined text |
| `{blink }` | Blink text |
| `{reverse }` | Reverse text |
| `{blank }` | Blank |
| `{overstrike }` | Overstrike text |
| `{reset }` | Resets everything inside tag |
| `{black }` | Black foreground |
| `{blackBg }` | Black background |
| `{red }` | Red foreground |
| `{redBg }` | Red foreground |
| `{green }` | Green foreground |
| `{greenBg }` | Green background |
| `{yellow }` | Yellow foreground |
| `{yellowBg }` | Yellow background |
| `{blue }` | Blue foreground |
| `{blueBg }` | Blue background |
| `{magenta }` | Magenta foreground |
| `{magentaBg }` | Magenta background |
| `{cyan }` | Cyan foreground |
| `{cyanBg }` | Cyan background |
| `{white }` | White foreground |
| `{whiteBg }` | White background |

### Notes

- Library woks well with Linux and Mac terminals. It wasn't tested on Windows, but as far as I know it won't work on Windows XP or older `cmd.exe` terminals without additional hacks ;
- In this stage the library is **experimental** - there are no unit tests for the moment;
- Some terminals (like IntelliJ Output Console) do not implement all the ascii codes. 

