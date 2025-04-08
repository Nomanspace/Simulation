package org.nomanspace.Entity;

import org.nomanspace.state.State;

public abstract class Creature extends Entity {

    private int hp;
    private final int speed;

    public int getHp() {
        return hp;
    }

    protected void setHp(int hp) {
        this.hp = hp;
    } 

    public int getSpeed() {
        return speed;
    }


    public Creature(int hp, int speed) {
        this.hp = hp;
        this.speed = speed;
    }

    public abstract void takeDamage(int incomingDamage);

    protected abstract void makeMove();
    
    public abstract State getInteractionState();


}
