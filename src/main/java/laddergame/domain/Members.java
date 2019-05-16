package laddergame.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Members {
    private static final int NAME_LENGTH_BOUND = 5;

    private List<String> people;

    public Members(List<String> names) {
        if (hasDuplicateName(names)) {
            throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
        }
        for (String name : names) {
            checkNameLengthBound(name);
        }
        this.people = names;
    }

    public String getMember(int index) {
        return people.get(index);
    }

    public int size() {
        return people.size();
    }

    public List<String> getMembers() {
        return people;
    }

    private boolean hasDuplicateName(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        return names.size() != nonDuplicateNames.size();
    }

    private void checkNameLengthBound(String name) {
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
    }
}
