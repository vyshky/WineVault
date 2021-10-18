package ru.dexsys.exception;

public class NoBarrelInStockException extends RuntimeException {

    public NoBarrelInStockException(String str) {
        super(str);
    }
}
