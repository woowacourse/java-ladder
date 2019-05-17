package ladder.model.game;

import ladder.model.tags.Tag;

import java.util.LinkedHashMap;
import java.util.Map;

public class GameResult {
    private Map<Tag, Tag> mappingResult = new LinkedHashMap<>();

    public void addResult(Tag inTag, Tag outTag) {
        mappingResult.put(inTag, outTag);
    }

    public Map<Tag, Tag> getMappingResult() {
        return mappingResult;
    }
}
