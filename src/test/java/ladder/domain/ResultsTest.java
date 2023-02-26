package ladder.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultsTest {

    @Test
    void 참여자의_결과를_가져온다() {
        Player juno = new Player("주노", 0);
        Player doi = new Player("도이", 1);

        Players players = new Players(List.of(juno, doi));

        Products products = new Products(List.of(new Product("1"), new Product("2")));

        Results results = new Results(players, products);

        Map<Player, Product> result = results.toResultByPlayerName("주노");

        assertThat(result.get(juno).getName()).isEqualTo("1");
    }

    @Test
    void 참여자와_결과의_개수가_다르면_예외() {
        Player juno = new Player("주노", 0);
        Player doi = new Player("도이", 1);

        Players players = new Players(List.of(juno, doi));

        Products products = new Products(List.of(
                new Product("1"),
                new Product("2"),
                new Product("3")
        ));

        assertThatThrownBy(() -> {
            new Results(players, products);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 존재하지_않는_참여자를_입력하면_예외() {
        Player juno = new Player("주노", 0);
        Player doi = new Player("도이", 1);

        Players players = new Players(List.of(juno, doi));

        Products products = new Products(List.of(
                new Product("1"),
                new Product("2")
        ));

        Results results = new Results(players, products);

        assertThatThrownBy(() -> {
            results.toResultByPlayerName("없다");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}