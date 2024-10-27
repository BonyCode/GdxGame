package com.gdx.game;

import com.gdx.game.weapon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeaponTest {

    @Test
    public void testMeleeWeaponDamage() {
        MeleeWeapon meleeWeapon = new MeleeWeapon();
        assertEquals(15, meleeWeapon.getDamage(), "Ожидаемый урон ближнего оружия — 15");
    }

    @Test
    public void testRangedWeaponDamage() {
        RangedWeapon rangedWeapon = new RangedWeapon();
        assertEquals(10, rangedWeapon.getDamage(), "Ожидаемый урон дальнего оружия — 10");
    }
}

