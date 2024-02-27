package domain;

public class LadderGame {

    private final Ladder ladder;
    private final Names names;
    private final Prizes prizes;

    public LadderGame(Ladder ladder, Names names, Prizes prizes) {
        validateCountEqual(ladder, names, prizes);
        this.ladder = ladder;
        this.names = names;
        this.prizes = prizes;
    }

    public LadderResult drive(String name) {
        String prize = prizes.getPrize(ladder.drive(names.indexOf(name)));
        return new LadderResult(prize, name);
    }

    public LadderResults driveAll() {
        return new LadderResults(names.getNames().stream()
                .map(name -> this.drive(name.getName()))
                .toList());
    }

    private void validateCountEqual(Ladder ladder, Names names, Prizes prizes) {
        if (ladder.getColumnCount() != prizes.getPrizeCount()) {
            throw new IllegalArgumentException("[ERROR] 사다리 열과 결과의 개수가 일치하지 않습니다");
        }
    }
}
