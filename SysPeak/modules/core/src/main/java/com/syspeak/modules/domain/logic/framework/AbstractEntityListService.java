package com.syspeak.modules.domain.logic.framework;

import java.util.List;

import com.syspeak.modules.domain.model.AbstractEntity;

public interface AbstractEntityListService<T extends AbstractEntity> {
	int[] MAX_RESULTS_OPTION = { 10, 20, 30, 40, 50 };

	List<T> getResultList();

	int getMaxResults();

	void setMaxResults(int maxResults);

	int[] getMaxResultsOption();

	void setSelectedEntity(T entity);
	T getSelectedEntity();
	
	void refresh();

	void destroy();
}
