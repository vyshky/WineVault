package ru;

import ru.dexsys.paint.Paint;
import ru.dexsys.entity.Barrel;
import ru.dexsys.entity.Whiskey;
import ru.dexsys.entity.Wine;
import ru.dexsys.service.BarrelStorageService;

public class Aplication {

    public static void main(String[] args) {
        BarrelStorageService storageService = new BarrelStorageService();
        Barrel barrel = new Barrel("Шампань, урожай 1092 года", 20, new Wine(40), 20);
        Barrel barrel2 = new Barrel("Самогон от соседа", 20, new Wine(90), 20);
        Barrel barrel3 = new Barrel("Виски, урожай 1990 года", 20, new Whiskey(70), 20);
        Barrel barrel4 = new Barrel("03.08.1970", 20, new Whiskey(70), 15);

        // 2) положить бочку с этикеткой. Если такая этикетка есть - выдать ошибку с подробным описанием
        storageService.saveBarrel(barrel);
        //storageService.saveBarrel(barrel);   // Ошибка : Бочка уже на складе : Label
        storageService.saveBarrel(barrel2);
        //storageService.saveBarrel(barrel2);  // Ошибка : Бочка уже на складе : Label
        storageService.saveBarrel(barrel3);
        storageService.saveBarrel(barrel4);

        System.out.println(Paint.cyan("StorageService   - ") + storageService);

        // 1  достать бочку по этикетке.Если такой бочки нет - выдать ошибку с подробным описанием
        //    после этого данная бочка в погребе, соответственно, исчезает

        Barrel someBarrel = storageService.getBarrel("Шампань, урожай 1092 года");
        Barrel someBarrel2 = storageService.getBarrel("03.08.1970");
        // Barrel someBarrel3 = storageService.getBarrel(""); // Ошибка : На складе нет такой бочки
        showBarrelLabel(someBarrel);
        showBarrelLabel(someBarrel2);

        // 3  Достать все бочки из погреба. Погреб остаётся после этого пустым
        BarrelStorageService storageService2 = new BarrelStorageService();
        BarrelStorageService storageService3 = new BarrelStorageService();
        // До перемещения
        //
        System.out.println(Paint.cyan("StorageService   - ") + storageService);
        storageService2.moveBarrels(storageService);
        storageService2.moveBarrels(storageService3);
        // После перемещения
        // System.out.println(storageService); // Ошибка : Склад Пуст

        System.out.println(Paint.cyan("StorageService 2 - ") + storageService2);

        // 4) Выдать список всех этикеток (соотвественно, погреб не изменяется после этого)
        System.out.println(Paint.purple("Lables : " + storageService2.getLables()));
    }

    public static void showBarrelLabel(Barrel barrel) {
        System.out.println(Paint.red(barrel.getLabel()) + " = " + barrel);
    }
}
