package ladder.model;

public class LadderGame {
    private static final String NO_MATCHED_PLAYER_TAG_ERROR = "일치하는 플레이어 이름이 없습니다.";
    private static final String NEW_LINE = "\n";
    private static final String SPACE_COLON_SPACE = " : ";

    private Ladder ladder;
    private PlayerTags playerTags;
    private ResultTags resultTags;

    public LadderGame(PlayerTags playerTags, ResultTags resultTags, Floor floor) {
        this.playerTags = playerTags;
        this.resultTags = resultTags;
        ladder = new Ladder(floor, playerTags.getTagsNumber());
    }

    public String getOneResultByTag(Tag tag) {
        checkNoMatchPlayerTag(tag);
        int index = ladder.findResultTagIndexByIndex(playerTags.getIndexByTag(tag));
        return resultTags.getTagByIndex(index).getValue();
    }

    private void checkNoMatchPlayerTag(Tag tag) {
        if (!playerTags.getTags().contains(tag)) {
            throw new IllegalArgumentException(NO_MATCHED_PLAYER_TAG_ERROR);
        }
    }

    public String getAllResults() {
        StringBuilder sb = new StringBuilder();
        for (Tag tag : playerTags.getTags()) {
            sb.append(tag.getValue())
                    .append(SPACE_COLON_SPACE)
                    .append(getOneResultByTag(tag))
                    .append(NEW_LINE);
        }
        return sb.toString();
    }

    @Override
    public String toString() {
        return playerTags.toString() + NEW_LINE + ladder.toString() + resultTags.toString() + NEW_LINE;
    }
}
