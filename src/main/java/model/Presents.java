package model;

import java.util.List;

public class Presents {
    private final List<Present> presentGroup;

    private Presents(List<Present> presentGroup) {
        this.presentGroup = presentGroup;
    }

    public static Presents from(List<String> presentNames, int personCount) {
        validatePresentCount(presentNames.size(), personCount);
        final List<Present> presentGroup = presentNames.stream()
                .map(Present::new)
                .toList();
        return new Presents(presentGroup);
    }

    private static void validatePresentCount(int presentCount, int personCount) {
        if (presentCount != personCount) {
            throw new IllegalArgumentException("상품의 갯수는 사람 이름수와 같아야 합니다.");
        }
    }

    public Present getPresent(int column) {
        return presentGroup.get(column);
    }
}
