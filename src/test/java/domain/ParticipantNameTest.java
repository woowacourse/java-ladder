package domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParticipantNameTest {
	@Test
	@DisplayName("이름이 네 글자인 참가자는 정상적으로 생성되어야한다.")
	void participantNameLengthSuccessTest() {
		String name = "echo";
		Assertions.assertDoesNotThrow(() -> new ParticipantName(name));
	}

	@Test
	@DisplayName("이름이 여섯 글자인 참가자는 예외를 발생시켜야한다.")
	void participantNameLengthFailTest() {
		String name = "echo11";
		assertThatThrownBy(() -> new ParticipantName(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이름이 공백인 참가자는 예외를 발생시켜야한다.")
	void participantNameLengthFailTest2() {
		String name = "  ";
		assertThatThrownBy(() -> new ParticipantName(name)).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이름 포맷을 정상적으로 반환해야한다.")
	void participantNameFormatSuccessTest() {
		String name = "echo";
		ParticipantName participantName = new ParticipantName(name);
		assertThat(participantName.format()).isEqualTo("  echo");
	}
}
