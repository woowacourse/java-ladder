package domain.model;

import domain.vo.Name;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class GoodsTest {
    @ParameterizedTest
    @ValueSource(ints = {0, 1})
    void goodsTest(int provided) {
        Goods goods = new Goods(List.of(new Name("item1"), new Name("item2")), 2);
        assertThat(goods.get(provided)).isEqualTo(String.format("item%d", provided + 1));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 3})
    void goodsFailTest(int provided) {
        assertThatThrownBy(() -> new Goods(List.of(new Name("item1"), new Name("item2")), provided))
                .hasMessage("참가자 수와 상품 수가 같아야 합니다.");
    }
}
