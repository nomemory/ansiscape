package net.andreinc.ansiscape.parser;

public class ParserUtils {

    /*
     * Returns all the characters starting from "start" until the end or a space is encountered.
     */
    public static String getUntilSpaceOrEnd(String source, int start) {
        StringBuilder buff = new StringBuilder();
        for(int i = start; i < source.length() && source.charAt(i) != ' '; ++i) {
            buff.append(source.charAt(i));
        }
        return buff.toString();
    }
}
