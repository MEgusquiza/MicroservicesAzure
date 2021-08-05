package com.bank.app.model;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "condition")
public class Condition {
	private List<String> customerTypeTarget;
	
	private boolean hasMaintenanceFee;
	private Double maintenanceFee;
	
	private boolean hasMonthlyTransactionLimit;
	private Integer monthlyTransactionLimit;
	
	private boolean hasDailyWithdrawalTransactionLimit;
	private Integer dailyWithdrawalTransactionLimit;
	
	private boolean hasDailyDepositTransactionLimit;
	private Integer dailyDepositTransactionLimit;
	
	/*private Integer creditPerPersonLimit;
	private Integer creditPerBusinessLimit;*/
	
	private Integer productPerPersonLimit;
	private Integer productPerBusinessLimit; 
}
