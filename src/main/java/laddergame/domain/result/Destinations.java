package laddergame.domain.result;

import laddergame.domain.Constant;

import java.util.List;
import java.util.Objects;

public class Destinations {
    private final List<Destination> destinations;

    public Destinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public boolean matchPlayersCount(int playerCount) {
        return (playerCount != destinations.size());
    }

    public Destination getDestination(int index) {
        return this.destinations.get(index - 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Destinations)) return false;
        Destinations destinations1 = (Destinations) o;
        return Objects.equals(destinations, destinations1.destinations);
    }

    @Override
    public int hashCode() {
        return Objects.hash(destinations);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Destination destination : destinations) {
            stringBuilder.append(String.format("%-" + Constant.BOUND_OF_NAME_LENGTH + "s", destination));
            stringBuilder.append(" ");
        }
        return stringBuilder.toString();
    }
}
