package org.nomanspace.action.entityaction;

import org.nomanspace.Entity.Creature;
import org.nomanspace.action.Action;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.state.Context;

import java.util.List;

public class CreatureAction implements Action {

    private final SimulationMap simulationMap;
    //private final PathFinder pathFinder;
    //private final TargetFinder targetFinder;

    public CreatureAction(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
        //this.pathFinder = new PathFinder(simulationMap);
        //this.targetFinder = new TargetFinder(simulationMap);
    }

    @Override
    public void handle(SimulationMap simulationMap) {
        List<Creature> creatures = simulationMap.getEntityByType(Creature.class);
        for (Creature creature : creatures) {
            // что то делать с каждым существом
            //processCreature(creature);
            Context context = new Context(creature, simulationMap);
            context.executeState();
        }
    }

   /*  private void processCreature(Creature creature) {
        // инкапсулирем тут логику поведения существа
        // найти цель для кричи
        Target target = targetFinder.findNearestTarget(creature);
        Vertex currentPosition = simulationMap.getEntityPosition(creature);
        Vertex targetPosition = target.getPosition();
        if(canAttack(currentPosition, targetPosition)) {
            attack(creature, target.getEntity());
        } else {
            //moveToTarget();
        }
        // получить свою позицию
        // получить позицию для цели
        // проверить могу ли атаковать сейчас, если нахожусь в соседних клетках
        // если могу атакую
        // если нет то иду до цели, сокращаю расстояние
        // нужны методы:могу ли атаковать()?, двигаться к цели(), совершить атаку().
    }

    private boolean canAttack(Vertex current, Vertex target) {
        return Math.abs(current.getRow() - target.getRow()) <=1 && 
        Math.abs(current.getColumn() - target.getColumn()) <=1;
    }

    private void attack(Creature attacker, Entity target) {
        
    } */

}
