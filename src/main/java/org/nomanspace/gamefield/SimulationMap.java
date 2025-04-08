package org.nomanspace.gamefield;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.NoSuchElementException;

import org.nomanspace.Entity.Entity;
import org.nomanspace.observer.Subject;
import org.nomanspace.observer.Event;
import org.nomanspace.observer.Observer;


public class SimulationMap implements Subject {

    private final Map<Vertex, Entity> gameMap;
    List<Observer> observers;

    private final int cellCount = 96;
    private int rows = 8;
    private int cols = 12;

    public SimulationMap() {
        this.gameMap = new HashMap<>();
        observers = new ArrayList<>();
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }


    public void placeGameEntity(int column, int row, Entity entity) {
        gameMap.put(new Vertex(column, row), entity);
        notifyObservers();
    }

    public Entity getGameEntity(Vertex vertex) {
        return gameMap.get(vertex);
    }


    public void removeEntity(Vertex vertex) {
        gameMap.remove(vertex);
        notifyObservers();
    }

    public void replaceEntity(Vertex fromVertex, Vertex toVertex) {
        Entity tempEntity = gameMap.get(fromVertex);
        gameMap.remove(fromVertex);
        gameMap.put(toVertex,tempEntity);
        notifyObservers();
    }

    public <T extends Entity> List<T> getEntityByType(Class<T> entityType) {
        List<T> result = new ArrayList<>();
        for (Entity entity : gameMap.values()) {
            if (entityType.isInstance(entity)) {
                result.add(entityType.cast(entity));
            }
        }
        return result;
    }

    public <T> Map<Vertex,T> getEntitiesAndVerexByType(Class<T> type) {
        HashMap<Vertex, T> map = new HashMap<>();
        for (Map.Entry<Vertex, Entity> vertexEntityEntry : gameMap.entrySet()) {
            if (type.isInstance(vertexEntityEntry.getValue())) {
                Map.Entry<Vertex, T> vertexTEntry = (Map.Entry<Vertex, T>) vertexEntityEntry;
                map.put(vertexTEntry.getKey(), vertexTEntry.getValue());
                //альтернативный вариант map.put(vertexEntityEntry.getKey(), type.cast(vertexEntityEntry.getValue()));
            }
        }
        return map;
    }
    
    //плохое решение раскрывает реализацию карты 
    public <K, V> K getKeyByValue(Map<K, V> map, V value) {
        K result = null;
        for (Map.Entry<K, V> entry : map.entrySet()) {
            if (value.equals(entry.getValue())) {
                result = entry.getKey();
                break;
            }
        }
        if (result == null) {
            throw new NoSuchElementException("No key found for the given value");
        }
        return result;
    }

    public Vertex obertkagKBV(Entity entity) {
        return getKeyByValue(gameMap, entity);
    }

    public Vertex getEntityPosition(Entity value) {
        Vertex result = null;
        for (Map.Entry<Vertex, Entity> entry : gameMap.entrySet()) {
            if (value.equals(entry.getValue())) {
                result = entry.getKey();
                break;
            }
        }
        if (result == null) {
            throw new NoSuchElementException("No key found for the given value");
        }
        return result;
    }

    public Vertex getEntityPosition1(Entity entity) {
        // Ищем позицию сущности в карте
        return gameMap.entrySet().stream()
            .filter(entry -> entry.getValue().equals(entity))
            .map(Map.Entry::getKey)
            .findFirst()
            .orElse(null);
    }

    public boolean ifVertexExist(Vertex vertex) {
       return gameMap.containsKey(vertex);
    }
    
    public boolean ifEntityExist(Entity entity) {
       return gameMap.containsValue(entity);
    }

    public Map<Vertex, Entity> getGameMap() {
        return this.gameMap;
    }

    public Vertex getRandomEmptyPosition() {
        int attempts = 0;
        final int MAX_ATTEMPTS = 100;

        while(attempts < MAX_ATTEMPTS) {
        int row = (int)(Math.random() * getRows()); 
        int col = (int)(Math.random() * getCols());
        Vertex vertex = new Vertex(col, row);

        if(!ifVertexExist(vertex)) {
            return vertex;
            }
            
        attempts++;
        }
        throw new RuntimeException("Could not find empty position after " + MAX_ATTEMPTS + " attempts");
    }

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) {
       observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        Event event = new Event("UPDATE", this);
            notifyObservers(event);
        
    }
    
    
    public void notifyObservers(Event event) {
        for (Observer observer : observers) {
            observer.update(event); 
        }
    }

}




