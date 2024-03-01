package domain;

import java.util.List;

public class ResultTarget {

    private static final String ALL_RESULT_TARGET = "all";

    private final String value;
    private final Boolean isAll;

    private ResultTarget(String value, Boolean isAll) {
        this.value = value;
        this.isAll = isAll;
    }

    public static ResultTarget of(String value, List<Member> members) {
        validate(value, members);
        if (value.equals(ALL_RESULT_TARGET)) {
            return new ResultTarget(value, true);
        }
        return new ResultTarget(value, false);
    }

    private static void validate(String value, List<Member> members) {
        boolean isExist = members.stream()
                .anyMatch(member -> member.getName().equals(value));
        if (!isExist && !value.equals(ALL_RESULT_TARGET)) {
            throw new IllegalArgumentException("해당 이름을 가진 참여자가 없습니다.");
        }
    }

    public boolean isAllMembers() {
        return isAll;
    }

    public String getValue() {
        return value;
    }
}
