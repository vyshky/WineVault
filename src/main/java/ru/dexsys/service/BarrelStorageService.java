package ru.dexsys.service;

import ru.dexsys.entity.Barrel;
import ru.dexsys.exception.BarrelInStockException;
import ru.dexsys.exception.EmptyStorageException;
import ru.dexsys.exception.NoBarrelInStockException;
import ru.dexsys.exception.PointerMatchesException;

import java.util.HashMap;

public class BarrelStorageService {
    private HashMap<String, Barrel> barrels = new HashMap<>();

    public Barrel getBarrel(String str) {

        var tempBarrel = barrels.get(str);
        if (tempBarrel == null) throw new NoBarrelInStockException("На складе нет такой бочки");
        barrels.remove(str);
        return tempBarrel;
    }

    public void saveBarrel(Barrel barrel) {
        if (barrels.containsKey(barrel.getLabel())) {
            throw new BarrelInStockException("Бочка уже на складе : " + barrel.getLabel());
        }
        barrels.put(barrel.getLabel(), barrel);
    }

    public void moveBarrels(BarrelStorageService storage) {
        if (storage == null) throw new NullPointerException("Указатель на null");
        if (this == storage) throw new PointerMatchesException("Указатель на склад совпадает с текущим");
        if (this.barrels.isEmpty()) {
            this.barrels = new HashMap<>(storage.barrels);
        } else this.barrels.putAll(storage.barrels);
        storage.barrels.clear();
    }

    public String getLables() {
        return barrels.keySet().toString();
    }

    @Override
    public String toString() {
        if (barrels.isEmpty()) {
            throw new EmptyStorageException("Склад Пуст");
        }
        return barrels.toString();
    }
}
