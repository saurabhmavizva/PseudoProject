package com.avizva.enums;

/**
 * This Enum defines the state in which a Reimbursement Request is,during its lifecycle
 * @author Campus2017
 *
 */
public enum RequestState {
	NEW, DRAFT, WITH_MANAGER, MANAGER_DRAFT, WITH_FINANCE, FINANCE_DRAFT, COMPLETED;
}
