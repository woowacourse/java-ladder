package controller;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.NoSuchElementException;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import view.InputView;
import view.OutputView;

public class LadderGameControllerTest {

	private PrintStream standardOut;
	private OutputStream out;

	@BeforeEach
	void setUp() {
		standardOut = System.out;
		out = new ByteArrayOutputStream();
		System.setOut(new PrintStream(out));
	}

	@AfterEach
	void tearDown() {
		System.setOut(standardOut);
		System.out.println(out.toString().trim());
	}

	@Test
	@DisplayName("올바른 입력인 경우, 올바르게 작동 후 종료한다.")
	void validGameTest() {
		// given
		command("a,b,c", "d,e,f", "2", "all");
		// when
		run();
		// then
		assertThat(out.toString())
			.containsSubsequence(
				"참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)",
				"최대 사다리 높이는 몇 개인가요?",
				"사다리 결과",
				"a     b     c",
				"d     e     f",
				"결과를 보고 싶은 사람은?",
				"실행 결과",
				"a : ",
				"b : ",
				"c : "
			);
	}

	@Test
	@DisplayName("올바르지 않은 이름이 입력되면 재입력을 받는다.")
	void retryInputOnNamesExceptionTest() {
		command(
			"hello,my,name,is,sangdol"
			, "a:b:c"
			, ""
		);

		try {
			assertTimeoutPreemptively(Duration.ofSeconds(1L), this::run);
		} catch (NoSuchElementException ignored) {
		}
	}

	@Test
	@DisplayName("올바르지 않은 실행 결과가 입력되면 재입력을 받는다.")
	void retryInputOnPrizesExceptionTest() {
		command(
			"a,b,c" // 이름 정상 입력
			, "a,b,c,d"
			, "123456, 3, 4, 5"
			, ""
			, "12345, ,꽝,꽝"
		);
		try {
			assertTimeoutPreemptively(Duration.ofSeconds(1L), this::run);
		} catch (NoSuchElementException ignored) {
		}
	}

	@Test
	@DisplayName("올바르지 않은 사다리 높이가 입력되면 재입력을 받는다.")
	void retryInputOnLadderHeightsExceptionTest() {
		command(
			"a,b,c" // 이름 정상 입력
			, "꽝,5000,3000" // 실행 결과 정상 입력
			, "a"
			, "-1"
			, ""
		);

		try {
			assertTimeoutPreemptively(Duration.ofSeconds(1L), this::run);
		} catch (NoSuchElementException ignored) {
		}
	}

	@Test
	@DisplayName("올바르지 않은 유저 이름이 입력되면 재입력을 받는다.")
	void retryInputOnPlayerNameExceptionTest() {
		command(
			"a,b,c" // 이름 정상 입력
			, "꽝,5000,3000" // 실행 결과 정상 입력
			, "5" // 사다리 정상 입력
			, "ali"
			, "d"
			, ""
		);

		try {
			assertTimeoutPreemptively(Duration.ofSeconds(1L), this::run);
		} catch (NoSuchElementException ignored) {
		}
	}

	private void run() {
		InputView inputView = new InputView();
		OutputView outputView = new OutputView();
		LadderGameController controller = new LadderGameController(inputView, outputView);

		controller.run();
	}

	private void command(final String... args) {
		final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}
}
