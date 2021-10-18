package ru.dexsys.entity;


import lombok.Getter;
import lombok.Setter;
import ru.dexsys.paint.Paint;

@Getter
@Setter
public class Barrel {
    private Alcohol alcohol;
    private String label;
    private final double size;
    private double currentFiling;

    public Barrel(double size) {
        this.size = size;
    }

    public Barrel(String label, double size, Alcohol alcohol, double currentFiling) {
        this.label = label;
        this.alcohol = alcohol;
        this.size = size;
        this.currentFiling = currentFiling;
    }

    @Override
    public String toString() {
        if (this == null) {
            throw new NullPointerException();
        }
        return Paint.cyan(alcohol +
                ", size=" + size +
                ", currentFiling=" + currentFiling);
    }
}
