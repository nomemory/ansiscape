package net.andreinc.asciiscape.parser.tokens;

public abstract class Token {

    private int startIndex;

    public Token(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getStartIndex() {
        return startIndex;
    }
}
