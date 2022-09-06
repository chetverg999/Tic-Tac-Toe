public class ComputerPlayer implements Runnable {

    private final Conditions conditions;
    private final PlayingField playingField;
    private final Constants constants;
    private final DrawSome drawSome;

    public ComputerPlayer(Conditions conditions, PlayingField playingField, Constants constants, DrawSome drawSome) {
        this.conditions = conditions;
        this.playingField = playingField;
        this.constants = constants;
        this.drawSome = drawSome;
    }

    @Override
    public void run() {
        synchronized (playingField.getField()) {
            while (!conditions.checkCondition()) {

                drawSome.computerMove();
                playingField.getField().put(drawSome.getPositionZero(), constants.getZero());
                if (conditions.checkCondition()) {
                    System.out.println("Компьютер выиграл, играя за нолики!");
                    playingField.drawField();
                }
                playingField.getField().notify();
                try {
                    playingField.getField().wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e + "Ошибка потока, перезапустите игру");
                }
            }
        }
    }
}