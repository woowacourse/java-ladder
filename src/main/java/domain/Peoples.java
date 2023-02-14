package domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 최원용
 * @version 2.0.0
 * @Created by 최원용 on 2023. 02. 14.
 */
public class Peoples {

    private List<People> peoples;

    public Peoples(List<String> names) {
        this.peoples = createPeoples(names);
    }

    private List<People> createPeoples(List<String> names) {
        List<People> peoples = new ArrayList<>();
        for (String name : names) {
            peoples.add(new People(name));
        }
        return peoples;
    }

    public List<People> getPeoples() {
        return peoples;
    }
}
