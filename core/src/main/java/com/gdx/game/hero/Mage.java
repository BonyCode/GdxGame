package com.gdx.game.hero;

public class Mage extends Hero<Void> {
    public Mage(String name) {
        super(name, null);
    }

    @Override
    public void attack() {
        System.out.println(name + " использует магию!");
    }
}

