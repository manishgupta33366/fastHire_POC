package com.nga.xtendhr.fastHire.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nga.xtendhr.fastHire.model.DocTemplateTags;

@Transactional
@Component
public class DocTemplateTagsServiceImp implements DocTemplateTagsService {
	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public DocTemplateTags update(DocTemplateTags item) {
		em.merge(item);
		return item;
	}

	@Override
	@Transactional
	public DocTemplateTags create(DocTemplateTags item) {
		em.persist(item);
		return item;
	}

	@Override
	public List<DocTemplateTags> findByTemplateId(String templateId) {
		Query query = em.createNamedQuery("DocTemplateTags.findByTemplateId").setParameter("templateId", templateId);
		@SuppressWarnings("unchecked")
		List<DocTemplateTags> items = query.getResultList();
		return items;
	}
}
