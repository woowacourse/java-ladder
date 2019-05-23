package laddergame.domain;

import java.util.List;

public interface NameList {
	String getNameOfIndex(int index);

	boolean isSizeEqual(NameList other);

	int getSize();

	List<? extends AbstractName> getNames();
}
