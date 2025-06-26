package SeaBattle;

import java.util.Arrays;
import java.util.Scanner;

public class Game {
    public static void main(String[] args) {
        System.out.println("Добро пожаловать в игру Морской бой");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Первый игрок введите ваше имя: ");
        Player player1 = new Player(scanner.nextLine());
        System.out.print("Второй игрок введите ваше имя: ");
        Player player2 = new Player(scanner.nextLine());
        player1.placedShips(scanner);
        player2.placedShips(scanner);
    }
}
