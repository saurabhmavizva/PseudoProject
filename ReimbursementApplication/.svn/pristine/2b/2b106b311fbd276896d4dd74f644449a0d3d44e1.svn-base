package com.avizva.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

/**
 * This is the Model class of Allowance entity it sets the Limits for each
 * Designation defined
 * 
 * @author Campus2017
 *
 */
@Entity
public class Allowance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String allowanceId;

	private Boolean enabled;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appliesToCategoryId", insertable = false, updatable = false)
	private Category appliesToCategory;

	@NotNull
	private Integer appliesToCategoryId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "appliesToDesignationId", insertable = false, updatable = false)
	private Designation appliesToDesignation;

	@NotNull
	private Integer appliesToDesignationId;

	private Float allowanceLimit;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String createdBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	private String modifiedBy;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public String getAllowanceId() {
		return allowanceId;
	}

	public void setAllowanceId(String allowanceId) {
		this.allowanceId = allowanceId;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	public Category getAppliesToCategory() {
		return appliesToCategory;
	}

	public void setAppliesToCategory(Category appliesToCategory) {
		this.appliesToCategory = appliesToCategory;
	}

	public Integer getAppliesToCategoryId() {
		return appliesToCategoryId;
	}

	public void setAppliesToCategoryId(Integer appliesToCategoryId) {
		this.appliesToCategoryId = appliesToCategoryId;
	}

	public Float getAllowanceLimit() {
		return allowanceLimit;
	}

	public void setAllowanceLimit(Float allowanceLimit) {
		this.allowanceLimit = allowanceLimit;
	}

	public Date getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}

	public String getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}

	public Date getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public String getModifiedBy() {
		return modifiedBy;
	}

	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}

	public Designation getAppliesToDesignation() {
		return appliesToDesignation;
	}

	public void setAppliesToDesignation(Designation appliesToDesignation) {
		this.appliesToDesignation = appliesToDesignation;
	}

	public Integer getAppliesToDesignationId() {
		return appliesToDesignationId;
	}

	public void setAppliesToDesignationId(Integer appliesToDesignationId) {
		this.appliesToDesignationId = appliesToDesignationId;
	}

}
