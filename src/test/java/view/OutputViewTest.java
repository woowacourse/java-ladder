package view;

import domain.Player;
import domain.PlayerNames;
import domain.Players;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class OutputViewTest {
    static List<Player> playerList = new ArrayList<>();
    static List<String> nameList;
    Players players;
    OutputStream out;

    @BeforeAll
    static void initSetting() {
        nameList = new ArrayList<>(List.of("judy","ako", "pobi"));

        Player judy = new Player("judy");
        Player ako = new Player("ako");
        Player pobi = new Player("pobi");

        playerList.add(judy);
        playerList.add(ako);
        playerList.add(pobi);
    }

    @Test
    void calculateBlank_메서드_테스트() {
        out = new ByteArrayOutputStream();
        players = new Players(new PlayerNames(nameList));
        OutputView outputView = new OutputView();
        String expect = "judy " + "   ako" + " pobi";

        System.setOut(new PrintStream(out));
        outputView.printNames(players);

        Assertions.assertThat(expect).isEqualTo(out.toString().trim());
    }
}
