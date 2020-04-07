package com.nga.xtendhr.fastHire.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "\"com.nga.poc.fasthire.db::Table.FHR_DOC_TEMPLATE_TAGS\"", schema = "POC_FAST_HIRE")
@NamedQueries({
		@NamedQuery(name = "DocTemplateTags.findByTemplateId", query = "SELECT DTT FROM DocTemplateTags DTT WHERE DTT.templateId = :templateId") })
public class DocTemplateTags {
	@Id
	@Column(name = "\"DOC_TEMPLATE.ID\"", columnDefinition = "VARCHAR(32)")
	private String templateId;

	@Column(name = "\"TAG\"", columnDefinition = "VARCHAR(32)")
	private String tag;

	@Column(name = "\"ENTITY\"", columnDefinition = "VARCHAR(32)")
	private String entity;

	@Column(name = "\"FIELD_NAME\"", columnDefinition = "VARCHAR(32)")
	private String fieldName;

	public String getTemplateId() {
		return templateId;
	}

	public void setTemplateId(String templateId) {
		this.templateId = templateId;
	}

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public String getEntity() {
		return entity;
	}

	public void setEntity(String entity) {
		this.entity = entity;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

}
