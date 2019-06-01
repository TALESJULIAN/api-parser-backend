package com.tales.apiparserbackend.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.tales.apiparserbackend.entities.Player;
import com.tales.apiparserbackend.repositories.PlayerRepository;
import com.tales.apiparserbackend.services.PlayerService;


public class PlayerServiceImpl implements PlayerService{

	private static final Logger log = LoggerFactory.getLogger(PlayerServiceImpl.class); 
	
	@Autowired
	PlayerRepository playerRepository;
	
	@Override
	public Optional<List<Player>> findAllPlayers() {
		log.info("Searching all players");
		return Optional.ofNullable(playerRepository.findAll());
	}

	@Override
	public Optional<List<Player>> findPlayersByGameNumber(Integer gameNumber) {
		log.info("Searching all players of game number: {}", gameNumber);
		return Optional.ofNullable(playerRepository.findPlayersByGameNumber(gameNumber));
	}

	@Override
	public Optional<Player> findPlayerByGameNumber(Integer number, Integer pNumber) {
		log.info("Searching players : {} " + pNumber + " of game number : {}", number);
		return Optional.ofNullable(playerRepository.findPlayerByGameNumber(number, pNumber));
	}

	@Override
	public Optional<Player> findPlayerByNumber(Integer number) {
		log.info("Finding player number : {}", number);
		return Optional.ofNullable(this.playerRepository.findPlayerByNumber(number));
	}

	@Override
	public Optional<Player> findPlayerByName(String name) {
		log.info("Finding player name : {}", name);
		return Optional.ofNullable(this.playerRepository.findPlayerByName(name));
	}

	public static Logger getLog() {
		return log;
	}

	@Override
	public Player persistir(Player player) {
		log.info("Persisting player : {}", player);
		return this.playerRepository.save(player);
	}

	@Override
	public List<Player> persistAllPlayers(List<Player> players) {
		log.info("Persisting players");
		List<Player> playersPersisted = new ArrayList<>();
		for(Player player : players) {
		    this.playerRepository.save(player);
		    playersPersisted.add(player);
		}
		return playersPersisted;
	}
	
}