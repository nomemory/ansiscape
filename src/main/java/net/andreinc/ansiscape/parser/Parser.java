package net.andreinc.ansiscape.parser;

import net.andreinc.ansiscape.AnsiClass;
import net.andreinc.ansiscape.AnsiScapeContext;
import net.andreinc.ansiscape.AnsiSequence;
import net.andreinc.ansiscape.parser.tokens.*;
import org.apache.commons.lang3.StringUtils;

import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import static net.andreinc.ansiscape.parser.ParsingException.invalidBracketSerquence;
import static net.andreinc.ansiscape.parser.ParsingException.unknownEscapeClass;

public class Parser {

    private Tokenizer tokenizer;

    private AnsiScapeContext ansiScapeContext;
    private Set<String> classNames;
    private final String source;

    public Parser(AnsiScapeContext ansiScapeContext, String source) {
        this.ansiScapeContext = ansiScapeContext;
        this.classNames = ansiScapeContext.getClassNames();
        this.source = source;
        this.tokenizer = new Tokenizer(source);
    }

    public String parse(String source) {
        if (StringUtils.isEmpty(source)) {
            throw ParsingException.invalidSource();
        }
        StringBuilder buff = new StringBuilder();
        List<Token> tokens = tokenizer.getTokens();
        LinkedList<AnsiClass> ansiClasses = new LinkedList<>();
        for(Token token : tokens) {
            if (token instanceof EscapeClassBegin) {
                // Verify if the escape class is registered in the context
                EscapeClassBegin begin = (EscapeClassBegin) token;
                String escapeClassName = begin.getEscapeClassName();
                AnsiClass ansiClass = ansiScapeContext.get(escapeClassName);
                if (null == ansiClass) {
                    throw unknownEscapeClass(escapeClassName, token.getStartIndex(), source);
                }
                buff.append(ansiClass.getCharSequences());
                ansiClasses.add(ansiClass);
            }
            else if (token instanceof FreeText) {
                buff.append(((FreeText) token).getText());
            }
            else if (token instanceof EscapeClassEnd) {
                if (ansiClasses.isEmpty()) {
                    throw invalidBracketSerquence(token.getStartIndex());
                }
                ansiClasses.removeLast();
                buff.append(AnsiSequence.RESET.getSequence());
                for(AnsiClass ansiClass : ansiClasses) {
                    buff.append(ansiClass.getCharSequences());
                }
            }
        }
        return buff.toString();
    }
}