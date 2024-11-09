package ru.game;

public class Main {
    public static void main(String[] args) {
        GameSimulator simulator = new GameSimulator(1000); // Создаем объект GameSimulator для симуляции 1000 игр.

        System.out.println("Запуск симуляции с возможностью смены выбора..."); // Выводим сообщение о начале симуляции с возможностью смены выбора.
        simulator.runSimulation(true); // Запускаем симуляцию с переключением двери игроком.
        simulator.printStatistics(); // Выводим статистику после завершения симуляции.

        System.out.println("\nЗапуск симуляции без смены выбора..."); // Выводим сообщение о начале симуляции без смены выбора.
        simulator = new GameSimulator(1000); // Создаем новый объект GameSimulator для еще одной симуляции 1000 игр.
        simulator.runSimulation(false); // Запускаем симуляцию без переключения двери игроком.
        simulator.printStatistics(); // Выводим статистику после завершения второй симуляции.
    }
}
