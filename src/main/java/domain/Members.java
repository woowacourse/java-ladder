package domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

public class Members {

    private static final int MIN_MEMBER_COUNT = 2;
    private static final int MAX_MEMBER_COUNT = 15;

    private final List<Member> members;

    private Members(List<Member> members) {
        validate(members);
        this.members = members;
    }

    public static Members from(String rawNames) {
        return new Members(initialize(rawNames));
    }

    public int findIndexByName(String name) {
        return IntStream.range(0, members.size())
            .filter(i -> members.get(i).getName().equals(name))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 플레이어입니다."));
    }

    private static void validate(List<Member> members) {
        if (members.size() < MIN_MEMBER_COUNT || members.size() > MAX_MEMBER_COUNT) {
            throw new IllegalArgumentException(
                "참여자는 " + MIN_MEMBER_COUNT + "~" + MAX_MEMBER_COUNT + "명만 허용됩니다.");
        }
    }

    private static List<Member> initialize(String rawNames) {
        validateNull(rawNames);
        List<String> parsedNames = parse(rawNames);
        validateDuplication(parsedNames);
        return parsedNames.stream()
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

    public int getCount() {
        return members.size();
    }

    public List<String> getNames() {
        return members.stream()
            .map(Member::getName)
            .toList();
    }
}
