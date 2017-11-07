package net.andreinc.asciiscape;

import net.andreinc.asciiscape.parser.Parser;

public class AsciiScape {

    public static final String HORIZONTAL_LINE = "\u2500";

    public static final AsciiScape ascii = new AsciiScape();

    private AsciiScapeContext context;

    public AsciiScape() {
        this.context = new AsciiScapeContext();
    }

    public String format(String source, Object... args) {
        Parser parser = new Parser(context, source);
        return String.format(parser.parse(source), args);
    }

    public static void main(String[] args) {
       String f = ascii.format("{redBg red {blink ba}} {blue test}\n");
        System.out.println(f);
    }
}