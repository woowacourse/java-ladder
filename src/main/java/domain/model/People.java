package domain.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class People {
    private final List<Person> participant;
    public People(String names) {
        validate(names);
        this.participant = Arrays.stream(names.split(","))
                .map(Person::new)
                .toList();
    }

    public List<Person> getParticipant(){
        return Collections.unmodifiableList(participant);
    }

    private void validate(String inputNames){
        validateSize(inputNames);
        validateDuplicateNames(inputNames);
    }

    private void validateSize(String inputNames){
        int size= inputNames.split(",").length;
        if(size <2){
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicateNames(String inputNames){
        int numberOfOrigin = inputNames.split(",").length;
        int numberOfDistinct = (int) Arrays.stream(inputNames.split(","))
                .distinct()
                .count();

        if (numberOfOrigin != numberOfDistinct){
            throw new IllegalStateException();
        }
    }

}
