package com.nga.xtendhr.fastHire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.poc.fasthire.db::Table.FHR_DOC_TEMPLATES\"", schema = "POC_FAST_HIRE")
@NamedQueries({ @NamedQuery(name = "DocTemplates.findById", query = "SELECT DT FROM DocTemplates DT WHERE DT.id = :id"),
		@NamedQuery(name = "DocTemplates.selectAll", query = "SELECT DT FROM DocTemplates DT") })
public class DocTemplates {
	@Id
	@Column(name = "\"ID\"", columnDefinition = "VARCHAR(32)")
	private String id;

	@Column(name = "\"TEMPLATE\"", columnDefinition = "BLOB")
	private byte[] template;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public byte[] getTemplate() {
		return template;
	}

	public void setTemplate(byte[] template) {
		this.template = template;
	}

}