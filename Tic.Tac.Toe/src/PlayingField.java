
import java.util.HashMap;
import java.util.Map;

public class PlayingField {

    final char cross = '+';
    final char zero = 'o';
    boolean gameStatus = true;

    Map<Integer, Character> field;

    public PlayingField() {
        field = new HashMap<>();
    }

    public Map<Integer, Character> getField() {
        return field;
    }


    public boolean isGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(boolean gameStatus) {
        this.gameStatus = gameStatus;
    }

    public void newField() {
        field.put(1, '1');
        field.put(2, '2');
        field.put(3, '3');
        field.put(4, '4');
        field.put(5, '5');
        field.put(6, '6');
        field.put(7, '7');
        field.put(8, '8');
        field.put(9, '9');
    }

    public void drawField() {
        System.out.println("  " + field.get(1) + "  |  " + field.get(2) + "  |  " + field.get(3) + "  " + "\n" +
                "------------------" + "\n" +
                "  " + field.get(4) + "  |  " + field.get(5) + "  |  " + field.get(6) + "  " + "\n" +
                "------------------" + "\n" +
                "  " + field.get(7) + "  |  " + field.get(8) + "  |  " + field.get(9) + "  ");
    }
}
