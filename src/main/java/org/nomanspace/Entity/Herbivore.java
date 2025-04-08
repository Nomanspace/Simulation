package org.nomanspace.Entity;

import org.nomanspace.Simulation;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.state.State;
import org.nomanspace.state.states.EatState;

public class Herbivore extends Creature {
    SimulationMap simulationMap;
    private static final int DEFAULT_HP = 4;
    private static final int DEFAULT_SPEED = 1;
    

    //private int hp;                
    //private int final speed;       
    
    public Herbivore(SimulationMap simulationMap) {
        super(DEFAULT_HP, DEFAULT_SPEED);
        this.simulationMap = simulationMap;
    }
    
    public Herbivore(int hp, int speed) {
        super(hp, speed);
        //this.hp = hp;
        //this.speed = speed;
    }
    
    @Override
    public void takeDamage(int incomingDamage) {
        int currentHP = getHp() - incomingDamage;
        setHp(currentHP);
    }
    
    /* public int getHp() {
        return super.hp;
    } */

    /* public void setHp(int hp) {
        super.hp = hp;
    } */

    
    /* public int getSpeed() {
        return speed;
    } */

    @Override
    public void makeMove() {

    }

    @Override
    public String getAvatar() {
        return "[ H ] ";
    }

    @Override
    public String toString() {
        return "Herbivore";
    }

    @Override
    public State getInteractionState() {
        return new EatState(simulationMap);
    }

}
