package com.woowacourse.ladder.domain;

import com.woowacourse.ladder.domain.Ladder;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class LadderTest {


    @BeforeEach
    void setUp() {
        HashMap<Integer,List<Boolean>> map = new HashMap<>();
        map.put(0,Arrays.asList(true,false,true,false));
        map.put(1,Arrays.asList(false,true,false,true));
        map.put(2,Arrays.asList(true,false,true,false));
        map.put(3,Arrays.asList(false,true,false,true));
      //  ladder = PartGenerator.generateLadder(5,4,map);
    }

    @Test
    void stripeLadder_메소드_테스트() {
        /*assertThat(ladder.stripeLadder(0)).isEqualTo(4);
        assertThat(ladder.stripeLadder(1)).isEqualTo(2);
        assertThat(ladder.stripeLadder(2)).isEqualTo(3);
        assertThat(ladder.stripeLadder(3)).isEqualTo(0);
        assertThat(ladder.stripeLadder(4)).isEqualTo(1);*/
    }
}
