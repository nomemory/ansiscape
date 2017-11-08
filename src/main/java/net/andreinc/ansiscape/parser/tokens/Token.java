package net.andreinc.ansiscape.parser.tokens;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * This class represents the token that is obtained when parsing the text that
 * is formatted.
 */
@AllArgsConstructor
public abstract class Token {

    /**
     * The index where the token was first detected.
     */
    @Getter private int startIndex;
}
