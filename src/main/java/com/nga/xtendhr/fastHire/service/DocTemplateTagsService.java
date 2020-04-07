package com.nga.xtendhr.fastHire.service;

import java.util.List;

import com.nga.xtendhr.fastHire.model.DocTemplateTags;

public interface DocTemplateTagsService {
	public DocTemplateTags create(DocTemplateTags item);

	public DocTemplateTags update(DocTemplateTags item);

	public List<DocTemplateTags> findByTemplateId(String templateId);
}
