package domain.ladder;

public class RandomScaffoldGenerator implements ScaffoldGenerator {

    @Override
    public Scaffold generate() {
        // 33 % 확률로 NONE
        if (twentyFivePercent()) {
            return Scaffold.NONE;
        }
        return Scaffold.EXIST;
    }

    private boolean twentyFivePercent() {
        return (int) (Math.random() * 3) == 0;
    }
}
