package net.andreinc.asciiscape.parser.tokens;

import net.andreinc.asciiscape.parser.ParserUtils;

import java.util.LinkedList;
import java.util.List;

public class Tokenizer {

    private static final char CHR_ESCAPE = '`';
    private static final char CHR_ESCAPE_CLASS_BEGIN = '{';
    private static final char CHR_ESCAPE_CLASS_END = '}';

    public final String source;

    public Tokenizer(String source) {
        this.source = source;
    }

    public List<Token> getTokens() {
        List<Token> tokens = new LinkedList<>();

        int i = 0;
        char now;

        StringBuilder freeText = new StringBuilder();

        while(i < source.length()) {
            now = source.charAt(i);
            // Escape char detected - ignoring next character
            if (now == CHR_ESCAPE) {
                freeText.append(source.charAt(i+1));
                i++;
            }
            else if (now == CHR_ESCAPE_CLASS_BEGIN) {
                appendExistingFreeText(tokens, freeText, i);
                String escapeClassName = ParserUtils.getUntilSpaceOrEnd(source, i+1);
                tokens.add(new EscapeClassBegin(i, escapeClassName));
                i+=escapeClassName.length()+1;
            }
            else if (now == CHR_ESCAPE_CLASS_END) {
                appendExistingFreeText(tokens, freeText, i);
                tokens.add(new EscapeClassEnd(i));
            }
            else {
                freeText.append(now);
            }
            i++;
        }
        appendExistingFreeText(tokens, freeText, i);
        return tokens;
    }

    public void appendExistingFreeText(List<Token> tokens, StringBuilder freeTextBuff, int idx) {
        if (freeTextBuff.length()!=0) {
            tokens.add(new FreeText(idx, freeTextBuff.toString()));
            freeTextBuff.setLength(0);
        }
    }
}
