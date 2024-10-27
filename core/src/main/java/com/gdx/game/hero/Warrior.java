package com.gdx.game.hero;

import com.gdx.game.weapon.MeleeWeapon;

public class Warrior extends Hero<MeleeWeapon> {
    public Warrior(String name, MeleeWeapon weapon) {
        super(name, weapon);
    }

    @Override
    public void attack() {
        System.out.println(name + " атакует с уроном: " + weapon.getDamage());
    }
}

