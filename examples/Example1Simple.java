import net.andreinc.asciiscape.AsciiScape;

public class Example1Simple {
    public static void main(String[] args) {
        AsciiScape asciiScape = new AsciiScape();

        String formatted = asciiScape.format("{b Some Bold Text {u Also Underlined}}");
        String formatted2 = asciiScape.format("Romanian Flag {redBg    }{yellowBg    }{blueBg    }");

        System.out.println(formatted);
        System.out.println(formatted2);
    }
}