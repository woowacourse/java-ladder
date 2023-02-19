package view;

import domain.Player;
import domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class OutputViewTest {

    Players players = new Players(List.of(new Player("judy"), new Player("ako"), new Player("pobi")));
    private final OutputStream out = new ByteArrayOutputStream();

    @Test
    void calculateBlank_메서드_테스트() {
        //given
        OutputView outputView = new OutputView();

        //when
        System.setOut(new PrintStream(out));
        outputView.printNames(players);
        String expect = "judy " + "   ako" + " pobi";

        //then
        Assertions.assertThat(expect).isEqualTo(out.toString().trim());
    }
}
