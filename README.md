Это пошаговая симуляция 2D-мира, населенного травоядными и хищниками. Кроме существ, в мире есть ресурсы (трава), которыми питаются травоядные, и неподвижные объекты (деревья, камни), с которыми нельзя взаимодействовать — они просто занимают место на карте.
Реализованные возможности:
Действия существ:
Травоядные могут либо двигаться к траве, либо есть её.
Хищники могут либо двигаться к травоядным, либо есть их.
Поиск пути:
Используется алгоритм "поиска в ширину" (Breadth-First Search, BFS, A*). Это метод, который systematically исследует карту уровень за уровнем, находя кратчайший путь.
Алгоритм не строит путь через неподвижные объекты (деревья и камни).
Отображение: Текущее состояние симуляции выводится в консоль (текстовый интерфейс).
