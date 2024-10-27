package com.gdx.game.hero;

import com.gdx.game.weapon.Weapon;

public abstract class Hero<T extends Weapon> {
    protected String name;
    protected T weapon;

    public Hero(String name, T weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public abstract void attack(); // Метод атаки, переопределяемый в подклассах
}

