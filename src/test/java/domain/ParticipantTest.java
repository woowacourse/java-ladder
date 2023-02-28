package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import controller.LadderGameController;
import domain.participants.Participant;
import exception.NotEnglishAndNumberException;
import exception.ladder.GameEndReservedWordException;
import exception.participants.EmptyNameException;
import exception.participants.InvalidPersonNameException;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class ParticipantTest {

    @DisplayName("사람이름이 요구사항에 충족할 경우.")
    @TestFactory
    Stream<DynamicTest> createSuccess() {
        return Stream.of(
            dynamicTest("영어로만 이루어진 1글자의 이름", () -> {
                Participant participant = new Participant("a");
                String name = participant.getName();
                Assertions.assertThat(name).isEqualTo("a");
            }),
            dynamicTest("영어로만 이루어진 5글자의 이름", () -> {
                Participant participant = new Participant("split");
                String name = participant.getName();
                Assertions.assertThat(name).isEqualTo("split");
            }));
    }

    @DisplayName("사람이름이 요구사항에 맞지 않는 경우")
    @TestFactory
    Stream<DynamicTest> createFail() {
        return Stream.of(
            dynamicTest("null 일 때", () -> assertThatThrownBy(() -> new Participant(null))
                .isExactlyInstanceOf(EmptyNameException.class)),
            dynamicTest("빈문자열 때", () -> assertThatThrownBy(() -> new Participant(""))
                .isExactlyInstanceOf(EmptyNameException.class)),
            dynamicTest("띄어쓰기로만 이루어져 있을 때", () -> assertThatThrownBy(() -> new Participant("    "))
                .isExactlyInstanceOf(EmptyNameException.class)),
            dynamicTest("5자보다 긴 경우", () -> assertThatThrownBy(() -> new Participant("jamsil"))
                .isExactlyInstanceOf(InvalidPersonNameException.class)),
            dynamicTest("게임 종료 명령어가 이름일 때",
                () -> assertThatThrownBy(() -> new Participant(LadderGameController.EXIT_RESERVED_WORD))
                    .isExactlyInstanceOf(GameEndReservedWordException.class)),
            dynamicTest("영어와 숫자로 이루어지지 않은 경우", () -> assertThatThrownBy(() -> new Participant("인밸리드"))
                .isExactlyInstanceOf(NotEnglishAndNumberException.class))
        );
    }
}
