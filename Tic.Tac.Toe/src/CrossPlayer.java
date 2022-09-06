public class CrossPlayer implements Runnable {
    private final Conditions conditions;
    private final PlayingField playingField;
    private final Constants constants;
    private final DrawSome drawSome;

    public CrossPlayer(Conditions conditions, PlayingField playingField, Constants constants, DrawSome drawSome) {
        this.conditions = conditions;
        this.playingField = playingField;
        this.constants = constants;
        this.drawSome = drawSome;
    }

    @Override
    public void run() {
        synchronized (playingField.getField()) {
            while (!conditions.checkCondition()) {
                drawSome.crossDraw(); // ввод координат крестика
                playingField.getField().put(drawSome.getPositionCross(), constants.getCross());
                if (conditions.checkCondition()) {
                    System.out.println("Вы выиграли, играя за крестики!");
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
