package utils;

public class SwitchBooleanGenerator implements BooleanGenerator{

    int flag = 1;

    public boolean generate() {
        if (flag == 1) {
            flag = 0;
            return true;
        }
        flag = 1;
        return false;
    }

}
