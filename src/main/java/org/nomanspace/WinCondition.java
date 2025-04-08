package org.nomanspace;
import org.nomanspace.observer.Event;
import org.nomanspace.observer.Observer;

public class WinCondition implements Observer  {
    private int herbivoreCount = 0; // Счетчик травоядных
    private int grassCount = 0; // Счетчик травы

    public void incrementHerbivoreCount() {
        herbivoreCount++;
        
    }

    public void incrementGrassCount() {
        grassCount++;
        
    }

    public boolean checkWinCondition() {
        if (herbivoreCount >= 4) {
            System.out.println("Хищники победили!");
            // Логика завершения игры
            return true;
        } else if (grassCount >= 4) {
            System.out.println("Травоядные победили!");
            // Логика завершения игры
            return true;
        }
        
    return false;
    }

    @Override
    public void update(Event event) {
        if ("HERBIVORE_EATEN".equals(event.getEventType())) {
            incrementHerbivoreCount();
        } else if ("GRASS_EATEN".equals(event.getEventType())) {
            incrementGrassCount();
        }
    }
}