package com.gdx.game.hero;

import com.gdx.game.weapon.RangedWeapon;

public class Archer extends Hero<RangedWeapon> {
    public Archer(String name, RangedWeapon weapon) {
        super(name, weapon);
    }

    @Override
    public void attack() {
        System.out.println(name + " стреляет с уроном: " + weapon.getDamage());
    }
}

