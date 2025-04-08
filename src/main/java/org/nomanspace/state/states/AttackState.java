package org.nomanspace.state.states;

import org.nomanspace.Entity.Herbivore;
import org.nomanspace.Entity.Predator;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.observer.Event;
import org.nomanspace.state.Context;
import org.nomanspace.state.State;

public class AttackState implements State {

    SimulationMap map;

    public AttackState(SimulationMap map) {
        this.map = map;
    }

    @Override
    public void execute(Context context) {
        Predator attacker = (Predator) context.getCreature();
        Herbivore victim = (Herbivore) context.getCurrentTarget().getEntity();
        
        victim.takeDamage(attacker.damageDeal());
        if (victim.getHp() <= 0) {
            Event event = new Event("HERBIVORE_EATEN", victim);
            map.notifyObservers(event);
            context.getMap().removeEntity(context.getCurrentTarget().getPosition());
        }
        // После атаки возвращаемся к поиску цели
        context.setState(new SearchTargetState(map));
        context.executeState();
    }
}
