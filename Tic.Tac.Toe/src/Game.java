
import java.util.Scanner;

public class Game {
    ZeroPlayer zeroPlayer;
    CrossPlayer crossPlayer;
    ComputerPlayer computerPlayer;

    public Game() {
        this.zeroPlayer = new ZeroPlayer();
        this.crossPlayer = new CrossPlayer();
        this.computerPlayer = new ComputerPlayer();
    }

    public void startGamers() {
        Thread crossGamer = new Thread(crossPlayer);
        Thread computerGamer = new Thread(computerPlayer);
//        Thread zeroGamer = new Thread(zeroPlayer);
        crossGamer.start();
        computerGamer.start();
//        zeroGamer.start();
    }

    public void startGame() {
        PlayingField.getInstance().newField();
        startGamers();
    }
}
