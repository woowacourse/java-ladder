package view;

import java.util.List;
import domain.User;

public class OutputView {
    public static void outputNames(List<User> users) {
        for (User user : users) {
            System.out.print(user.getName() + "\t");
        }
        System.out.println();
    }
}
