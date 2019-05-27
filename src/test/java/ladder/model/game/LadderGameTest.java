/*
 * @(#)LadderGameTest.java      1.0 2019/05/16
 *
 * Copyright (c) 2019 Hyogeon Kim,
 * Ladder, Java, Seoul, KOREA
 */

package ladder.model.game;

import ladder.model.ladder.Horizon;
import ladder.model.ladder.Ladder;
import ladder.model.ladder.Line;
import ladder.model.tags.PlayerTags;
import ladder.model.tags.ResultTags;
import ladder.model.tags.Tag;
import org.assertj.core.api.Java6Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

/**
 * @author 김효건
 * @version 1.0 2019년 05년 16일
 */
class LadderGameTest {
        /*사다리 게임을 진행에 대한 테스트*/
        LadderGame ladderGame;
        ResultTags resultTags;
        PlayerTags playerTags;

        @BeforeEach
        void setUp() {
                List<Line> lines = new ArrayList<>();

                List<Horizon> horizons1 = new ArrayList<>();
                horizons1.add(new Horizon(true));
                horizons1.add(new Horizon(horizons1.get(0), false));
                horizons1.add(new Horizon(horizons1.get(1), true));
                horizons1.add(new Horizon(horizons1.get(2), false));
                horizons1.add(new Horizon(horizons1.get(3), false));
                lines.add(new Line(horizons1));

                List<Horizon> horizons2 = new ArrayList<>();
                horizons2.add(new Horizon(false));
                horizons2.add(new Horizon(horizons2.get(0), false));
                horizons2.add(new Horizon(horizons2.get(1), true));
                horizons2.add(new Horizon(horizons2.get(2), false));
                horizons2.add(new Horizon(horizons2.get(3), false));
                lines.add(new Line(horizons2));

                List<Horizon> horizons3 = new ArrayList<>();
                horizons3.add(new Horizon(false));
                horizons3.add(new Horizon(horizons3.get(0), true));
                horizons3.add(new Horizon(horizons3.get(1), false));
                horizons3.add(new Horizon(horizons3.get(2), true));
                horizons3.add(new Horizon(horizons3.get(3), false));
                lines.add(new Line(horizons3));

                playerTags = new PlayerTags(new String[]{"a", "b", "c", "d", "e"});
                resultTags = new ResultTags(new String[]{"1", "2", "3", "4", "5"}, 5);
                Ladder ladder = new Ladder(lines);

                ladderGame = new LadderGame(playerTags, resultTags, ladder);
        }

        @Test
        void 찾을_플레이어_존재_검사() {
                assertThrows(IllegalArgumentException.class, () -> {
                        ladderGame.getOneResultByTag(new Tag("abc"));
                });
        }

        @Test
        void 태그이름으로_결과결과이름_추출() {
                assertThat(ladderGame.getOneResultByTag(new Tag("c"))).isEqualTo(new Tag("2"));
                assertThat(ladderGame.getOneResultByTag(new Tag("a"))).isEqualTo(new Tag("3"));
                assertThat(ladderGame.getOneResultByTag(new Tag("e"))).isEqualTo(new Tag("4"));
        }

        @Test
        void 모든결과_추출() {
                GameResult gameResult = new GameResult();

                gameResult.addResult(playerTags.getTags().get(0), resultTags.getTags().get(2));
                gameResult.addResult(playerTags.getTags().get(1), resultTags.getTags().get(0));
                gameResult.addResult(playerTags.getTags().get(2), resultTags.getTags().get(1));
                gameResult.addResult(playerTags.getTags().get(3), resultTags.getTags().get(4));
                gameResult.addResult(playerTags.getTags().get(4), resultTags.getTags().get(3));

                Java6Assertions.assertThat(gameResult.getMappingResult()).isEqualTo(ladderGame.getAllResults().getMappingResult());
        }
}