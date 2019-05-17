package ladder.DTO;

import ladder.domain.Line;

import java.util.List;

public class LadderGameDTO {
    private List<Line> ladder;
    private List<String> names;
    private List<String> resultCandidate;
    private List<Integer> allResult;
    private int height;
    private String requestedName;

    public List<Line> getLadder() {
        return ladder;
    }

    public void setLadder(List<Line> ladder) {
        this.ladder = ladder;
    }

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public List<String> getResultCandidate() {
        return resultCandidate;
    }

    public void setResultCandidate(List<String> resultCandidate) {
        this.resultCandidate = resultCandidate;
    }

    public List<Integer> getAllResult() {
        return allResult;
    }

    public void setAllResult(List<Integer> allResult) {
        this.allResult = allResult;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getRequestedName() {
        return requestedName;
    }

    public void setRequestedName(String requestedName) {
        this.requestedName = requestedName;
    }
}
