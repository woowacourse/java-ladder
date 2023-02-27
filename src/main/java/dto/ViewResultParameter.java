package dto;

import java.util.List;

public class ViewResultParameter {

    private final List<String> viewers;
    private final List<String> viewResult;

    public ViewResultParameter(List<String> viewers, List<String> viewResult) {
        this.viewers = viewers;
        this.viewResult = viewResult;
    }

    public List<String> getViewers() {
        return viewers;
    }

    public List<String> getViewResult() {
        return viewResult;
    }
}
