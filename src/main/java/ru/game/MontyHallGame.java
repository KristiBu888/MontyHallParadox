package ru.game;

import lombok.Getter;
import java.util.Random;

@Getter
public class MontyHallGame {
    private final int winningDoor; // Дверь с выигрышем
    private int chosenDoor; // Дверь, выбранная игроком
    private int revealedDoor; // Дверь, которую ведущий открывает, чтобы показать, что за ней нет приза
    private boolean playerSwitched; // Флаг, показывающий, сменил ли игрок выбор

    public MontyHallGame() {
        Random random = new Random();
        this.winningDoor = random.nextInt(3) + 1; // Устанавливаем случайную дверь с выигрышем (1, 2 или 3)
        this.chosenDoor = random.nextInt(3) + 1; // Изначально выбираем случайную дверь для игрока
    }

    public void revealDoor() {
        // Открываем одну из дверей, чтобы показать, что за ней нет приза
        for (int door = 1; door <= 3; door++) {
            // Находим дверь, которая не выигрышная и не выбрана игроком
            if (door != winningDoor && door != chosenDoor) {
                revealedDoor = door; // Открываем эту дверь
                return; // Завершаем метод, когда нашли подходящую дверь
            }
        }
        // Если по какой-то причине подходящая дверь не найдена, выбрасываем исключение
        throw new InvalidGameException("Не удалось открыть дверь после нескольких попыток.");
    }

    public void switchChoice() {
        // Если игрок решил сменить выбор, выбираем оставшуюся дверь
        playerSwitched = true;
        chosenDoor = 6 - chosenDoor - revealedDoor; // Формула для получения оставшейся двери
    }

    public boolean isPlayerWin() {
        // Проверяем, совпадает ли окончательный выбор игрока с выигрышной дверью
        return chosenDoor == winningDoor;
    }
}
