package org.nomanspace.Entity;

import org.nomanspace.Simulation;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.state.State;
import org.nomanspace.state.states.AttackState;

public class Predator extends Creature {
    private static final int DEFAULT_HP = 2;
    private static final int DEFAULT_SPEED = 1;
    private static final int DEFAULT_DAMAGE = 1;
    SimulationMap simulationMap;
    //private int hp;                
    //private final int speed;
    private final int damage;


    public Predator(SimulationMap simulationMap) {
        super(DEFAULT_HP, DEFAULT_SPEED);
        this.damage = DEFAULT_DAMAGE;
        this.simulationMap = simulationMap;
    }

    public Predator(int hp, int speed, int damage) {
        super(hp, speed);
        //this.hp = hp;
        //this.speed = speed;
        this.damage = damage;
    }



    public int damageDeal() {
        return damage;
    }

    @Override
    public void makeMove() {

    }

    @Override
    public String getAvatar() {
        return "[ P ] ";
    }

    @Override
    public State getInteractionState() {
        return new AttackState(simulationMap);
    }

    @Override
    public void takeDamage(int incomingDamage) {
        int currentHP = getHp() - incomingDamage;
        setHp(currentHP);
    }

}
