package model;

import java.util.List;

public class Presents {
    private final List<Present> presentGroup;

    private Presents(final List<Present> presentGroup) {
        this.presentGroup = presentGroup;
    }

    public static Presents from(final List<String> presentNames, final People people) {
        final int personCount = people.getPersonCount();
        validatePresentCount(presentNames.size(), personCount);
        final List<Present> presentGroup = presentNames.stream()
                .map(Present::new)
                .toList();
        return new Presents(presentGroup);
    }

    private static void validatePresentCount(final int presentCount, final int personCount) {
        if (presentCount != personCount) {
            throw new IllegalArgumentException("상품의 갯수는 사람 이름수와 같아야 합니다.");
        }
    }

    public Present getPresent(final int column) {
        return presentGroup.get(column);
    }

    public List<String> getPresentNames() {
        return presentGroup.stream()
                .map(Present::name)
                .toList();
    }
}
