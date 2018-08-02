package com.zycus;

import java.util.List;

public interface CommonDao<T> {
	void create(T object);

	List<T> findAll();

	T findById(long value);
}
