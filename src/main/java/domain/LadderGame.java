package domain;

import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class LadderGame {

    public Peoples createPeoples(List<String> names) {
        return new Peoples(names);
    }
}
