package net.andreinc.ansiscape.parser.tokens;

import net.andreinc.ansiscape.parser.ParserUtils;

import java.util.LinkedList;
import java.util.List;

/**
 * This class splits the source String that is going to be formatted into a List of tokens.
 */
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
                // This is where we exit from potential FreeText so everything we collected
                // so far is going to be added in the final list of tokens
                appendExistingFreeText(tokens, freeText, i);
                // We obtain the ascii escape class name
                String escapeClassName = ParserUtils.getUntilSpaceOrEnd(source, i+1);
                tokens.add(new EscapeClassBegin(i, escapeClassName));
                // We skip to the character where the class name ends.
                i+=escapeClassName.length()+1;
            }
            else if (now == CHR_ESCAPE_CLASS_END) {
                // This is where we exit from potential FreeText so everything we collected
                // so far is going to be added in the final list of tokens
                appendExistingFreeText(tokens, freeText, i);
                tokens.add(new EscapeClassEnd(i));
            }
            else {
                freeText.append(now);
            }
            i++;
        }
        // If there was anything in the freetext buffer we add it to the list of tokens
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
