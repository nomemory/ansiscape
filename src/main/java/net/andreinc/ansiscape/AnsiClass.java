package net.andreinc.ansiscape;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.joining;
import static org.apache.commons.lang3.StringUtils.isAlphanumeric;
import static org.apache.commons.lang3.StringUtils.isEmpty;

public class AnsiClass {

    @Getter private final String name;
    private final List<AnsiSequence> ansiSequences = new ArrayList<>();

    private AnsiClass(String name) {
        this.name = name;
    }

    public static final AnsiClass withName(String name) {
        if (isEmpty(name) || !isAlphanumeric(name)) {
            String errFmt =
                    String.format("Invalid class name: '%s'. The name should be alphanumeric and non-empty.", name);
            throw new IllegalArgumentException(errFmt);
        }
        return new AnsiClass(name);
    }

    public AnsiClass add(AnsiSequence... sequences) {
        for (AnsiSequence seq : sequences) {
            ansiSequences.add(seq);
        }
        return this;
    }

    public AnsiClass add(String escape) {
        if (isEmpty(escape)) {
            String errFmt =
                    String.format("Invalid escape sequence: '%s'. This should be non-empty.", escape);
            throw new IllegalArgumentException(errFmt);
        }
        add(new AnsiSequence(escape));
        return this;
    }

    public AnsiClass inherit(AnsiClass ansiClass) {
        this.ansiSequences.addAll(ansiClass.ansiSequences);
        return this;
    }

    public String getCharSequences() {
        return ansiSequences.stream()
                              .map(AnsiSequence::getSequence)
                              .collect(joining(""));
    }

    @Override
    public String toString() {
        return "EscapeClass{" +
                "name='" + name + '\'' +
                ", escapeSequences=" + ansiSequences +
                '}';
    }
}
