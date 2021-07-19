package com.bank.product.service.persistence.entity.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
//@JsonInclude(JsonInclude.Include.NON_NULL)	
public class ProductDetail {

	    private List<String> customerType;
		
		private boolean maintenanceRateTrue;
		private Double maintenanceRate;
		
		private boolean monthlyTransactionLimitTrue;
		private Integer monthlyTransactionLimit;
		
		private boolean retirementTransactionLimitTrue;
		private Integer retirementTransactionLimit;
		
		private boolean dailyDepositTransactionLimitTrue;		
		private Integer dailyDepositTransactionLimit;

		private Integer limitByNaturalCustomer;
		private Integer limitByBusinnesCustomer; 
	}

