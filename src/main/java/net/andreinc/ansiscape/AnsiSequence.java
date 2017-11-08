package net.andreinc.ansiscape;

import lombok.Getter;

import static org.apache.commons.lang3.StringUtils.isEmpty;

public class AnsiSequence {

    private static final String ESCAPE_FORMAT = ((char)27) + "[%sm";

    public static final AnsiSequence RESET = new AnsiSequence("0");
    public static final AnsiSequence BOLD = new AnsiSequence("1");
    public static final AnsiSequence DIM = new AnsiSequence("2");
    public static final AnsiSequence UNDERLINE = new AnsiSequence("4");
    public static final AnsiSequence BLINK = new AnsiSequence("5");
    public static final AnsiSequence REVERSE = new AnsiSequence("7");
    public static final AnsiSequence BLANK = new AnsiSequence("8");
    public static final AnsiSequence OVERSTRIKE = new AnsiSequence("9");

    public static final AnsiSequence BLACK = new AnsiSequence("30");
    public static final AnsiSequence BLACK_BG = new AnsiSequence("40");
    public static final AnsiSequence RED = new AnsiSequence("31");
    public static final AnsiSequence RED_BG = new AnsiSequence("41");
    public static final AnsiSequence GREEN = new AnsiSequence("32");
    public static final AnsiSequence GREEN_BG = new AnsiSequence("42");
    public static final AnsiSequence YELLOW = new AnsiSequence("33");
    public static final AnsiSequence YELLOW_BG = new AnsiSequence("43");
    public static final AnsiSequence BLUE = new AnsiSequence("34");
    public static final AnsiSequence BLUE_BG = new AnsiSequence("44");
    public static final AnsiSequence MAGENTA = new AnsiSequence("35");
    public static final AnsiSequence MAGENTA_BG = new AnsiSequence("45");
    public static final AnsiSequence CYAN = new AnsiSequence("36");
    public static final AnsiSequence CYAN_BG = new AnsiSequence("46");
    public static final AnsiSequence WHITE = new AnsiSequence("37");
    public static final AnsiSequence WHITE_BG = new AnsiSequence("47");

    public AnsiSequence(String escape) {
        if (isEmpty(escape)) {
            String errFmt =
                    String.format("Invalid escape sequence: '%s'. This should be non-empty.", escape);
            throw new IllegalArgumentException(errFmt);
        }
        this.sequence = String.format(ESCAPE_FORMAT, escape);
    }

    @Getter private String sequence;
}
