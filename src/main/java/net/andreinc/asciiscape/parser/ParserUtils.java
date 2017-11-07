package net.andreinc.asciiscape.parser;

public class ParserUtils {

    public static String getUntilSpaceOrEnd(String source, int start) {
        StringBuilder buff = new StringBuilder();
        for(int i = start; i < source.length() && source.charAt(i) != ' '; ++i) {
            buff.append(source.charAt(i));
        }
        return buff.toString();
    }
}
