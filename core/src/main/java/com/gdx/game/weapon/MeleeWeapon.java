package com.gdx.game.weapon;

public class MeleeWeapon implements Weapon {
    private static final int DAMAGE = 15; // Фиксированное значение урона для ближнего оружия

    @Override
    public int getDamage() {
        return DAMAGE;
    }
}

