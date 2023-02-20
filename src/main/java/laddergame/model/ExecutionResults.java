package laddergame.model;

import java.util.List;

public class ExecutionResults {
    public ExecutionResults(List<String> results, int participantsNumber) {
        System.out.println(results.size());
        System.out.println(participantsNumber);
        if(results.size() != participantsNumber) {
            throw new IllegalArgumentException("실행결과의 개수는 참여자 인원과 같아야 합니다.");
        }
    }
}
