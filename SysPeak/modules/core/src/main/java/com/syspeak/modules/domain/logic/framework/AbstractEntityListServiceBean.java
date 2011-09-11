package com.syspeak.modules.domain.logic.framework;

import java.util.List;

import com.syspeak.modules.domain.model.AbstractEntity;

public abstract class AbstractEntityListServiceBean<T extends AbstractEntity>
		implements AbstractEntityListService<T> {

	private int maxResults = 20;

	public abstract List<T> getResultList();

	public abstract void setSelectedEntity(T entity);
	public abstract T getSelectedEntity();

	public abstract void refresh();

	public int getMaxResults() {
		return maxResults;
	}

	public void setMaxResults(int maxResults) {
		this.maxResults = maxResults;
	}

	public int[] getMaxResultsOption() {
		return MAX_RESULTS_OPTION;
	}
}
