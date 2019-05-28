package laddergame;

import laddergame.domain.AbstractName;

import java.util.List;

public interface NameList {
	String getNameOfIndex(int index);

	boolean isSizeEqual(NameList other);

	int getSize();

	List<? extends AbstractName> getNames();
}
