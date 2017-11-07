package net.andreinc.asciiscape;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static net.andreinc.asciiscape.AsciiSequence.*;

public class AsciiScapeContext {

    private final Map<String, AsciiClass> registeredClasses = new HashMap<>();

    public AsciiScapeContext() {
        initDefaultClasses();
    }

    private void initDefaultClasses() {
        registeredClasses.put("b", AsciiClass.withName("b").add(BOLD));
        registeredClasses.put("bold", AsciiClass.withName("b").add(BOLD));
        registeredClasses.put("dim", AsciiClass.withName("dim").add(DIM));
        registeredClasses.put("u", AsciiClass.withName("u").add(UNDERLINE));
        registeredClasses.put("underline", AsciiClass.withName("underline").add(UNDERLINE));
        registeredClasses.put("blink", AsciiClass.withName("blink").add(BLINK));
        registeredClasses.put("reverse", AsciiClass.withName("reverse").add(REVERSE));
        registeredClasses.put("blank", AsciiClass.withName("blank").add(BLANK));
        registeredClasses.put("overstrike", AsciiClass.withName("overstrike").add(OVERSTRIKE));
        registeredClasses.put("reset", AsciiClass.withName("reset").add(RESET));
        registeredClasses.put("black", AsciiClass.withName("black").add(BLACK));
        registeredClasses.put("blackBg", AsciiClass.withName("blackBg").add(BLACK_BG));
        registeredClasses.put("red", AsciiClass.withName("red").add(RED));
        registeredClasses.put("redBg", AsciiClass.withName("redBg").add(RED_BG));
        registeredClasses.put("green", AsciiClass.withName("green").add(GREEN));
        registeredClasses.put("greenBg", AsciiClass.withName("greenBg").add(GREEN_BG));
        registeredClasses.put("yellow", AsciiClass.withName("yellow").add(YELLOW));
        registeredClasses.put("yellowBg", AsciiClass.withName("yellowBg").add(YELLOW_BG));
        registeredClasses.put("blue", AsciiClass.withName("blue").add(BLUE));
        registeredClasses.put("blueBg", AsciiClass.withName("blueBg").add(BLUE_BG));
        registeredClasses.put("magenta", AsciiClass.withName("magenta").add(MAGENTA));
        registeredClasses.put("magentaBg", AsciiClass.withName("blueBg").add(MAGENTA_BG));
        registeredClasses.put("cyan", AsciiClass.withName("cyan").add(CYAN));
        registeredClasses.put("cyanBg", AsciiClass.withName("cyan").add(CYAN_BG));
        registeredClasses.put("white", AsciiClass.withName("white").add(WHITE));
        registeredClasses.put("whiteBg", AsciiClass.withName("whiteBg").add(WHITE_BG));
    }

    public Set<String> getClassNames() {
        return Collections.unmodifiableSet(registeredClasses.keySet());
    }

    public AsciiScapeContext add(AsciiClass asciiClass) {
        if (registeredClasses.containsKey(asciiClass.getName())) {
            throw new IllegalArgumentException("Class already exists. Cannot add it");
        }
        registeredClasses.put(asciiClass.getName(), asciiClass);
        return this;
    }

    public AsciiScapeContext add(String className, AsciiClass asciiClass) {
        if (registeredClasses.containsKey(className)) {
            throw new IllegalArgumentException("Class already exists. Cannot add it.");
        }
        registeredClasses.put(asciiClass.getName(), asciiClass);
        registeredClasses.put(className, asciiClass);
        return this;
    }

    public AsciiClass get(String className) {
        return registeredClasses.get(className);
    }
}
