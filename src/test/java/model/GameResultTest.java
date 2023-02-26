package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class GameResultTest {

    private final GameResult gameResult = new GameResult("a", "1");

    @ParameterizedTest(name = "matchesByName 메소드는 전달한 name과 GameResult가 관리하는 상태 name이 일치하는지 여부를 반환한다")
    @CsvSource(value = {"a:true", "b:false"}, delimiter = ':')
    void successTest(String name, boolean expected) {
        boolean actual = gameResult.matchesByName(name);

        assertThat(actual).isSameAs(expected);
    }
}
