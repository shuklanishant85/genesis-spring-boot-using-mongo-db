package com.genesis.mongodbservice.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

public class Bosses {
	@Id
	public ObjectId _id;
	public String name;
	public String weapon;
	public String weakness;

	public Bosses(ObjectId _id, String name, String weapon, String weakness) {
		super();
		this._id = _id;
		this.name = name;
		this.weapon = weapon;
		this.weakness = weakness;
	}

	public String get_id() {
		return _id.toString();
	}

	public void set_id(ObjectId _id) {
		this._id = _id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public String getWeakness() {
		return weakness;
	}

	public void setWeakness(String weakness) {
		this.weakness = weakness;
	}

}
