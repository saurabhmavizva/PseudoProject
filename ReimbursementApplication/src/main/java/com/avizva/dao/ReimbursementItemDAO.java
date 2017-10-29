package com.avizva.dao;

import java.util.List;

import com.avizva.model.ReimbursementItem;

/**
 * This DAO is used to used to perform CRUD operations on the ReimbursementItem
 * Model
 * 
 * @author Campus2017
 */
public interface ReimbursementItemDAO {
	public ReimbursementItem addReimbursementItem(ReimbursementItem reimbursementItem);

	public ReimbursementItem deleteReimbursementItem(ReimbursementItem reimbursementItem);

	public ReimbursementItem updateReimbursementItem(ReimbursementItem reimbursementItem);

	public List<ReimbursementItem> viewReimbursementItemsForReimbursementRequest(Integer reimbursementRequestId);

	public ReimbursementItem viewById(Integer id);

}
