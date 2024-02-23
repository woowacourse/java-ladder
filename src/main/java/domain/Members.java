package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Members {

    private static final int MIN_MEMBER_COUNT = 2;
    private static final int MAX_MEMBER_COUNT = 15;

    private final List<Member> members;

    public Members(String rawNames) {
        validate(rawNames);
        this.members = initialize(rawNames);
    }

    private void validate(String rawNames) {
        validateNull(rawNames);
        List<String> names = parse(rawNames);
        validateDuplication(names);
        validateCount(names);
    }

    private List<Member> initialize(String rawNames) {
        return parse(rawNames).stream()
            .map(Member::new)
            .toList();
    }

    private void validateNull(String rawNames) {
        if (rawNames == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    private List<String> parse(String rawNames) {
        return Arrays.stream(rawNames.split(",", -1))
            .map(String::trim)
            .toList();
    }

    private void validateDuplication(List<String> names) {
        Set<String> nonDuplicated = new HashSet<>(names);
        if (names.size() != nonDuplicated.size()) {
            throw new IllegalArgumentException("이름은 서로 중복될 수 없습니다.");
        }
    }

    private void validateCount(List<String> names) {
        if (names.size() < MIN_MEMBER_COUNT || names.size() > MAX_MEMBER_COUNT) {
            throw new IllegalArgumentException(
                "참여자는 " + MIN_MEMBER_COUNT + "~" + MAX_MEMBER_COUNT + "명만 허용됩니다.");
        }
    }

    public int getCount() {
        return members.size();
    }

    public List<String> getNames() {
        return members.stream()
            .map(Member::getName)
            .toList();
    }
}
