package ladder.utils;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ValidatorUtilsTest {
    @Test
    public void 올바른_이름이_입력됐을_때() {
        List<String> inputNames = new ArrayList<>(Arrays.asList("pobi,cony,done".trim().split(",")));

        assertThatCode(() -> {
            ValidatorUtils.checkNames(inputNames);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 이름에_공백만_입력됐을_때() {
        List<String> inputNames = new ArrayList<>(Arrays.asList("      ".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(inputNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 다섯자_초과하는_이름이_입력됐을_때() {
        List<String> inputNames = new ArrayList<>(Arrays.asList("pobi,coniii,done".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(inputNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 빈_이름이_입력됐을_때() {
        List<String> inputNames = new ArrayList<>(Arrays.asList("pobi,     ,done".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(inputNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 참가자가_한_명일_때() {
        List<String> inputNames = new ArrayList<>(Arrays.asList("pobi".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkNames(inputNames);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 올바른_실행_결과가_입력됐을_때() {
        List<String> inputItems = new ArrayList<>(Arrays.asList("꽝,당첨,꽝".trim().split(",")));

        assertThatCode(() -> {
            ValidatorUtils.checkItems(inputItems, 3);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 실행_결과에_공백만_입력됐을_때() {
        List<String> inputItems = new ArrayList<>(Arrays.asList("      ".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkItems(inputItems, 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 빈_실행_결과가_입력됐을_때() {
        List<String> inputItems = new ArrayList<>(Arrays.asList("꽝,   ,꽝,당첨,당첨".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkItems(inputItems, 5);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사람_수와_실행_결과의_수가_다를_때() {
        List<String> inputItems = new ArrayList<>(Arrays.asList("꽝,당첨,꽝".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkItems(inputItems, 2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 올바른_높이가_입력됐을_때() {
        int height = 10;

        assertThatCode(() -> {
            ValidatorUtils.checkHeight(height);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 자연수가_아닌_높이가_입력됐을_때() {
        int height1 = 0;
        int height2 = -1;

        assertThatThrownBy(() -> {
            ValidatorUtils.checkHeight(height1);
        }).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> {
            ValidatorUtils.checkHeight(height2);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 결과를_보고_싶은_사람이_바르게_입력됐을_때() {
        String inputParticipant = "pobi".trim();
        List<String> names = new ArrayList<>(Arrays.asList("pobi,cony,done".trim().split(",")));

        assertThatCode(() -> {
            ValidatorUtils.checkParticipant(inputParticipant, names);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 결과를_보고_싶은_사람에_all이_입력됐을_때() {
        String inputParticipant = "all".trim();
        List<String> names = new ArrayList<>(Arrays.asList("pobi,cony,done".trim().split(",")));

        assertThatCode(() -> {
            ValidatorUtils.checkParticipant(inputParticipant, names);
        }).doesNotThrowAnyException();
    }

    @Test
    public void 결과를_보고_싶은_사람_이름에_공백만_입력됐을_때() {
        String inputParticipant = "      ".trim();
        List<String> names = new ArrayList<>(Arrays.asList("pobi,cony,done".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkParticipant(inputParticipant, names);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 게임에_참여하지_않은_이름이_입력됐을_때() {
        String inputParticipant = "woni".trim();
        List<String> names = new ArrayList<>(Arrays.asList("pobi,cony,done".trim().split(",")));

        assertThatThrownBy(() -> {
            ValidatorUtils.checkParticipant(inputParticipant, names);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
