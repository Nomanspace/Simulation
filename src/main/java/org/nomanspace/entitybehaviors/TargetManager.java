package org.nomanspace.entitybehaviors;

import org.nomanspace.Entity.*;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TargetManager {
    private final Map<Class<? extends Creature>, List<Class<? extends Entity>>> allowedTarget = new HashMap<>();

    {
        allowedTarget.put(Predator.class, List.of(Herbivore.class));
        allowedTarget.put(Herbivore.class, List.of(Grass.class));
    }


    //возможно коллектить таргеты тут  
    public List<Class<? extends Entity>> getAllowedTargets(Class<? extends Creature> creature) {
        List<Class<? extends Entity>> aprovedTargets = allowedTarget.get(creature);
        return aprovedTargets;
        //return allowedTarget.getOrDefault(creature.getClass(), Collections.emptyList());
    }
    

}
