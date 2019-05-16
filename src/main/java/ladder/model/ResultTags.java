package ladder.model;

import ladder.model.frame.Tags;

public class ResultTags extends Tags {
    private static final String NO_MATCH_TAGS_NUMBER_ERROR = "플레이어수와 결과수가 다릅니다.";

    public ResultTags(String input, int tagsNumber) {
        super(input);
        addTags(input);
        checkValidNumbers(tagsNumber);
    }

    @Override
    protected void addTags(String input) {
        for (String tag : input.split(DELIMITER)) {
            tags.add(new Tag(tag));
        }
    }

    private void checkValidNumbers(int playerNumbers) {
        if (tags.size() != playerNumbers) {
            throw new IllegalArgumentException(NO_MATCH_TAGS_NUMBER_ERROR);
        }
    }

    public Tag getTagByIndex(int index) {
        return tags.get(index);
    }
}
