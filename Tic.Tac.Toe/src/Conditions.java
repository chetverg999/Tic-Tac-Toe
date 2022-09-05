
public class Conditions {
    PlayingField playingField;

    public Conditions() {
        playingField = new PlayingField();
    }

    public char gvf(int i) {  // получение значения поля по его координате
        return playingField.getField().get(i);
    }

    public void checkCondition() { // проверка состояния выигрыша
        if (gvf(1) == gvf(5) && gvf(1) == gvf(9) ||
                gvf(3) == gvf(5) && gvf(3) == gvf(7) ||
                gvf(1) == gvf(2) && gvf(1) == gvf(3) ||
                gvf(7) == gvf(8) && gvf(7) == gvf(9) ||
                gvf(1) == gvf(4) && gvf(1) == gvf(7) ||
                gvf(3) == gvf(6) && gvf(3) == gvf(9) ||
                gvf(4) == gvf(5) && gvf(4) == gvf(6) ||
                gvf(2) == gvf(5) && gvf(2) == gvf(8)) {
            System.out.println("Вы выиграли!");
            playingField.setGameStatus(false); // остановка потоков
            System.exit(0); // выход из игры
        }
    }

}
