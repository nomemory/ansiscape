package net.andreinc.ansiscape.parser.tokens;

public class EscapeClassEnd extends Token {

    public EscapeClassEnd(int startIndex) {
        super(startIndex);
    }

    @Override
    public String toString() {
        return "ESCAPE_CLASS_END";
    }
}
