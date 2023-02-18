package model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class PathTest {

    @ParameterizedTest
    @CsvSource(value = {"PASSABLE:true:UN_PASSABLE", "PASSABLE:false:UN_PASSABLE",
            "UN_PASSABLE:true:PASSABLE", "UN_PASSABLE:false:UN_PASSABLE"}, delimiter = ':')
    void calculatePath_메소드는_좌측_Path와_Generator가_주어지면_Path를_반환한다(Path otherPath,
            boolean passable, Path expected) {
        Path actual = Path.calculatePath(otherPath, passable);

        assertThat(actual).isSameAs(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"false:UN_PASSABLE", "true:PASSABLE"}, delimiter = ':')
    void calculatePath_메소드는_Generator가_주어지면_Path를_반환한다(boolean passable, Path expected) {
        Path actual = Path.calculatePath(passable);

        assertThat(actual).isSameAs(expected);
    }
    
    @ParameterizedTest
    @CsvSource(value = {"PASSABLE:-----", "UN_PASSABLE:'     '"}, delimiter = ':')
    void getLog_메소드는_호출하면_log를_반환한다(Path path, String expected) {
        String actual = path.getLog();

        assertThat(actual).isEqualTo(expected);
    }
}