package domain;

import java.util.List;

public class ResultTarget {

    private static final String ALL_RESULT_TARGET = "all";

    private final String value;

    private ResultTarget(String value) {
        this.value = value;
    }

    public static ResultTarget of(String value, List<Member> members) {
        validate(value, members);
        return new ResultTarget(value);
    }

    private static void validate(String value, List<Member> members) {
        boolean isExist = members.stream()
                .anyMatch(member -> member.getName().equals(value));
        if (!isExist && !value.equals(ALL_RESULT_TARGET)) {
            throw new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다.");
        }
    }

    public boolean isAllMembers() {
        return value.equals(ALL_RESULT_TARGET);
    }

    public String getValue() {
        return value;
    }
}
