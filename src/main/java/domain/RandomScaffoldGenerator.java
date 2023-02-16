package domain;

public class RandomScaffoldGenerator implements ScaffoldGenerator {

    @Override
    public Scaffold generate() {
        // 25 % 확률로 NONE
        if (twentyFivePercent()) {
            return Scaffold.NONE;
        }
        return Scaffold.EXIST;
    }

    private boolean twentyFivePercent() {
        return (int) (Math.random() * 4) == 0;
    }
}
