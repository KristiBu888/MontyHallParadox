package ru.game;

import lombok.Getter; // Импортируем Lombok-аннотацию @Getter, которая автоматически создаст геттеры для полей класса.
import java.util.HashMap; // Импортируем HashMap для хранения результатов игр.

@Getter // Аннотация Lombok, которая генерирует геттеры для всех полей класса.
public class GameSimulator {
    private final int totalGames; // Поле, которое хранит общее количество игр для симуляции.
    private final HashMap<Integer, Boolean> gameResults = new HashMap<>(); // HashMap для хранения результатов каждой игры, где ключ - номер игры, а значение - результат (победа или проигрыш).
    private int wins = 0; // Переменная для хранения количества побед.
    private int losses = 0; // Переменная для хранения количества проигрышей.

    // Конструктор, принимающий количество игр для симуляции.
    public GameSimulator(int totalGames) {
        this.totalGames = totalGames; // Инициализируем поле totalGames значением из параметра конструктора.
    }

    // Метод для запуска симуляции игр с возможностью смены выбора.
    public void runSimulation(boolean switchChoice) {
        for (int i = 1; i <= totalGames; i++) { // Цикл для запуска каждой игры, от 1 до totalGames.
            MontyHallGame game = new MontyHallGame(); // Создаем новый объект игры MontyHallGame для текущей игры.
            game.revealDoor(); // Вызываем метод, чтобы открыть одну из дверей, за которой нет приза.
            if (switchChoice) { // Проверяем, решил ли игрок поменять свой выбор.
                game.switchChoice(); // Если да, игрок меняет выбор двери.
            }
            boolean result = game.isPlayerWin(); // Проверяем, выиграл ли игрок в текущей игре.
            gameResults.put(i, result); // Сохраняем результат текущей игры в HashMap с номером игры как ключом.

            if (result) { // Если результат - победа.
                wins++; // Увеличиваем счетчик побед.
            } else {
                losses++; // Иначе увеличиваем счетчик поражений.
            }
        }
    }

    // Метод для вывода статистики по результатам игр.
    public void printStatistics() {
        System.out.println("Total games played: " + totalGames); // Выводим общее количество сыгранных игр.
        System.out.println("Wins: " + wins); // Выводим количество побед.
        System.out.println("Losses: " + losses); // Выводим количество проигрышей.
        System.out.println("Win percentage: " + (wins * 100.0 / totalGames) + "%"); // Вычисляем и выводим процент побед.
    }
}
