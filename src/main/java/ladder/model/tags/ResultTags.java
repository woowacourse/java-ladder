/*
 * @(#)ResultTags.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.tags;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class ResultTags extends Tags {
    /*사다리게임의 결과 태그 그룹에 대한 클래스*/
    private static final String NO_MATCH_TAGS_NUMBER_ERROR = "플레이어수와 결과수가 다릅니다.";

    public ResultTags(String[] input, int tagsNumber) {
        super();
        addTags(input);
        checkValidNumbers(tagsNumber);
    }

    @Override
    protected void addTags(String[] input) {
        for (String tag : input) {
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
