package com.nga.xtendhr.fastHire.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nga.xtendhr.fastHire.model.DocTemplates;

@Transactional
@Component
public class DocTemplatesServiceImp implements DocTemplatesService {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public DocTemplates create(DocTemplates item) {
		em.persist(item);
		return item;
	}

	@Override
	@Transactional
	public DocTemplates update(DocTemplates item) {
		em.merge(item);
		return item;
	}

	@Override
	@Transactional
	public void delete(DocTemplates item) {
		em.remove(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocTemplates> findAll() {
		Query query = em.createNamedQuery("DocTemplates.selectAll");
		List<DocTemplates> items = query.getResultList();
		return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocTemplates> findById(String id) {
		Query query = em.createNamedQuery("DocTemplates.findById").setParameter("id", id);
		List<DocTemplates> items = query.getResultList();
		return items;
	}
}
