package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Peoples {

    private final List<People> peoples;

    public Peoples(List<People> peoples) {
        this.peoples = peoples;
    }

    public List<People> getPeoples() {
        return peoples;
    }
}
