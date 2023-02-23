package ladder.domain;

import java.util.Collections;
import java.util.List;

/**
 * @author 우가
 * @version 1.0.0
 * @Created by 우가 on 2023/02/23
 */
public class Bottoms {
    private final List<String> bottoms;

    public Bottoms(final List<String> bottomsInput, final Players players) {
        if (bottomsInput.size() != players.count()) {
            throw new IllegalArgumentException("실행결과수와 참가자수가 같아야합니다.");
        }
        this.bottoms = bottomsInput;
    }

    public List<String> toList() {
        return Collections.unmodifiableList(bottoms);
    }
}
