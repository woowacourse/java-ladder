package laddergame;

public interface NamesFactory {
	public static final String DELIMITER = ",";

	public abstract NameList create();
}
