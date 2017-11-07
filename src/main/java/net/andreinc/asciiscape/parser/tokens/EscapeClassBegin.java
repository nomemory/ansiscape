package net.andreinc.asciiscape.parser.tokens;

public class EscapeClassBegin extends Token {

    private String escapeClassName;

    public EscapeClassBegin(int index, String escapeClassName) {
        super(index);
        this.escapeClassName = escapeClassName;
    }

    public String getEscapeClassName() {
        return escapeClassName;
    }

    @Override
    public String toString() {
        return "ESCAPE_CLASS_BEGIN:" + escapeClassName;
    }
}
