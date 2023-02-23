package view;

import domain.Person;
import engine.model.ResultModel;

import java.util.Map;

public class OutputResultView {

    private static final String RESULT_DELIM = " : ";

    public static void printLadderSpecific(final ResultModel resultModel) {
        System.out.println("실행결과");

        System.out.println(resultModel.getName() + RESULT_DELIM + resultModel.getResult());
    }

    public static void printLadderAll(final Map<Person, String> result) {
        for (Person participant : result.keySet()) {
            System.out.println(participant.getName() + RESULT_DELIM + result.get(participant));
        }
    }

    public static void printNotExistedParticipant() {
        System.out.println("해당 이름을 가진 참여자가 존재하지 않습니다. 다시 입력해 주세요.");
    }
}
