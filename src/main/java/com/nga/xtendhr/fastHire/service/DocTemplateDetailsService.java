package com.nga.xtendhr.fastHire.service;

import java.util.List;

import com.nga.xtendhr.fastHire.model.DocTemplateDetails;

public interface DocTemplateDetailsService {
	public DocTemplateDetails create(DocTemplateDetails item);

	public DocTemplateDetails update(DocTemplateDetails item);

	public void delete(DocTemplateDetails item);

	public List<DocTemplateDetails> findAll();

	public List<DocTemplateDetails> findByName(String name);
}
