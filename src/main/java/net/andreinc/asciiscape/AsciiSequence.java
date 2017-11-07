package net.andreinc.asciiscape;

public class AsciiSequence {

    private static final String ESCAPE_FORMAT = ((char)27) + "[%sm";

    public static final AsciiSequence RESET = new AsciiSequence("0");
    public static final AsciiSequence BOLD = new AsciiSequence("1");
    public static final AsciiSequence DIM = new AsciiSequence("2");
    public static final AsciiSequence UNDERLINE = new AsciiSequence("4");
    public static final AsciiSequence BLINK = new AsciiSequence("5");
    public static final AsciiSequence REVERSE = new AsciiSequence("7");
    public static final AsciiSequence BLANK = new AsciiSequence("8");
    public static final AsciiSequence OVERSTRIKE = new AsciiSequence("9");

    public static final AsciiSequence BLACK = new AsciiSequence("30");
    public static final AsciiSequence BLACK_BG = new AsciiSequence("40");
    public static final AsciiSequence RED = new AsciiSequence("31");
    public static final AsciiSequence RED_BG = new AsciiSequence("41");
    public static final AsciiSequence GREEN = new AsciiSequence("32");
    public static final AsciiSequence GREEN_BG = new AsciiSequence("42");
    public static final AsciiSequence YELLOW = new AsciiSequence("33");
    public static final AsciiSequence YELLOW_BG = new AsciiSequence("43");
    public static final AsciiSequence BLUE = new AsciiSequence("34");
    public static final AsciiSequence BLUE_BG = new AsciiSequence("44");
    public static final AsciiSequence MAGENTA = new AsciiSequence("35");
    public static final AsciiSequence MAGENTA_BG = new AsciiSequence("45");
    public static final AsciiSequence CYAN = new AsciiSequence("36");
    public static final AsciiSequence CYAN_BG = new AsciiSequence("46");
    public static final AsciiSequence WHITE = new AsciiSequence("37");
    public static final AsciiSequence WHITE_BG = new AsciiSequence("47");

    public AsciiSequence(String escape) {
        this.sequence = String.format(ESCAPE_FORMAT, escape);
    }

    private String sequence;
    private int internalValue;

    public String getSequence() {
        return sequence;
    }
}
