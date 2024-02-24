package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Members {

    private static final int MIN_MEMBER_COUNT = 2;
    private static final int MAX_MEMBER_COUNT = 15;

    private final List<Member> members;

    private Members(List<Member> members) {
        this.members = members;
    }

    public static Members from(String rawNames) {
        validate(rawNames);
        return new Members(initialize(rawNames));
    }

    private static void validate(String rawNames) {
        validateNull(rawNames);
        List<String> names = parse(rawNames);
        validateDuplication(names);
        validateCount(names);
    }

    private static List<Member> initialize(String rawNames) {
        return parse(rawNames).stream()
            .map(Member::from)
            .toList();
    }

    private static void validateNull(String rawNames) {
        if (rawNames == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    private static List<String> parse(String rawNames) {
        return Arrays.stream(rawNames.split(",", -1))
            .map(String::trim)
            .toList();
    }

    private static void validateDuplication(List<String> names) {
        Set<String> nonDuplicated = new HashSet<>(names);
        if (names.size() != nonDuplicated.size()) {
            throw new IllegalArgumentException("이름은 서로 중복될 수 없습니다.");
        }
    }

    private static void validateCount(List<String> names) {
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
