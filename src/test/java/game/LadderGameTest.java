package game;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.BooleanSupplier;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import generator.LadderFloorGenerator;
import view.InputView;
import view.OutputView;

class LadderGameTest {

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
		command("a,b,c", "2");
		// when
		run();
		// then
		assertThat(out.toString())
			.containsSubsequence(
				"참여할 사람 이름을 입력하세요. (이름은 쉼표(,)로 구분하세요)",
				"최대 사다리 높이는 몇 개인가요?",
				"실행결과",
				"a", "b", "c",
				"|", "|", "|",
				"|", "|", "|"
			);
	}

	@Test
	@DisplayName("올바르지 않은 이름이 입력되면 재입력을 받는다.")
	void retryInputOnNamesExceptionTest() {
		command(
			"hello,my,name,is,sangdol"
			, "a:b:c"
			, "1,2,3"
			, ""
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
			"a,b,c" // 이름은 정상 입력
			, "a"
			, "-1"
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
		BooleanSupplier supplier = () -> false;
		LadderFloorGenerator generator = new LadderFloorGenerator(supplier);
		LadderGame ladderGame = new LadderGame(inputView, outputView, generator);

		ladderGame.play();
	}

	private void command(final String... args) {
		final byte[] buf = String.join(System.lineSeparator(), args).getBytes();
		System.setIn(new ByteArrayInputStream(buf));
	}
}
