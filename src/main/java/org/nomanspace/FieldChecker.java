package org.nomanspace;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FieldChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = getValidNumber(scanner);
        List<String> combinations = getCombinations(num);
        System.out.println("Возможные размеры поля: " + combinations);
    }

    public static int getValidNumber(Scanner scanner) {
        int num;
        while (true) {
            System.out.println("Введите число клеток (от 1 до 100): ");
            try {
                num = Integer.parseInt(scanner.nextLine());
                if (num > 0 && num <= 100) {
                    return num;
                } else {
                    System.out.println("Число клеток должно быть между 1 и 100. Попробуйте снова.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите целое число.");
            }
        }
    }

    public static List<String> getCombinations(int num) {
        List<String> combinations = new ArrayList<>();

        // Проверка и добавление квадратных комбинаций
        addPerfectSquareCombinations(num, combinations);

        // Проверка на прямоугольник и добавление комбинаций
        addRectangleCombinations(num, combinations);

        // Поиск ближайшего подходящего числа, если не квадрат и не прямоугольник
        if (combinations.isEmpty()) {
            System.out.println("Не был найден прямоугольник или квадрат, ищем ближайшее подходящее под условие число");
            int closestNum = findClosestNumber(num);
            if (closestNum != -1) {
                combinations = getCombinations(closestNum);
            }
        }

        return combinations;
    }

    public static void addPerfectSquareCombinations(int num, List<String> combinations) {
        int sqrt = isPerfectSquare(num);
        if (sqrt != -1) {
            combinations.add(sqrt + "x" + sqrt);
        }
    }

    public static void addRectangleCombinations(int num, List<String> combinations) {
        findRectangleCombinations(num, combinations);
    }

    public static void findRectangleCombinations(int num, List<String> combinations) {
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                int j = num / i;
                combinations.add(i + "x" + j);
                if (i != j) {
                    combinations.add(j + "x" + i);
                }
            }
        }
    }

    public static int isPerfectSquare(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("Число не может быть отрицательным.");
        }
        int sqrt = (int) Math.sqrt(num);
        if (!(sqrt * sqrt == num)) {
            return -1;
        }
        return sqrt;
    }

    public static boolean isRectangle(int num) {
        if (num <= 1) {
            return false;
        }
        List<String> dummyCombinations = new ArrayList<>();
        findRectangleCombinations(num, dummyCombinations);
        return !dummyCombinations.isEmpty();
    }

    public static int findClosestNumber(int num) {
        for (int i = 1; i <= 100; i++) {
            if (num - i > 0 && (isPerfectSquare(num - i) != -1 || isRectangle(num - i))) {
                return num - i;
            }
            if (num + i <= 100 && (isPerfectSquare(num + i) != -1 || isRectangle(num + i))) {
                return num + i;
            }
        }
        return -1;
    }
}