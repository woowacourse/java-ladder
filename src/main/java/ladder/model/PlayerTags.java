package ladder.model;

import ladder.model.frame.Tags;

import java.util.List;

public class PlayerTags extends Tags {
    private static final String DUPLICATE_TAG_ERROR = "중복 이름 오류";

    public PlayerTags(String input) {
        super(input);
        addTags(input);
    }

    @Override
    protected void addTags(String input) {
        for (String tag : input.split(DELIMITER)) {
            checkDuplicateName(tag);
            tags.add(new Tag(tag));
        }
    }

    private void checkDuplicateName(String name) {
        if (tags.contains(new Tag(name))) {
            throw new IllegalArgumentException(DUPLICATE_TAG_ERROR);
        }
    }

    public List<Tag> getTags() {
        return tags;
    }

    public int getTagsNumber() {
        return tags.size();
    }

    public int getIndexByTag(Tag tag) {
        return tags.indexOf(tag);
    }
}
