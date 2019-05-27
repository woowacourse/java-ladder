/*
 * @(#)PlayerTags.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.tags;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
public class PlayerTags extends Tags {
        /*사다리게임의 플레이어 태그 그룹에 대한 클래스*/
        private static final String DUPLICATE_TAG_ERROR = "중복 이름 오류";

        public PlayerTags(String[] input) {
                super();
                addTags(input);
        }

        @Override
        protected void addTags(String[] input) {
                for (String tag : input) {
                        checkDuplicateName(tag);
                        tags.add(new Tag(tag));
                }
        }

        private void checkDuplicateName(String name) {
                if (tags.contains(new Tag(name))) {
                        throw new IllegalArgumentException(DUPLICATE_TAG_ERROR);
                }
        }

        public int getTagsNumber() {
                return tags.size();
        }

        public int getIndexByTag(Tag tag) {
                return tags.indexOf(tag);
        }
}
