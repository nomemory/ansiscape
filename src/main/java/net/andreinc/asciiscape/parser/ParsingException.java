package net.andreinc.asciiscape.parser;

public class ParsingException extends RuntimeException {

    public static final ParsingException unknownEscapeClass(String className, int index, String source) {
        return new ParsingException(String.format("Unknown escape class: %s. At index: %d on line \'%s`'"));
    }

    public ParsingException(String msg) {
        super(msg);
    }
}
