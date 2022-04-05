package com.kcb.VoomaApplication.model;


import javax.persistence.*;

@Entity
@Table()
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(
			updatable = false
	)
	private long accountId;
	private String iban;
	private String bankCode;
	private String customerId;

	public Account() {
	}

	public Account(String iban, String bankCode, String customerId) {
		this.iban = iban;
		this.bankCode = bankCode;
		this.customerId = customerId;
	}

	public long getAccountId() {
		return accountId;
	}

	public void setAccountId(long accountId) {
		this.accountId = accountId;
	}

	public String getIban() {
		return iban;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public String getBankCode() {
		return bankCode;
	}

	public void setBankCode(String bankCode) {
		this.bankCode = bankCode;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
}