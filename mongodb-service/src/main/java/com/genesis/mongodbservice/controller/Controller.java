package com.genesis.mongodbservice.controller;

import java.util.List;

import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.mongodbservice.model.Bosses;
import com.genesis.mongodbservice.repositories.BossesRepository;

@RestController
@RequestMapping("/megaman/bosses")
public class Controller {

	private static final Logger LOGGER = LoggerFactory.getLogger(Controller.class);

	@Autowired
	private BossesRepository bossesRepository;

	@GetMapping("/{id}")
	public Bosses getBossesById(@PathVariable("id") String id) {
		return bossesRepository.findBy_id(new ObjectId(id));
	}

	@GetMapping("/name/{name}")
	public Bosses getBossesByName(@PathVariable("name") String name) {
		return bossesRepository.findByName(name);
	}

	@GetMapping("/weapon/{weapon}")
	public List<Bosses> getBossesByWeapon(@PathVariable("weapon") String weapon) {
		return bossesRepository.findByWeapon(weapon);
	}

	@GetMapping("/weakness/{weakness}")
	public List<Bosses> getBossesByWeakness(@PathVariable("weakness") String weakness,
			@RequestParam(value = "order", defaultValue = "asc") String order) {
		if (order.equalsIgnoreCase("desc")) {
			return bossesRepository.findByWeaknessOrderByNameDesc(weakness);
		}
		return bossesRepository.findByWeaknessOrderByNameAsc(weakness);
	}

	@GetMapping("/weapon/{weapon}/and/weakness/{weakness}")
	public List<Bosses> getBossesByWeaponAndWeakness(@PathVariable("weapon") String weapon,
			@PathVariable("weakness") String weakness) {
		return bossesRepository.findByWeaponAndWeakness(weapon, weakness);
	}

	@GetMapping("/weapon/{weapon}/or/weakness/{weakness}")
	public List<Bosses> getBossesByWeaponAOrWeakness(@PathVariable("weapon") String weapon,
			@PathVariable("weakness") String weakness) {
		return bossesRepository.findByWeaponOrWeakness(weapon, weakness);
	}

	@GetMapping("/all")
	public List<Bosses> getAllBosses() {
		return bossesRepository.findAll();
	}

	@PutMapping("/update/{name}")
	public Bosses updateBosses(@PathVariable("name") String name, @RequestBody Bosses updatedBoss) {
		LOGGER.info("name: {} , weapon: {} , weakness: {} ", updatedBoss.getName(), updatedBoss.getWeapon(),
				updatedBoss.getWeakness());
		return bossesRepository.updateBossData(name, updatedBoss.getName(), updatedBoss.getWeapon(),
				updatedBoss.getWeakness());
	}

	@PostMapping("/update/{name}")
	public Bosses updateBossByName(@PathVariable("name") String name, @RequestBody Bosses updatedBoss) {
		LOGGER.info("name: {} , weapon: {} , weakness: {} ", updatedBoss.getName(), updatedBoss.getWeapon(),
				updatedBoss.getWeakness());
		Bosses boss = bossesRepository.findByName(name);
		updatedBoss.set_id(boss.get_id());
		bossesRepository.save(updatedBoss);
		return bossesRepository.findByName(name);
	}

	@DeleteMapping("/update/{name}")
	public boolean deleteBossByName(@PathVariable("name") String name) {
		bossesRepository.deleteByName(name);
		return true;
	}
}
