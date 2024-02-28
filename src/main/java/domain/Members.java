package domain;

import java.util.Collections;
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

    public static Members from(List<String> names) {
        validateNull(names);
        validateDuplication(names);
        validateCount(names);
        List<Member> members = createMembersWithNames(names);
        return new Members(members);
    }

    private static void validateNull(List<String> names) {
        if (names == null) {
            throw new IllegalArgumentException("null을 입력할 수 없습니다.");
        }
    }

    private static void validateDuplication(List<String> names) {
        Set<String> nonDuplicated = new HashSet<>(names);
        if (names.size() != nonDuplicated.size()) {
            throw new IllegalArgumentException("이름은 서로 중복될 수 없습니다.");
        }
    }

    private static void validateCount(List<String> names) {
        if (names.size() < MIN_MEMBER_COUNT || names.size() > MAX_MEMBER_COUNT) {
            throw new IllegalArgumentException("참여자는 " + MIN_MEMBER_COUNT + "~" + MAX_MEMBER_COUNT + "명만 허용됩니다.");
        }
    }

    private static List<Member> createMembersWithNames(List<String> names) {
        return names.stream()
                .map(Member::new)
                .toList();
    }

    public int findPositionOfMember(Member member) {
        return members.indexOf(member);
    }

    public boolean checkMemberExist(String name) {
        if (name.equals("all")) {
            return false;
        }
        boolean isExist = members.stream()
                .anyMatch(member -> member.getName().equals(name));
        if (!isExist) {
            throw new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다.");
        }
        return true;
    }

    public int getCount() {
        return members.size();
    }

    public List<String> getNames() {
        return members.stream()
                .map(Member::getName)
                .toList();
    }

    public List<Member> getMembers() {
        return Collections.unmodifiableList(members);
    }
}
