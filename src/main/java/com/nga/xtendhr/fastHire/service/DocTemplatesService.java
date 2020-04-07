package com.nga.xtendhr.fastHire.service;

import java.util.List;

import com.nga.xtendhr.fastHire.model.DocTemplates;

public interface DocTemplatesService {
	public DocTemplates create(DocTemplates item);

	public DocTemplates update(DocTemplates item);

	public void delete(DocTemplates item);

	public List<DocTemplates> findAll();

	public List<DocTemplates> findById(String id);
}
