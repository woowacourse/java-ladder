package laddergame.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Members {
    private static final int NAME_LENGTH_BOUND = 5;

    private List<String> people;

    public Members(List<String> names) {
        checkEmptyNames(names);
        for (String name : names) {
            checkName(name);
        }
        checkDuplicateNames(names);
        this.people = names;
    }

    private void checkEmptyNames(List<String> names) {
        if (names.isEmpty()) {
            throw new IllegalArgumentException("이름이 존재하지 않습니다!");
        }
    }

    private void checkDuplicateNames(List<String> names) {
        Set<String> nonDuplicateNames = new HashSet<>(names);
        if (names.size() != nonDuplicateNames.size()) {
            throw new IllegalArgumentException("중복된 이름은 불가능합니다.");
        }
    }

    private void checkName(String name) {
        if (StringUtils.isBlank(name)) {
            throw new IllegalArgumentException("입력값이 잘못되었습니다!");
        }
        if (name.length() > NAME_LENGTH_BOUND) {
            throw new IllegalArgumentException("이름은 5자 이내여야 합니다.");
        }
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
}
