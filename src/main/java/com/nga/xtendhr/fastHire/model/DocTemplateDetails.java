package com.nga.xtendhr.fastHire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/*
 * AppName: DocGen
 * TableName: DGEN_DOC_TEMPLATE_DETAILS
 * 
 * @author	:	Manish Gupta  
 * @email	:	manish.g@ngahr.com
 * @version	:	0.0.1
 */
@Entity
@Table(name = "\"com.nga.poc.fasthire.db::Table.FHR_DOC_TEMPLATE_DETAILS\"", schema = "POC_FAST_HIRE")
@NamedQueries({
		@NamedQuery(name = "DocTemplateDetails.findById", query = "SELECT DTD FROM DocTemplateDetails DTD WHERE DTD.docTemplateId = :docTemplateId"),
		@NamedQuery(name = "DocTemplateDetails.findByName", query = "SELECT DTD FROM DocTemplateDetails DTD WHERE DTD.name = :name"),
		@NamedQuery(name = "DocTemplateDetails.selectAll", query = "SELECT DTD FROM DocTemplateDetails DTD") })
public class DocTemplateDetails {
	@Id
	@Column(name = "\"DOC_TEMPLATE.ID\"", columnDefinition = "VARCHAR(32)")
	private String docTemplateId;

	@Column(name = "\"NAME\"", columnDefinition = "VARCHAR(32)")
	private String name;

	@Column(name = "\"DESCRIPTION\"", columnDefinition = "VARCHAR(64)")
	private String description;

	public String getDocTemplateId() {
		return docTemplateId;
	}

	public void setDocTemplateId(String docTemplateId) {
		this.docTemplateId = docTemplateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
