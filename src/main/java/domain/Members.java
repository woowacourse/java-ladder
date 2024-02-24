package domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Members {

    private static final String DELIMITER = ",";
    private static final int MIN_MEMBER_COUNT = 2;
    private static final int MAX_MEMBER_COUNT = 15;

    private final List<Member> members = new ArrayList<>();

    public Members(String rawNames) {
        List<String> names = StringParser.splitByDelimiter(rawNames, DELIMITER);
        validateDuplication(names);
        validateCount(names);
        addMembersByNames(names);
    }

    private void validateDuplication(List<String> names) {
        Set<String> nonDuplicated = new HashSet<>(names);
        if (names.size() != nonDuplicated.size()) {
            throw new IllegalArgumentException("이름은 서로 중복될 수 없습니다.");
        }
    }

    private void validateCount(List<String> names) {
        if (names.size() < MIN_MEMBER_COUNT || names.size() > MAX_MEMBER_COUNT) {
            throw new IllegalArgumentException("참여자는 " + MIN_MEMBER_COUNT + "~" + MAX_MEMBER_COUNT + "명만 허용됩니다.");
        }
    }

    private void addMembersByNames(List<String> names) {
        names.forEach(name -> members.add(new Member(name)));
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
