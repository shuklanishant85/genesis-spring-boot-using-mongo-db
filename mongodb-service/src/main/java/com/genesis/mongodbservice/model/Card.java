package com.genesis.mongodbservice.model;

import java.util.Date;

public class Card {

	private String cardType;
	private String cardNumber;
	private int cvv;
	private Date expiryDate;
	private long limit;
	private long rewardPoints;

	public Card(String cardType, String cardNumber, int cvv, Date expiryDate, long limit, long rewardPoints) {
		this.cardType = cardType;
		this.cardNumber = cardNumber;
		this.cvv = cvv;
		this.expiryDate = expiryDate;
		this.limit = limit;
		this.rewardPoints = rewardPoints;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public long getLimit() {
		return limit;
	}

	public void setLimit(long limit) {
		this.limit = limit;
	}

	public long getRewardPoints() {
		return rewardPoints;
	}

	public void setRewardPoints(long rewardPoints) {
		this.rewardPoints = rewardPoints;
	}

}
