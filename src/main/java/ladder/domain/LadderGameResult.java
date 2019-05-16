package ladder.domain;

public class LadderGameResult {

    private int[] ladderResultForUserIndex;

    public LadderGameResult(int[] ladderResultForUserIndex){
        this.ladderResultForUserIndex = ladderResultForUserIndex;
    }

    public int[] getLadderResultForUserIndex() {
        return this.ladderResultForUserIndex;
    }
}
