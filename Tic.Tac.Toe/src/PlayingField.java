
import java.util.HashMap;
import java.util.Map;

public class PlayingField {
    private static PlayingField instance;
    private final Map<Integer, Character> field;

    private PlayingField() {
        field = new HashMap<>();
    }

    public static PlayingField getInstance() {
        if (instance == null) {
            instance = new PlayingField();
        }
        return instance;
    }

    public Map<Integer, Character> getField() {
        return field;
    }

    public void newField() { // заполнение поля перед игрой
        for (int i = 1; i < 10; i++) {
            field.put(i, (char) (i + '0'));
        }
    }

    public void drawField() {
        System.out.println("  " + field.get(1) + "  |  " + field.get(2) + "  |  " + field.get(3) + "  " + "\n" +
                "------------------" + "\n" +
                "  " + field.get(4) + "  |  " + field.get(5) + "  |  " + field.get(6) + "  " + "\n" +
                "------------------" + "\n" +
                "  " + field.get(7) + "  |  " + field.get(8) + "  |  " + field.get(9) + "  ");
    }
}
