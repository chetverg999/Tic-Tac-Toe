
public class Players {
    Game game;

    public Players() {
        game = new Game();
    }

    public void start() {  // старт потоков обоих игроков
        crossPlayer.start();
        zeroPlayer.start();
    }

    Thread crossPlayer = new Thread(() -> { // игрок крестиками
        synchronized (game.conditions.playingField) {
            while (game.conditions.playingField.isGameStatus()) {
                game.crossDraw(); // ввод координат крестика
                game.conditions.playingField.getField().put(game.positionCross, game.conditions.playingField.cross);
                game.conditions.playingField.notify();
                game.conditions.checkCondition(); // проверка состояния выигрыша
                try {
                    game.conditions.playingField.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }

    });

    Thread zeroPlayer = new Thread(() -> {
        synchronized (game.conditions.playingField) {
            while (game.conditions.playingField.isGameStatus()) {
                game.zeroDraw();
                game.conditions.playingField.getField().put(game.positionZero, game.conditions.playingField.zero);
                game.conditions.playingField.notify();
                game.conditions.checkCondition();
                try {
                    game.conditions.playingField.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }
    });
}
