package org.nomanspace.render;

import org.nomanspace.gamefield.SimulationMap;
import org.nomanspace.Entity.Entity;
import org.nomanspace.gamefield.Vertex;
import org.nomanspace.observer.Event;
import org.nomanspace.observer.Observer;

public class ImageRender implements Observer {
    private SimulationMap simulationMap;

    public ImageRender(SimulationMap simulationMap) {
            this.simulationMap = simulationMap;
    }


    public void printField(SimulationMap simulationMap) {
        int row = 8;
        int column = 12;

        // Ширина каждого столбца для корректного выравнивания
        String cellFormat = "[ . ] "; //6
        int cellWidth = cellFormat.length();

        // Выводим координаты столбцов
        System.out.print("    "); // Оставляем место для координат строк
        for (int x = 0; x < column; x++) {
            System.out.printf("%-" + cellWidth + "s", "x" + x);
        }
        System.out.println();

        // Проходим по каждой строке
        for (int y = 0; y < row; y++) {
            // Выводим координату строки
            System.out.printf("y%-2d", y);

            // Проходим по каждому столбцу
            for (int x = 0; x < column; x++) {
                Vertex entityVertex = new Vertex(x, y);
                Entity entity = simulationMap.getGameEntity(entityVertex);
                if (entity != null) {
                    System.out.print(entity.getAvatar());
                }
                if (entity == null) {
                    System.out.print(cellFormat);
                }
            }
            // Переход на новую строку после вывода всех столбцов текущей строки
            System.out.println();
        }
    }

    @Override
    public void update(Event event) {
        if ("UPDATE".equals(event.getEventType())) {
        printField(simulationMap);
        }
    }
}
