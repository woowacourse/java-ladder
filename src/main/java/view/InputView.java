package view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class InputView {

    public static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static String[] readNames() throws IOException {
        return br.readLine().split(",");
    }

    public static int readHeight() throws IOException {
        return Integer.parseInt(br.readLine());
    }
}
