package ru.dexsys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;


@AllArgsConstructor()
@Getter
public abstract class Alcohol {
    protected final double alcoholByVolume;

    @Override
    public abstract String toString();
}
