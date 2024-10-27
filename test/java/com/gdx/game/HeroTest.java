package com.gdx.game;

import com.gdx.game.hero.*;
import com.gdx.game.weapon.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HeroTest {

    @Test
    public void testWarriorAttack() {
        Warrior warrior = new Warrior("Артур", new MeleeWeapon());
        assertEquals(15, warrior.weapon.getDamage(), "Воин должен наносить урон 15");
    }

    @Test
    public void testArcherAttack() {
        Archer archer = new Archer("Робин", new RangedWeapon());
        assertEquals(10, archer.weapon.getDamage(), "Лучник должен наносить урон 10");
    }

    @Test
    public void testMageAttack() {
        Mage mage = new Mage("Мерлин");
        mage.attack(); // Проверка вызова метода магической атаки
    }
}

