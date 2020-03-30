package com.nga.xtendhr.fastHire.service;

import java.util.List;

import com.nga.xtendhr.fastHire.model.ContractCriteria;

public interface ContractCriteriaService {
	public List<ContractCriteria> findByCountryCompany(String country , String company);
}
