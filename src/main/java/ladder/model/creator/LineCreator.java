package ladder.model.creator;

import ladder.model.ladder.Horizon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LineCreator {
        private static Random random = new Random();

        public static List<Horizon> create(int tagsNumber) {
                List<Horizon> horizons = new ArrayList<>();
                addFirstHorizon(horizons);
                for (int i = 1; i < tagsNumber - 1; i++) {
                        horizons.add(new Horizon(horizons.get(i - 1), random.nextBoolean()));
                }
                addLastHorizon(horizons);
                return horizons;
        }

        private static void addFirstHorizon(List<Horizon> horizons) {
                Horizon firstHorizon = new Horizon(random.nextBoolean());
                horizons.add(firstHorizon);
        }

        private static void addLastHorizon(List<Horizon> horizons) {
                Horizon lastHorizon = new Horizon(horizons.get(horizons.size() - 1), false);
                horizons.add(lastHorizon);
        }
}
