package org.nomanspace;

import java.util.List;

import org.nomanspace.action.Action;
import org.nomanspace.action.entityaction.CreatureAction;
import org.nomanspace.action.initmapaction.InitMapAction;
import org.nomanspace.gamefield.SimulationMap;

public class ActionsManager {
    SimulationMap simulationMap;
    CreatureAction creatureAction;
    InitMapAction initMapAction;
    
    public ActionsManager(SimulationMap simulationMap) {
        this.simulationMap = simulationMap;
        this.creatureAction = new CreatureAction(simulationMap);
        this.initMapAction = new InitMapAction(simulationMap);
    }
    

    public void initActions() {
        //подготовка к симуляции расстановка существ и объектов
        initMapAction.handle(simulationMap);
    }

    public void turnActions() {
        creatureAction.handle(simulationMap);
        // управляет действиями такими как передвижение, добавление игровых объектов
        //перебираю карту сущностей сопостовляю\ассоциирую из списка\хэшсета экшенов и запускаю сопоставленное поведение
    }
}
