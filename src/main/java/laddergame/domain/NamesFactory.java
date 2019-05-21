package laddergame.domain;

public interface NamesFactory {
	String DELIMITER = ",";

	NameList create();
}
