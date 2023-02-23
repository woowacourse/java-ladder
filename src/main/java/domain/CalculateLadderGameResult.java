package domain;

import java.util.ArrayList;
import java.util.List;

public class CalculateLadderGameResult {

    public List<String> passLadder(final List<Line> ladder, final List<String> userNames) {
        List<String> userPositions = new ArrayList<>(userNames);
        for (Line line : ladder) {
            List<Link> links = line.getLinks();
            passLine(links, userPositions);
        }
        return List.copyOf(userPositions);
    }

    private void passLine(final List<Link> links, List<String> userPositions) {
        for (int index = 0; index < links.size(); index++) {
            swapUserPositions(links, index, userPositions);
        }
    }

    private static void swapUserPositions(final List<Link> links, final int index, List<String> userPositions) {
        if (links.get(index).isLink()) {
            String swapUserName = userPositions.get(index);
            userPositions.set(index, userPositions.get(index + 1));
            userPositions.set(index + 1, swapUserName);
        }
    }
}
