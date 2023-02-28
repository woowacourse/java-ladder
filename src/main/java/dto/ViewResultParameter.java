package dto;

import java.util.List;

public class ViewResultParameter {

    private final List<String> viewers;
    private final List<String> viewResult;

    private ViewResultParameter(List<String> viewers, List<String> viewResult) {
        this.viewers = viewers;
        this.viewResult = viewResult;
    }

    public static ViewResultParameter of(List<String> viewers, List<String> viewResult) {
        return new ViewResultParameter(viewers, viewResult);
    }

    public List<String> getViewers() {
        return viewers;
    }

    public List<String> getViewResult() {
        return viewResult;
    }
}
