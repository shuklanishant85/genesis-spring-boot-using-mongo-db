package com.genesis.mongodbservice.repositories;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.genesis.mongodbservice.model.Bosses;

public interface BossesRepository extends MongoRepository<Bosses, String> {

	Bosses findBy_id(String _id);

	Bosses findByName(String name);

	List<Bosses> findByWeapon(String weapon);

	List<Bosses> findByWeaknessOrderByNameAsc(String weakness);

	List<Bosses> findByWeaponAndWeakness(String weapon, String weakness);

	List<Bosses> findByWeaponOrWeakness(String weapon, String weakness);

	List<Bosses> findByWeaknessOrderByNameDesc(String weakness);
}
