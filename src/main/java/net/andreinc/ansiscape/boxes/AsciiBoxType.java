package net.andreinc.ansiscape.boxes;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@AllArgsConstructor
public class AsciiBoxType {
//    public static final AsciiBoxType STANDARD = new AsciiBoxType("\u250C", "\u2510", )
    @Getter private String upperLeftCorner;
    @Getter private String upperRightCorner;
    @Getter private String horizontal;
    @Getter private String vertical;
    @Getter private String bottomLeftCorner;
    @Getter private String bottomRightCorner;
}
