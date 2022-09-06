
public class Game {
    PlayingField playingField;
    Constants constants;
    DrawSome drawSome;
    Conditions conditions;
    ZeroPlayer zeroPlayer;
    ComputerPlayer computerPlayer;
    CrossPlayer crossPlayer;


    public Game() {
        this.playingField = new PlayingField();
        this.constants = new Constants();
        this.drawSome = new DrawSome(playingField, constants);
        this.conditions = new Conditions(playingField);
        this.zeroPlayer = new ZeroPlayer(conditions, playingField, constants, drawSome);
        this.computerPlayer = new ComputerPlayer(conditions, playingField, constants, drawSome);
        this.crossPlayer = new CrossPlayer(conditions, playingField, constants, drawSome);
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
        playingField.newField();
        startGamers();
    }
}
