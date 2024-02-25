package view;

import domain.ExceptionType;
import domain.LadderGameException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Supplier;

public class LadderGameOperatorInputView {
    public static String getOperator(Supplier<String> supplier, List<String> names) {
        String operator = supplier.get();
        validateOperator(new HashSet<>(names), operator);
        return operator;
    }

    private static void validateOperator(Set<String> names, String operator) {
        if (!names.contains(operator) && !operator.equals("all")) {
            throw new LadderGameException(ExceptionType.NAME_NOT_FOUND);
        }
    }
}
