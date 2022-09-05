
import java.util.Scanner;

public class Game {
    Conditions conditions;
    Scanner scanner;
    int positionZero;
    int positionCross;

    public Game() {
        conditions = new Conditions();
        scanner = new Scanner(System.in);
        positionZero = 10;
        positionCross = 10;
    }

    public int crossDraw() { // рисование крестика
        while (true) {
            System.out.println("Поставьте крестик путем выбора номера клетки");
            conditions.playingField.drawField(); // отображение игрового поля
            if (scanner.hasNextInt()) {
                positionCross = scanner.nextInt();
                if (positionCross > 0 && positionCross < 10
                        && conditions.playingField.getField().get(positionCross) != conditions.playingField.zero
                        && conditions.playingField.getField().get(positionCross) != conditions.playingField.cross) {
                    return positionCross; // при прохождении проверки на валидное значение возвращает координату крестика
                } else System.out.println("Неверное значение");
            } else {
                System.out.println("Неверное значение");
                scanner.next();
            }
        }
    }

    public int zeroDraw() {
        while (true) {
            System.out.println("Поставьте нолик путем выбора номера клетки");
            conditions.playingField.drawField();
            if (scanner.hasNextInt()) {
                positionZero = scanner.nextInt();
                if (positionZero > 0 && positionZero < 10
                        && conditions.playingField.getField().get(positionZero) != conditions.playingField.cross
                        && conditions.playingField.getField().get(positionCross) != conditions.playingField.zero) {
                    return positionZero;
                } else System.out.println("Неверное значение");
            } else {
                System.out.println("Неверное значение");
                scanner.next();
            }

        }
    }

}
