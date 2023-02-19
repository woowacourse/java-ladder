package domain.model;

import domain.vo.Name;
import domain.vo.Position;

public class Goods {
    private final Name name;

    private Position position;
    public Goods(final Name name, final Position position){
        this.name = name;
        this.position = position;
    }
}
