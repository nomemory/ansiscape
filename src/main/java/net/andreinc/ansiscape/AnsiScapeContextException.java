package net.andreinc.ansiscape;

public class AnsiScapeContextException extends RuntimeException {

    public static final AnsiScapeContextException asciiClassAlreadyDefined(String className) {
        return new AnsiScapeContextException(String.format("The '%s' already exists in the context. Please choose another name.", className));
    }

    public AnsiScapeContextException(String msg) {
        super(msg);
    }
}
