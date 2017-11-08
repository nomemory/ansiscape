package net.andreinc.ansiscape.parser.tokens;

import lombok.Getter;

public class EscapeClassBegin extends Token {

    @Getter private String escapeClassName;

    public EscapeClassBegin(int index, String escapeClassName) {
        super(index);
        this.escapeClassName = escapeClassName;
    }

    @Override
    public String toString() {
        return "ESCAPE_CLASS_BEGIN:" + escapeClassName;
    }
}
