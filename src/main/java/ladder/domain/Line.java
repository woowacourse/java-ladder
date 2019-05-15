package ladder.domain;

import java.util.List;

public class Line {
    List<Boolean> horizon;

    public Line(List<Boolean> horizon) {
        this.horizon = horizon;
    }

    public List<Boolean> getHorizon() {
        return this.horizon;
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
