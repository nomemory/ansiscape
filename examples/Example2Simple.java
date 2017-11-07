import net.andreinc.asciiscape.AsciiClass;
import net.andreinc.asciiscape.AsciiScape;
import net.andreinc.asciiscape.AsciiScapeContext;
import net.andreinc.asciiscape.AsciiSequence;

public class Example2Simple {
    public static void main(String[] args) {
        AsciiScapeContext context = new AsciiScapeContext();

        AsciiClass title = AsciiClass.withName("title").add(AsciiSequence.BOLD);
        AsciiClass url = AsciiClass.withName("url").add(AsciiSequence.UNDERLINE, AsciiSequence.BLUE);
        AsciiClass text = AsciiClass.withName("text").add(AsciiSequence.RED);

        context.add(title).add(url).add(text);

        AsciiScape asciiScape = new AsciiScape(context);

        String format = asciiScape.format("{title Bold title}\n" +
                                                 "-{text Some url: {url www.google.com}};\n" +
                                                 "-{text Some other url: {url {redBg www.redbackground.com}}}");

        System.out.println(format);
    }
}
