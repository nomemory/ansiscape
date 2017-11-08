package net.andreinc.ansiscape;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static net.andreinc.ansiscape.AnsiScapeContextException.asciiClassAlreadyDefined;
import static net.andreinc.ansiscape.AnsiSequence.*;

public class AnsiScapeContext {

    private final Map<String, AnsiClass> registeredClasses = new HashMap<>();

    public AnsiScapeContext() {
        initDefaultClasses();
    }

    private void initDefaultClasses() {
        registeredClasses.put("b", AnsiClass.withName("b").add(BOLD));
        registeredClasses.put("bold", AnsiClass.withName("b").add(BOLD));
        registeredClasses.put("dim", AnsiClass.withName("dim").add(DIM));
        registeredClasses.put("u", AnsiClass.withName("u").add(UNDERLINE));
        registeredClasses.put("underline", AnsiClass.withName("underline").add(UNDERLINE));
        registeredClasses.put("blink", AnsiClass.withName("blink").add(BLINK));
        registeredClasses.put("reverse", AnsiClass.withName("reverse").add(REVERSE));
        registeredClasses.put("blank", AnsiClass.withName("blank").add(BLANK));
        registeredClasses.put("overstrike", AnsiClass.withName("overstrike").add(OVERSTRIKE));
        registeredClasses.put("reset", AnsiClass.withName("reset").add(RESET));
        registeredClasses.put("black", AnsiClass.withName("black").add(BLACK));
        registeredClasses.put("blackBg", AnsiClass.withName("blackBg").add(BLACK_BG));
        registeredClasses.put("red", AnsiClass.withName("red").add(RED));
        registeredClasses.put("redBg", AnsiClass.withName("redBg").add(RED_BG));
        registeredClasses.put("green", AnsiClass.withName("green").add(GREEN));
        registeredClasses.put("greenBg", AnsiClass.withName("greenBg").add(GREEN_BG));
        registeredClasses.put("yellow", AnsiClass.withName("yellow").add(YELLOW));
        registeredClasses.put("yellowBg", AnsiClass.withName("yellowBg").add(YELLOW_BG));
        registeredClasses.put("blue", AnsiClass.withName("blue").add(BLUE));
        registeredClasses.put("blueBg", AnsiClass.withName("blueBg").add(BLUE_BG));
        registeredClasses.put("magenta", AnsiClass.withName("magenta").add(MAGENTA));
        registeredClasses.put("magentaBg", AnsiClass.withName("blueBg").add(MAGENTA_BG));
        registeredClasses.put("cyan", AnsiClass.withName("cyan").add(CYAN));
        registeredClasses.put("cyanBg", AnsiClass.withName("cyan").add(CYAN_BG));
        registeredClasses.put("white", AnsiClass.withName("white").add(WHITE));
        registeredClasses.put("whiteBg", AnsiClass.withName("whiteBg").add(WHITE_BG));
    }

    public Set<String> getClassNames() {
        return Collections.unmodifiableSet(registeredClasses.keySet());
    }

    public AnsiScapeContext add(AnsiClass ansiClass) {
        if (registeredClasses.containsKey(ansiClass.getName())) {
            throw asciiClassAlreadyDefined(ansiClass.getName());
        }
        registeredClasses.put(ansiClass.getName(), ansiClass);
        return this;
    }

    public AnsiClass get(String className) {
        return registeredClasses.get(className);
    }
}
