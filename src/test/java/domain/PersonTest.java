package domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.DynamicTest.dynamicTest;

import exception.EmpytInputException;
import exception.InvalidPersonNameException;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DynamicTest;
import org.junit.jupiter.api.TestFactory;

class PersonTest {

    @DisplayName("사람이름이 요구사항에 충족할 경우.")
    @TestFactory
    Stream<DynamicTest> createSuccess() {
        return Stream.of(
            dynamicTest("영어로만 이루어진 1글자의 이름", () -> {
                Person person = new Person("a");
                String name = person.getName();
                Assertions.assertThat(name).isEqualTo("a");
            }),
            dynamicTest("영어로만 이루어진 5글자의 이름", () -> {
                Person person = new Person("split");
                String name = person.getName();
                Assertions.assertThat(name).isEqualTo("split");
            }));
    }

    @DisplayName("사람이름이 요구사항에 맞지 않는 경우")
    @TestFactory
    Stream<DynamicTest> createFail() {
        return Stream.of(
            dynamicTest("null 일 때", () -> assertThatThrownBy(() -> new Person(null))
                .isExactlyInstanceOf(EmpytInputException.class)),
            dynamicTest("빈문자열 때", () -> assertThatThrownBy(() -> new Person(""))
                .isExactlyInstanceOf(EmpytInputException.class)),
            dynamicTest("띄어쓰기로만 이루어져 있을 때", () -> assertThatThrownBy(() -> new Person("    "))
                .isExactlyInstanceOf(EmpytInputException.class)),
            dynamicTest("5자보다 긴 경우", () -> assertThatThrownBy(() -> new Person("jamsil"))
                .isExactlyInstanceOf(InvalidPersonNameException.class))
        );
    }
}
