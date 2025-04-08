package org.nomanspace;

import org.nomanspace.action.Action;
import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.render.ImageRender;

import java.util.List;
import java.util.Scanner;

public class Simulation {
    /*
    Главный класс приложения, включает в себя:
    Карту
    Счётчик ходов
    Рендерер поля
    Actions - список действий, исполняемых перед стартом симуляции или на каждом ходу (детали ниже)
     */

    //List<Action> initAction; пока не нужен
    //List<Action> turnAction; пока не нужен
    private SimulationMap simulationMap;
    private ImageRender imageRender;
    private int turnCount;
    private WinCondition winCondition;
    private boolean paused = false;
    private long delay = 2000;
    private final ActionsManager actionsManager;
    private final Object lock;

    public Simulation() {
        this.simulationMap = new SimulationMap();
        actionsManager = new ActionsManager(simulationMap);
        imageRender = new ImageRender(simulationMap);
        simulationMap.registerObserver(imageRender);
        winCondition = new WinCondition();
        simulationMap.registerObserver(winCondition);
        turnCount = 0;
        lock = new Object();
    }

    //просимулировать и отрендерить 1 ход
    //нужно привязать рендер так, что бы он обновлялся тогда, когда на карте происходит, какое-то
    //событие, например: кто-то походил, атаковал или съел что-то.
    public void startSimulation() {
        new Thread(() -> {

            if (turnCount == 0) {
                imageRender.printField(simulationMap);
                actionsManager.initActions();
            }

            while (!winCondition.checkWinCondition()) {
                synchronized (lock) {
                    if (paused) {
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    }
                }
                nextTurn();
                turnCount++;
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }).start();
        
        new Thread(this::handleInput).start();
    }

    private void handleInput() {
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String input = scanner.nextLine();
                if ("p".equalsIgnoreCase(input)) {
                    pause();
                } else if ("c".equalsIgnoreCase(input)) {
                    resume();
                } /* else if ("q".equalsIgnoreCase(input)) {
                stopSimulation();
                break; // Выход из цикла
            } */
            }
        } finally {
            scanner.close();
        }
    }

    public void pause() {
        synchronized (lock) {
            paused = true;
        }
    }

    public void resume() {
        paused = false;
        lock.notify();
    }
    /*

    Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                if (turnCount == 0) {
                    imageRender.printField(simulationMap);
                    actionsManager.initActions();
                }
                while (!winCondition.checkWinCondition()) {
                    nextTurn();
                    turnCount++;

                }
            }
        });

        if (turnCount == 0) {
            imageRender.printField(simulationMap);
            actionsManager.initActions();
        }
        while (!winCondition.checkWinCondition()) {
            nextTurn();
            turnCount++;
        */

    public void nextTurn() {
        actionsManager.turnActions();
        simulationMap.notifyObservers();
        turnCount++;
    }
    //запустить бесконечный цикл симуляции и рендеринга
    //пока условия не выполнены nextTurn()
    //какие-то условия, класс который проверяет условия, например бесконечная игра,
    // тогда надо поддерживать определенное кол-во заполнение хищниками,травой и травоядными
    //приостановить бесконечный цикл симуляции и рендеринга т.е. надо запустить его в потоке используя
    //мультипоточность, что бы через этот метод ставить его на паузу

    // пауза - приостановить по команде или эвенту, который прослушивает клавиатуру
    /* public void pauseSimulation() {

    } */
}
