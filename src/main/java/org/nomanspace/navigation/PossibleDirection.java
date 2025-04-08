package org.nomanspace.navigation;

public class PossibleDirection {


    /*private void entityReplace(Entity entity, Map map) {
        //int oldY = entity.getCurrentCoordinateY();
        Vertex old;
        //int oldX = entity.getCurrentCoordinateX();
        map.placeGameEntity(, entity);
        map.removeEntity();
    }*/

    // нужен еще 1 метод, который будет возвращать нужный енам в зависимости от вычислений на основе желаемого
    // и текущего х у
   /* public Vertex delta(Direction direction) {
        switch (direction) {
            case UPSTEP:
                //entityReplace(entity, map, direction.getY(), direction.getX());
                return new Vertex(direction.)
                break;
            case DOWNSTEP:
                //entityReplace(entity, map, direction.getY(), direction.getX());
                break;
            case LEFTSTEP:
                //entityReplace(entity, map, direction.getY(), direction.getX());
                break;
            case RIGHTSTEP:
                //entityReplace(entity, map, direction.getY(), direction.getX());
                break;
        }
    }
*/
    /*private int upBoardLine = 0;
    private int downBoardLine = 7;
    private int leftBoardLine = 0;
    private int rightBoardLine = 11;*/


    /*public void upStep(Entity entity, Map map) {
        //Таки прикрутить дженерики?
        Creature creature = (Creature) entity;
        //основная логика направления, как ее выделить в общий метод?
        //мое игровое поле можно рассматривать как систему счисления, тогда движения вниз и вверх это смещение на основание
        //что бы пойти вверх это смещение на 1 "десяток" в моем случае на 12 клеток,
        // а смещение по диагонали это + или - от смещения
        // на десяток

        int step = creature.getSpeed();
        int possibleUpStep = creature.getCurrentCoordinateY() - step;
        //точно ли нужна эта проверка?
        if (!(possibleUpStep >= upBoardLine)) {
            System.out.println("Существо пытается выйти за границы карты");
            return;
        }
        //нижеследующий код это отдельный метод
        Entity tempEntity = map.getGameEntity(possibleUpStep, creature.getCurrentCoordinateX());
        if (tempEntity == null) {
            tempEntity = creature;
            map.placeGameEntity(possibleUpStep, creature.getCurrentCoordinateX(), entity);
            map.removeEntity(tempEntity.getCurrentCoordinateY(), tempEntity.getCurrentCoordinateX());
        }

    }*/

}
