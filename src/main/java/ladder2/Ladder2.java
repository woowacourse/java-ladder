package ladder2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Ladder2 {

    private int width;
    private int height;
    private List<String> ladder;
    private int[] randomArray;

    public Ladder2(int width, int height) {
        this.width = width;
        this.height = height;
        this.ladder = new ArrayList<>();
        this.randomArray = new int[width - 1];
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public List<String> getLadder() {
        return ladder;
    }

    public void setWidth(int w) {
        this.width = w;
    }

    public void setHeight(int h) {
        this.height = h; 
    }

    private void makeRandom(int i) {
        Random random = new Random();
        
        if (i == 0) {
            randomArray[i] = random.nextInt(2);
            return;
        }

        if (randomArray[i - 1] == 0) {
            randomArray[i] = random.nextInt(2);
        }

        if (randomArray[i - 1] == 1) {
            randomArray[i] = 0;
        }
    }

    private String change(int i) {
        return randomArray[i] == 0 ? "     " : "-----";
    }

    public void makeLadder() {
        for (int i = 0; i < width - 1; i++) {  // width - 1까지 반복
            makeRandom(i);
            ladder.add(change(i));
        }
    }
}
