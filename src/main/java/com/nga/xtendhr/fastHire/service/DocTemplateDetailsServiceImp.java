package com.nga.xtendhr.fastHire.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.nga.xtendhr.fastHire.model.DocTemplateDetails;

@Transactional
@Component
public class DocTemplateDetailsServiceImp implements DocTemplateDetailsService {

	@PersistenceContext
	EntityManager em;

	@Override
	@Transactional
	public DocTemplateDetails create(DocTemplateDetails item) {
		em.persist(item);
		return item;
	}

	@Override
	@Transactional
	public DocTemplateDetails update(DocTemplateDetails item) {
		em.merge(item);
		return item;
	}

	@Override
	@Transactional
	public void delete(DocTemplateDetails item) {
		em.remove(item);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocTemplateDetails> findAll() {
		Query query = em.createNamedQuery("DocTemplateDetails.selectAll");
		List<DocTemplateDetails> items = query.getResultList();
		return items;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<DocTemplateDetails> findByName(String name) {
		Query query = em.createNamedQuery("DocTemplateDetails.findByName").setParameter("name", name);
		List<DocTemplateDetails> items = query.getResultList();
		return items;
	}
}
