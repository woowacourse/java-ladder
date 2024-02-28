package domain.model;

import java.util.List;

public class Consequences {
    private final List<String> consequences;

    public Consequences(List<String> consequences, int numberOfPeople) {
        validateSize(consequences,numberOfPeople);
        this.consequences = consequences;
    }
    private void validateSize(List<String> consequences,int numberOfPeople){
        if(consequences.size()!=numberOfPeople) {
            throw new IllegalArgumentException("결과는 사람 수와 일치해야 합니다.");
        }
    }
}
