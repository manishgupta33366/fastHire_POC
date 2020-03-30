package com.nga.xtendhr.fastHire.service;

import java.util.List;

import com.nga.xtendhr.fastHire.model.BusinessUnit;

public interface BusinessUnitService {
	public List<BusinessUnit> findAll();
	public BusinessUnit update(BusinessUnit item);
	public BusinessUnit create(BusinessUnit item);
	public BusinessUnit findById(String id);
	public BusinessUnit findDefaultBusinessUnit(Boolean isDefault);
	public void deleteByObject(BusinessUnit item);
}
