package ru.dexsys.paint;

public class Paint {

    public static String green(String str) {
        return "\u001B[32m" + str + "\u001B[0m";
    }

    public static String red(String str) {
        return "\u001B[31m" + str + "\u001B[0m";
    }

    public static String purple(String str) {
        return "\u001B[35m" + str + "\u001B[0m";
    }

    public static String cyan(String str) {
        return "\u001B[36m" + str + "\u001B[0m";
    }
}
