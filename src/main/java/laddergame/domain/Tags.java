package laddergame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Tags {
    private List<Tag> tags;

    public Tags(List<String> names) {
        this.tags = names.stream()
                .map(Tag::new)
                .collect(Collectors.toList());
    }

    public List<String> getTagsName() {
        return tags.stream()
                .map(Tag::getName)
                .collect(Collectors.toList());
    }

    public Tag getTag(int index) {
        return tags.get(index);
    }

    public int size() {
        return tags.size();
    }
}
