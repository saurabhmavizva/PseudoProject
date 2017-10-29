package com.avizva.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.CreationTimestamp;

import com.avizva.enums.RequestState;

/**
 * This model class defines the Reimbursement Request entity which a user will
 * create. This will have a specific state which will define where this request
 * is currently also it will keep timestamping the name of the concerned
 * authority whoever is modifying or approving it in any phase of its lifecycle
 * 
 * @author Campus2017
 *
 */
@Entity
public class ReimbursementRequest {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String reimbursementId;

	private Boolean enabled;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "categoryId", insertable = false, updatable = false)
	private Category category;

	private Integer categoryId;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employeeId", insertable = false, updatable = false)
	private Employee employee;

	private Integer employeeId;

	@Enumerated(EnumType.ORDINAL)
	private RequestState state;

	private String manageremail;

	private String financeemail;

	@Temporal(TemporalType.TIMESTAMP)
	private Date submissionDate;

	private Double amountRequested;

	private Double amountApproved;

	private Integer approvedItemsCount;

	private String managerComments;

	private String financeComments;

	@OneToMany(mappedBy = "request")
	private List<ReimbursementItem> items;

	@Temporal(TemporalType.TIMESTAMP)
	private Date ManagerApprovalDate;

	@Temporal(TemporalType.TIMESTAMP)
	private Date FinanceApprovalDate;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String createdBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	private String modifiedBy;

	public String getReimbursementId() {
		return reimbursementId;
	}

	public void setReimbursementId(String reimbursementId) {
		this.reimbursementId = reimbursementId;
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

	public String getManageremail() {
		return manageremail;
	}

	public void setManageremail(String manageremail) {
		this.manageremail = manageremail;
	}

	public String getFinanceemail() {
		return financeemail;
	}

	public void setFinanceemail(String financeemail) {
		this.financeemail = financeemail;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public RequestState getState() {
		return state;
	}

	public void setState(RequestState state) {
		this.state = state;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Double getAmountRequested() {
		return amountRequested;
	}

	public void setAmountRequested(Double amountRequested) {
		this.amountRequested = amountRequested;
	}

	public Double getAmountApproved() {
		return amountApproved;
	}

	public void setAmountApproved(Double amountApproved) {
		this.amountApproved = amountApproved;
	}

	public String getManagerComments() {
		return managerComments;
	}

	public void setManagerComments(String managerComments) {
		this.managerComments = managerComments;
	}

	public String getFinanceComments() {
		return financeComments;
	}

	public void setFinanceComments(String financeComments) {
		this.financeComments = financeComments;
	}

	public List<ReimbursementItem> getItems() {
		return items;
	}

	public void setItems(List<ReimbursementItem> items) {
		this.items = items;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Integer getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}

	public Date getFinanceApprovalDate() {
		return FinanceApprovalDate;
	}

	public Date getManagerApprovalDate() {
		return ManagerApprovalDate;
	}

	public void setManagerApprovalDate(Date managerApprovalDate) {
		ManagerApprovalDate = managerApprovalDate;
	}

	public void setFinanceApprovalDate(Date financeApprovalDate) {
		FinanceApprovalDate = financeApprovalDate;
	}

	public Integer getApprovedItemsCount() {
		return approvedItemsCount;
	}

	public void setApprovedItemsCount(Integer approvedItemsCount) {
		this.approvedItemsCount = approvedItemsCount;
	}

}