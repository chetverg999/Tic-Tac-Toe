
public class PlayersActions {

    DrawSome drawSome = new DrawSome();
    Conditions conditions = new Conditions();
    Constants constants = new Constants();


    public void zeroPlayer() {
        synchronized (PlayingField.getInstance().getField()) {
            while (!conditions.checkCondition()) {
                drawSome.zeroDraw();
                PlayingField.getInstance().getField().put(drawSome.positionZero, constants.zero);
                if (conditions.checkCondition()) {
                    System.out.println("Вы выиграли, играя за нолики!");
                    PlayingField.getInstance().drawField();
                }
                PlayingField.getInstance().getField().notify();
                try {
                    PlayingField.getInstance().getField().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e + "Ошибка потока, перезапустите игру");
                }
            }
        }
    }

        public void crossPlayer() {
            synchronized (PlayingField.getInstance().getField()) {
                while (!conditions.checkCondition()) {
                    drawSome.crossDraw(); // ввод координат крестика
                    PlayingField.getInstance().getField().put(drawSome.positionCross, constants.cross);
                    if (conditions.checkCondition()) {
                        System.out.println("Вы выиграли, играя за крестики!");
                        PlayingField.getInstance().drawField();
                    }
                    PlayingField.getInstance().getField().notify();
                    try {
                        PlayingField.getInstance().getField().wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e + "Ошибка потока, перезапустите игру");
                    }
                }
            }
        }

        public void computerPlayer() {
            synchronized (PlayingField.getInstance().getField()) {
                while (!conditions.checkCondition()) {

                    drawSome.computerMove();
                    PlayingField.getInstance().getField().put(drawSome.positionZero, constants.zero);
                    if (conditions.checkCondition()) {
                        System.out.println("Компьютер выиграл, играя за нолики!");
                        PlayingField.getInstance().drawField();
                    }
                    PlayingField.getInstance().getField().notify();
                    try {
                        PlayingField.getInstance().getField().wait();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e + "Ошибка потока, перезапустите игру");
                    }
                }
            }
        }
    }

