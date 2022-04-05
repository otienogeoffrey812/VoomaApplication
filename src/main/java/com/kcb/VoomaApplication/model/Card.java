package com.kcb.VoomaApplication.model;


import javax.persistence.*;

@Entity
@Table()
public class Card {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(
			updatable = false
	)
	private long cardId;
	private String cardAlias;
	@Column(
			updatable = false
	)
	private String accountId;
	@Enumerated(EnumType.STRING)
	@Column(
			updatable = false
	)
	private CardTypes cardType;

	public long getCardId() {
		return cardId;
	}

	public void setCardId(long cardId) {
		this.cardId = cardId;
	}

	public String getCardAlias() {
		return cardAlias;
	}

	public void setCardAlias(String cardAlias) {
		this.cardAlias = cardAlias;
	}

	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	public CardTypes getCardType() {
		return cardType;
	}

	public void setCardType(CardTypes cardType) {
		this.cardType = cardType;
	}
}