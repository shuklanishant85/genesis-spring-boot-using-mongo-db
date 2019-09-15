package com.genesis.mongodbservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.genesis.mongodbservice.model.Bosses;
import com.genesis.mongodbservice.repositories.BossesRepository;

@RestController
@RequestMapping("/megaman/bosses")
public class Controller {

	@Autowired
	private BossesRepository bossesRepository;

	@GetMapping("/{id}")
	public Bosses getBossesById(@PathVariable("id") String id) {
		return bossesRepository.findBy_id(id);
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

}
