package net.andreinc.ansiscape;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.andreinc.ansiscape.parser.Parser;

@NoArgsConstructor
@AllArgsConstructor
public class AnsiScape {

    public static final AnsiScape ascii = new AnsiScape();

    @Getter private AnsiScapeContext context = new AnsiScapeContext();

    public String format(String source, Object... args) {
        Parser parser = new Parser(context, source);
        return String.format(parser.parse(source), args);
    }

    public static void main(String[] args) {
        System.out.println("\u2554\u2550\u2550\u2557");
        System.out.println("\u2551aa\u2551");
        System.out.println("\u255A\u2550\u2550\u255D");
    }
}
