package domain.model;

import domain.vo.Name;
import domain.vo.Position;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatNoException;

public class GoodsTest {
    @Test
    @DisplayName("상품이 생성된다")
    void goodsTest(){
        assertThatNoException()
                .isThrownBy(()->new Goods(new Name("test"),new Position(1)));
    }
}
