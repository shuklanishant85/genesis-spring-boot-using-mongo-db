package com.genesis.mongodbservice.repositories;

import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.genesis.mongodbservice.model.Bosses;

public interface BossesRepository extends MongoRepository<Bosses, String> {

	Bosses findBy_id(ObjectId _id);

	Bosses findByName(String name);

	List<Bosses> findByWeapon(String weapon);

	List<Bosses> findByWeaknessOrderByNameAsc(String weakness);

	List<Bosses> findByWeaponAndWeakness(String weapon, String weakness);

	List<Bosses> findByWeaponOrWeakness(String weapon, String weakness);

	List<Bosses> findByWeaknessOrderByNameDesc(String weakness);

	long deleteByName(String name);

	@Query("{ \"name\" : ?0},{ $set : { \"name\" : ?1, \"weapon\" : ?2 , \"weakness\" : ?3 }}")
	Bosses updateBossData(String name, String newName, String weapon, String weakness);

}
