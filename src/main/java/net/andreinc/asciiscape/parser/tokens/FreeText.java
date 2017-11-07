package net.andreinc.asciiscape.parser.tokens;

public class FreeText extends Token {

    private String text;

    public FreeText(int index, String text) {
        super(index);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "FREE_TEXT:" + text;
    }
}
