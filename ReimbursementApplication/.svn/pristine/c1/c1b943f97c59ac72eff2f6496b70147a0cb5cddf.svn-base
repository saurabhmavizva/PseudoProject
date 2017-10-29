package com.avizva.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.CreationTimestamp;

/**
 * This model is used to define the Reimbursement Item that a Reimbursement
 * Request will have
 * 
 * @author Campus2017
 *
 */
@Entity
public class ReimbursementItem {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String itemId;

	private Boolean enabled;

	@NotNull
	private String billNumber;

	@NotNull
	@Temporal(TemporalType.TIMESTAMP)
	private Date billDate;

	private String currency;

	private Double exchangeRate;

	private String fileName;

	private String description;

	private Boolean approved;

	private Boolean managerApproved;

	private Boolean financeApproved;

	@NotNull
	private Double amount;

	@ManyToOne
	@JoinColumn(name = "requestId", insertable = false, updatable = false)
	private ReimbursementRequest request;

	private Integer requestId;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdDate;

	private String createdBy;

	@CreationTimestamp
	@Temporal(TemporalType.TIMESTAMP)
	private Date modifiedDate;

	private String modifiedBy;

	public String getItemId() {
		return itemId;
	}

	public void setItemId(String itemId) {
		this.itemId = itemId;
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

	public String getBillNumber() {
		return billNumber;
	}

	public void setBillNumber(String billNumber) {
		this.billNumber = billNumber;
	}

	public Date getBillDate() {
		return billDate;
	}

	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public Double getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(Double exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Boolean getApproved() {
		return approved;
	}

	public void setApproved(Boolean approved) {
		this.approved = approved;
	}

	public Boolean getManagerApproved() {
		return managerApproved;
	}

	public void setManagerApproved(Boolean managerApproved) {
		this.managerApproved = managerApproved;
	}

	public Boolean getFinanceApproved() {
		return financeApproved;
	}

	public void setFinanceApproved(Boolean financeApproved) {
		this.financeApproved = financeApproved;
	}

	public ReimbursementRequest getRequest() {
		return request;
	}

	public void setRequest(ReimbursementRequest request) {
		this.request = request;
	}

	public Integer getRequestId() {
		return requestId;
	}

	public void setRequestId(Integer requestId) {
		this.requestId = requestId;
	}

}
