package domain.model;

import domain.vo.GoodsName;
import domain.vo.Position;

public class Goods {
    private final GoodsName goodsName;
    private Position position;
    public Goods(final GoodsName goodsName, final Position position){
        this.goodsName = goodsName;
        this.position = position;
    }
}
