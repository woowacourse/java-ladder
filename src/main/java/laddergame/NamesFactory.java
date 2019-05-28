package laddergame;

import laddergame.NameList;

public interface NamesFactory {
	String DELIMITER = ",";

	NameList create();
}
