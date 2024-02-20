public class HorizonLineGenerator {

    public HorizonLine generate(int i) {
        if (i == 0) {
            return HorizonLine.EMPTY;
        }
        if (i == 1) {
            return HorizonLine.EXIST;
        }
        return null;
    }
}
