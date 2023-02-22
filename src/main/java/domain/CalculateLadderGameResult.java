package domain;

import java.util.ArrayList;
import java.util.List;

public class CalculateLadderGameResult {

    public List<String> passLadder(List<Line> ladder, List<String> userNames) {
        List<String> userPositions = new ArrayList<>(userNames);
        for (Line line : ladder) {
            List<Link> links = line.getLinks();
            userPositions = passLine(links, userPositions);
        }
        return userPositions;
    }

    private List<String> passLine(List<Link> links, List<String> prevUserPositions) {
        List<String> postUserPositions = new ArrayList<>(prevUserPositions);
        for (int index = 0; index < links.size(); index++) {
            if (links.get(index).isLink()) {
                String swapName = postUserPositions.get(index);
                postUserPositions.set(index, postUserPositions.get(index + 1));
                postUserPositions.set(index + 1, swapName);
            }
        }
        return postUserPositions;
    }
}
