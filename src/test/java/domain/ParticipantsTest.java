package domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.assertj.core.api.ListAssert.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParticipantsTest {

	@Test
	@DisplayName("네 글자인 참가자는 정상적으로 추가되어야 한다.")
	void participantNameLengthSuccessTest() {
		Participants participants = new Participants();
		Assertions.assertDoesNotThrow(() -> participants.add("echo"));
	}

	@Test
	@DisplayName("여섯 글자인 참가자는 예외를 발생시켜야한다.")
	void participantNameLengthFailTest() {
		Participants participants = new Participants();
		assertThatThrownBy(() -> participants.add("echo11")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("이름이 공백인 참가자는 예외를 발생시켜야한다.")
	void participantNameLengthFailTest2() {
		Participants participants = new Participants();
		assertThatThrownBy(() -> participants.add("  ")).isInstanceOf(IllegalArgumentException.class);
	}
}
