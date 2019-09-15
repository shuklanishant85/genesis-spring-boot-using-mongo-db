package com.genesis.mongodbservice.model;

import org.bson.types.ObjectId;

public class Client {

	private ObjectId _id;
	private String clientId;
	private String firstName;
	private String lastName;
	private String contactNo;
	private Card[] cards;

	public Client(ObjectId _id, String clientId, String firstName, String lastName, String contactNo, Card[] cards) {
		this._id = _id;
		this.clientId = clientId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.contactNo = contactNo;
		this.cards = cards;
	}

	public ObjectId get_id() {
		return _id;
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getClientId() {
		return clientId;
	}

	public void setClientId(String clientId) {
		this.clientId = clientId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public Card[] getCards() {
		return cards;
	}

	public void setCards(Card[] cards) {
		this.cards = cards;
	}

}
