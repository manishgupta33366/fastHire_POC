package com.nga.xtendhr.fastHire.service;

import java.util.List;

import com.nga.xtendhr.fastHire.model.SFAPI;

public interface SFAPIService {
	public List<SFAPI> findAll();
	public SFAPI update(SFAPI item);
	public SFAPI create(SFAPI item);
	public SFAPI findById(String entityName, String operation);
	public List<SFAPI> findByEntityName(String entityName);
	public void deleteByObject(SFAPI item);

}
