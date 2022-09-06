import java.util.Random;
import java.util.Scanner;

public class DrawSome {
    Scanner scanner;
    Random random;
    Constants constants;
    int positionZero;
    int positionCross;

    public DrawSome() {
        scanner = new Scanner(System.in);
        positionZero = 10;
        positionCross = 10;
        random = new Random();
        constants = new Constants();
    }

    public int crossDraw() { // рисование крестика
        while (true) {
            System.out.println("Поставьте крестик путем выбора номера клетки");
            PlayingField.getInstance().drawField(); // отображение игрового поля
            if (scanner.hasNextInt()) {
                positionCross = scanner.nextInt();
                if (positionCross > 0 && positionCross < 10
                        && PlayingField.getInstance().getField().get(positionCross) != constants.zero
                        && PlayingField.getInstance().getField().get(positionCross) != constants.cross) {
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
            PlayingField.getInstance().drawField();
            if (scanner.hasNextInt()) {
                positionZero = scanner.nextInt();
                if (positionZero > 0 && positionZero < 10
                        && PlayingField.getInstance().getField().get(positionZero) != constants.cross
                        && PlayingField.getInstance().getField().get(positionZero) != constants.zero) {
                    return positionZero;
                } else System.out.println("Неверное значение");
            } else {
                System.out.println("Неверное значение");
                scanner.next();
            }
        }
    }

    public int computerMove() {
        boolean status = true;
        while (status) {

            positionZero = random.nextInt(9) + 1;
            if (PlayingField.getInstance().getField().get(positionZero) != constants.cross &&
                    PlayingField.getInstance().getField().get(positionZero) != constants.zero) {
                status = false;
            }
        }
        return positionZero;
    }
}
