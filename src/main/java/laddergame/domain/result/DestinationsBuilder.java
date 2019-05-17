package laddergame.domain.result;

import laddergame.domain.Constant;
import laddergame.domain.inputValidator;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DestinationsBuilder {
    private String names;

    public DestinationsBuilder(String names) {
        this.names = names;
    }

    public Destinations buildDestinations() {
        inputValidator.validateInput(names);

        List<Destination> destinations =  Arrays.asList(names.split(Constant.COMMA)).stream()
                .map(Destination::new)
                .collect(Collectors.toList());

        return new Destinations(destinations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DestinationsBuilder)) return false;
        DestinationsBuilder that = (DestinationsBuilder) o;
        return Objects.equals(names, that.names);
    }

    @Override
    public int hashCode() {
        return Objects.hash(names);
    }
}
