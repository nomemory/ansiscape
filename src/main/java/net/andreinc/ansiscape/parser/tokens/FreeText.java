package net.andreinc.ansiscape.parser.tokens;

import lombok.Getter;

public class FreeText extends Token {

    @Getter private String text;

    public FreeText(int index, String text) {
        super(index);
        this.text = text;
    }

    @Override
    public String toString() {
        return "FreeText{" +
                "text='" + text + '\'' +
                '}';
    }
}
