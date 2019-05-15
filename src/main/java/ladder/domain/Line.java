package ladder.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Line {
    private List<Boolean> horizon;

    public Line(int playerNumber) {
        this.horizon = makeRandomBooleans(playerNumber);
    }

    public List<Boolean> getHorizon() {
        return this.horizon;
    }

    private List<Boolean> makeRandomBooleans(int playerNumber){
        List<Boolean> booleans = new ArrayList<>();
        Random random = new Random();
        booleans.add(random.nextBoolean());
        for (int i = 1; i < playerNumber - 1; i++) {
            if (booleans.get(i - 1)) {
                booleans.add(false);
                continue;
            }
            booleans.add(random.nextBoolean());
        }
        return booleans;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("     ");
        for (Boolean bool : this.horizon) {
            sb.append("|");
            sb.append(toStringEachHorLine(bool));
        }
        sb.append("|\n");
        return sb.toString();
    }

    private String toStringEachHorLine(Boolean bool) {
        String result = "     ";
        if (bool) {
            result = "-----";
        }
        return result;
    }

    //
//    public void settingHorizonLine() {
//        for (int i = 0; i < horizon.size(); i++) {
//            settingHorizonOneLine(getaBoolean());
//        }
//    }
//
//    private void settingHorizonOneLine(Boolean randBool) {
//        horizon.add(randBool);
//    }
//
//    public List<Boolean> getRandomBooleans(int playerNum) {
//        List<Boolean> result = new ArrayList<>();
//        for (int i = 0; i < playerNum - 1; i++) {
//            result.add(getaBoolean());
//        }
//        return result;
//    }
//
//    private Boolean getaBoolean() {
//        Random random = new Random();
//        return random.nextBoolean();
//    }
}
