package laddergame;

public interface ElementFactory {
	public static final String DELIMITER = ",";

	public abstract BuilderObject createElement();
}
