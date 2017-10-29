package com.avizva.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.avizva.dao.ReimbursementItemDAO;
import com.avizva.model.ReimbursementItem;
import com.avizva.service.ReimbursementItemService;

@Service
public class ReimbursementItemServiceImpl implements ReimbursementItemService {

	@Autowired
	private ReimbursementItemDAO reimbursementItemDAO;

	public ReimbursementItem addItem(ReimbursementItem item) {
		ReimbursementItem savedItem = reimbursementItemDAO.addReimbursementItem(item);

		return savedItem;
	}

	public ReimbursementItem updateItem(ReimbursementItem item) {
		ReimbursementItem updatedItem = reimbursementItemDAO.updateReimbursementItem(item);
		return updatedItem;

	}
}
