package com.avizva.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

/**
 * This model defines the Project Entity of the web application the project has
 * a project manager that is headedByEmployee
 * 
 * @author Campus2017
 *
 */
@Entity
public class Project {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String projectId;

	private Boolean enabled;

	@NotNull
	@Column(unique = true)
	private String name;

	private String description;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "headedByEmployeeId", insertable = false, updatable = false)
	private Employee headedByEmployee;

	private Integer headedByEmployeeId;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String createdBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	private String modifiedBy;

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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
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

	public Employee getHeadedByEmployee() {
		return headedByEmployee;
	}

	public void setHeadedByEmployee(Employee headedByEmployee) {
		this.headedByEmployee = headedByEmployee;
	}

	public Integer getHeadedByEmployeeId() {
		return headedByEmployeeId;
	}

	public void setHeadedByEmployeeId(Integer headedByEmployeeId) {
		this.headedByEmployeeId = headedByEmployeeId;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

}
