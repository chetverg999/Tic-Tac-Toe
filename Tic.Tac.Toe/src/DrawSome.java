import java.util.Random;
import java.util.Scanner;

public class DrawSome {
    private final PlayingField playingField;
    private final Scanner scanner;
    private final Random random;
    private final Constants constants;
    private int positionZero;
    private int positionCross;

    public int getPositionZero() {
        return positionZero;
    }

    public int getPositionCross() {
        return positionCross;
    }

    public DrawSome(PlayingField playingField, Constants constants) {
        this.playingField = playingField;
        this.scanner = new Scanner(System.in);
        this.random = new Random();
        this.constants = constants;
        this.positionZero = 10;
        this.positionCross = 10;
    }

    public void crossDraw() { // рисование крестика
        boolean status = true;
        while (status) {
            System.out.println("Поставьте крестик путем выбора номера клетки");
            playingField.drawField(); // отображение игрового поля
            if (scanner.hasNextInt()) {
                positionCross = scanner.nextInt();
                if (positionCross > 0 && positionCross < 10
                        && playingField.getField().get(positionCross) != constants.getZero()
                        && playingField.getField().get(positionCross) != constants.getCross()) {
                    status = false; // при прохождении проверки на валидное значение возвращает координату крестика
                } else System.out.println("Неверное значение");
            } else {
                System.out.println("Неверное значение");
                scanner.next();
            }
        }
    }

    public void zeroDraw() {
        boolean status = true;
        while (status) {
            System.out.println("Поставьте нолик путем выбора номера клетки");
            playingField.drawField();
            if (scanner.hasNextInt()) {
                positionZero = scanner.nextInt();
                if (positionZero > 0 && positionZero < 10
                        && playingField.getField().get(positionZero) != constants.getCross()
                        && playingField.getField().get(positionZero) != constants.getZero()) {
                    status = false;
                } else System.out.println("Неверное значение");
            } else {
                System.out.println("Неверное значение");
                scanner.next();
            }
        }
    }

    public void computerMove() {
        boolean status = true;
        while (status) {

            positionZero = random.nextInt(9) + 1;
            if (playingField.getField().get(positionZero) != constants.getCross() &&
                    playingField.getField().get(positionZero) != constants.getZero()) {
                status = false;
            }
        }
    }
}
