package model;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator.ReplaceUnderscores;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(ReplaceUnderscores.class)
class BlockTest {

    @ParameterizedTest
    @ValueSource(strings = {"RIGHT", "LEFT", "NOTHING"})
    void BLOCK은_생성자의_파라미터로_PASS_ENUM값을_받아_BLOCK을_생성한다(Pass pass) {
        assertThatCode(() -> new Block(pass)).doesNotThrowAnyException();
    }

    @ParameterizedTest
    @CsvSource(value = {"true:RIGHT", "false:NOTHING"}, delimiter = ':')
    void buildFirstBlock_메소드는_Pass값을_TRUE로_생성하면_RIGHT을_반환하고_FALSE로_생성하면_NOTHING을_반환한다(boolean generatedPass,
        String pass) {
        assertThat(Block.buildFirstBlock(generatedPass).getPass().toString()).isEqualTo(pass);
    }

    @ParameterizedTest
    @CsvSource(value = {"RIGHT:false:LEFT", "NOTHING:true:RIGHT", "NOTHING:false:NOTHING", "LEFT:true:RIGHT",
        "LEFT:false:NOTHING"}, delimiter = ':')
    void buildMiddleBlock_메소드는_왼쪽_BLOCK_PASS에_RIGHT이_존재하면_LEFT를_반환하고_존재하지_않을때_PASS값이_TRUE면_RIGHT을_반환하고_FALSE면_NOTHING을_반환한다(
        Pass leftPass, boolean generatedPass, Pass rightPass) {
        assertThat(Block.buildMiddleBlock(new Block(leftPass), generatedPass).getPass()).isEqualTo(
            rightPass);
    }

    @ParameterizedTest
    @CsvSource(value = {"RIGHT:LEFT", "LEFT:NOTHING", "NOTHING:NOTHING"}, delimiter = ':')
    void buildLastBlock_메소드는_왼쪽_BLOCK에_PASS값이_RIGHT면_LEFT를_반환하고_그렇지않으면_NOTHING을_반환한다(Pass leftPass, Pass rightPass) {
        assertThat(Block.buildLastBlock(new Block(leftPass)).getPass()).isEqualTo(rightPass);
    }
}
