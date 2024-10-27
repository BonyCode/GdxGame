package com.gdx.game;

import com.gdx.game.hero.*;
import com.gdx.game.weapon.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BattleTest {

    @Test
    public void testWarriorVsArcher() {
        Warrior warrior = new Warrior("Артур", new MeleeWeapon());
        Archer archer = new Archer("Робин", new RangedWeapon());

        int warriorDamage = warrior.weapon.getDamage();
        int archerDamage = archer.weapon.getDamage();

        assertTrue(warriorDamage > archerDamage, "Воин должен наносить больше урона, чем лучник");
    }
}

