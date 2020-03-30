package com.nga.xtendhr.fastHire.service;

import java.util.List;

import com.nga.xtendhr.fastHire.model.Field;

public interface FieldService {
	public List<Field> findAll();
	public Field update(Field item);
	public Field create(Field item);
	public Field findById(String id);
	public void deleteByObject(Field item);
}
