
public class Conditions {

    public char getValueOfField(int i) {  // получение значения поля по его координате
        return PlayingField.getInstance().getField().get(i);
    }

    public boolean checkCondition() { // проверка состояния выигрыша

        for (int i = 1; i < 4; i++) {
            if ((getValueOfField(i) == getValueOfField(i + 1) && getValueOfField(i) == getValueOfField(i + 2)) ||
                    (getValueOfField(i) == getValueOfField(i + 3) && getValueOfField(i) == getValueOfField(i + 6))) {
                return true;
            }
        }

        for (int i = 1; i < 4; i++) {
            if ((getValueOfField(i) == getValueOfField(i + 4) && getValueOfField(i) == getValueOfField(i + 8)) ||
                    (getValueOfField(i) == getValueOfField(i + 2) && getValueOfField(i) == getValueOfField(i + 4))) {
                return true;
            }
        }
        return false;
    }
}
