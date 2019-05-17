package laddergame.domain.result;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DestinationsTest {
    private Destinations destinations;
    DestinationsBuilder destinationsBuilder;

    @BeforeEach
    void setUp() {
        destinationsBuilder = new DestinationsBuilder("꽝,3000,5000,꽝");
        destinations = destinationsBuilder.buildDestinations();
    }

    @Test
    public void 객체_생성() {
        assertThat(destinations).isEqualTo(destinationsBuilder.buildDestinations());
    }

    @Test
    public void 해당_인덱스의_결과값_제대로_가져오는지() {
        assertThat(destinations.getDestination(1).toString()).isEqualTo("꽝");
    }
}