package ru.dexsys.Paint;

public class Paint {

    public static String Green(String str) {
        return "\u001B[32m" + str + "\u001B[0m";
    }

    public static String Red(String str) {
        return "\u001B[31m" + str + "\u001B[0m";
    }

    public static String Purple(String str) {
        return "\u001B[35m" + str + "\u001B[0m";
    }

    public static String Cyan(String str) {
        return "\u001B[36m" + str + "\u001B[0m";
    }
}
