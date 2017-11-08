package net.andreinc.ansiscape.parser;

public class ParsingException extends RuntimeException {

    public static final ParsingException unknownEscapeClass(String className, int index, String source) {
        return new ParsingException(String.format("Unknown escape class: %s. At index: %d on line \'%s`'"));
    }

    public static final ParsingException invalidBracketSerquence(int index) {
        return new ParsingException(String.format("Invalid bracket sequence detected at index: %d.", index));
    }

    public ParsingException(String msg) {
        super(msg);
    }
}
