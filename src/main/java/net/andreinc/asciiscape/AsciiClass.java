package net.andreinc.asciiscape;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;

public class AsciiClass {

    private final String name;
    private final List<AsciiSequence> asciiSequences = new ArrayList<>();

    private AsciiClass(String name) {
        this.name = name;
    }

    public static final AsciiClass withName(String name) {
        return new AsciiClass(name);
    }

    public AsciiClass add(AsciiSequence... sequences) {
        for (AsciiSequence seq : sequences) {
            asciiSequences.add(seq);
        }
        return this;
    }

    public AsciiClass add(String escape) {
        add(new AsciiSequence(escape));
        return this;
    }

    public AsciiClass inherit(AsciiClass asciiClass) {
        this.asciiSequences.addAll(asciiClass.asciiSequences);
        return this;
    }

    public String getName() {
        return name;
    }

    public String getCharSequences() {
        return asciiSequences.stream()
                              .map(AsciiSequence::getSequence)
                              .collect(joining(""));
    }

    @Override
    public String toString() {
        return "EscapeClass{" +
                "name='" + name + '\'' +
                ", escapeSequences=" + asciiSequences +
                '}';
    }
}
