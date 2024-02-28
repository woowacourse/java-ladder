package model.position;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class CachedPositionTest {

    @DisplayName("캐싱된 값을 가져올 수 있다")
    @Test
    void cachedPosition(){
        assertAll(
                () -> assertThat(CachedPosition.valueOf(0)).isEqualTo(new Position(0)),
                () -> assertThat(CachedPosition.valueOf(20)).isEqualTo(new Position(20))
        );
    }


    @DisplayName("초기에 캐싱되지 않은 값이 들어올 경우 값을 추가하고 가져올 수 있다")
    @Test
    void nonCachedPosition(){
        assertThat(CachedPosition.valueOf(21)).isEqualTo(new Position(21));
    }

}
