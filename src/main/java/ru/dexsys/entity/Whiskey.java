package ru.dexsys.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Whiskey extends Alcohol {
    public Whiskey(double alcoholByVolume) {
        super(alcoholByVolume);
    }

    @Override
    public String toString() {
        return "It's whiskey. Strong!";
    }
}
