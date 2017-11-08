import net.andreinc.ansiscape.AnsiClass;
import net.andreinc.ansiscape.AnsiScape;
import net.andreinc.ansiscape.AnsiScapeContext;
import net.andreinc.ansiscape.AnsiSequence;

public class Example2Simple {
    public static void main(String[] args) {
        AnsiScapeContext context = new AnsiScapeContext();

        AnsiClass title = AnsiClass.withName("title").add(AnsiSequence.BOLD);
        AnsiClass url = AnsiClass.withName("url").add(AnsiSequence.UNDERLINE, AnsiSequence.BLUE);
        AnsiClass text = AnsiClass.withName("text").add(AnsiSequence.RED);

        context.add(title).add(url).add(text);

        AnsiScape ansiScape = new AnsiScape(context);

        String format = ansiScape.format("{title Bold title}\n" +
                                                 "-{text Some url: {url www.google.com}};\n" +
                                                 "-{text Some other url: {url {redBg www.redbackground.com}}}");

        System.out.println(format);
    }
}
