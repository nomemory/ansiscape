package net.andreinc.asciiscape.parser;

import net.andreinc.asciiscape.AsciiClass;
import net.andreinc.asciiscape.AsciiScapeContext;
import net.andreinc.asciiscape.AsciiSequence;
import net.andreinc.asciiscape.parser.tokens.*;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static net.andreinc.asciiscape.parser.ParsingException.unknownEscapeClass;

public class Parser {

    private Tokenizer tokenizer;

    private AsciiScapeContext asciiScapeContext;
    private Set<String> classNames;
    private final String source;

    public Parser(AsciiScapeContext asciiScapeContext, String source) {
        this.asciiScapeContext = asciiScapeContext;
        this.classNames = asciiScapeContext.getClassNames();
        this.source = source;
        this.tokenizer = new Tokenizer(source);
    }

    public String parse(String source) {
        StringBuilder buff = new StringBuilder();
        List<Token> tokens = tokenizer.getTokens();
        LinkedList<AsciiClass> asciiClasses = new LinkedList<>();
        for(Token token : tokens) {
            if (token instanceof EscapeClassBegin) {
                // Verify if the escape class is registered in the context
                EscapeClassBegin begin = (EscapeClassBegin) token;
                String escapeClassName = begin.getEscapeClassName();
                AsciiClass asciiClass = asciiScapeContext.get(escapeClassName);
                if (null == asciiClass) {
                    throw unknownEscapeClass(escapeClassName, token.getStartIndex(), source);
                }
                buff.append(asciiClass.getCharSequences());
                asciiClasses.add(asciiClass);
            }
            else if (token instanceof FreeText) {
                buff.append(((FreeText) token).getText());
            }
            else if (token instanceof EscapeClassEnd) {
                if (asciiClasses.isEmpty()) {
                    throw new IllegalArgumentException("Invalid sequence class close bracket.");
                }
                asciiClasses.removeLast();
                buff.append(AsciiSequence.RESET.getSequence());
                for(AsciiClass asciiClass : asciiClasses) {
                    buff.append(asciiClass.getCharSequences());
                }
            }
        }
        return buff.toString();
    }
}