import java.util.Arrays;
import java.util.List;

public class Game {
    public List<Person> parsePersonName(String input) {
        return Arrays.stream(input.split(","))
                .map(name -> new Person(name.trim()))
                .toList();
    }
}
