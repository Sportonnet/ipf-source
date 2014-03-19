package com.iplfreaks.dao.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.google.gson.Gson;
import com.iplfreaks.game.Player;
import com.iplfreaks.game.Skill;
import com.iplfreaks.game.Team;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class TeamDaoImplTest {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private TeamDaoImpl teamDaoImpl;

	/**
	 * @param teamDaoImpl the teamDaoImpl to set
	 */
	public void setTeamDaoImpl(TeamDaoImpl teamDaoImpl) {
		this.teamDaoImpl = teamDaoImpl;
	}

	@Test
	public void testFetch() {
		final Query teamDetailsQuery = new Query(Criteria.where("name")
				.is("DD"));

		final Team team = this.mongoTemplate.findOne(teamDetailsQuery,
				Team.class, "team");

		System.out.println(new Gson().toJson(team));

	}
	
	@Test
	public void testGetTeamDetails()
	{
		final Team team = teamDaoImpl.getTeamDetails("Mumbai Indians (MI)");
		Assert.assertNotNull(team);
	}

	//@Test
	public void test() {

		this.mongoTemplate.insert(getTeams(), "team");

	}

	private List<Team> getTeams() {
		List<Team> teams = new ArrayList<Team>();

		teams.add(getMITeam());
		teams.add(getDDTeam());
		teams.add(getRCBTeam());
		teams.add(getCSKTeam());
		teams.add(getKKRTeam());
		teams.add(getRRTeam());
		teams.add(getSRHTeam());
		teams.add(getKXIPTeam());

		return teams;
	}

	private Team getMITeam() {
		Team team = new Team();

		team.setName("MI");
		team.setCountry("India");
		team.setHomeCity("Mumbai");

		// adding players
		Set<Player> players = new HashSet<Player>();
		// adding batsmen
		players.add(getPlayer("MIBAT1", Skill.BATSMAN));
		players.add(getPlayer("MIBAT2", Skill.BATSMAN));
		players.add(getPlayer("MIBAT3", Skill.BATSMAN));
		players.add(getPlayer("MIBAT4", Skill.BATSMAN));
		players.add(getPlayer("MIBAT5", Skill.BATSMAN));

		// adding all rounder
		players.add(getPlayer("MIALL1", Skill.ALLROUNDER));
		players.add(getPlayer("MIALL2", Skill.ALLROUNDER));

		// adding bowler
		players.add(getPlayer("MIBOWL1", Skill.BOWLER));
		players.add(getPlayer("MIBOWL2", Skill.BOWLER));
		players.add(getPlayer("MIBOWL3", Skill.BOWLER));
		players.add(getPlayer("MIBOWL4", Skill.BOWLER));

		team.setPlayers(players);

		return team;
	}

	private Team getDDTeam() {
		Team team = new Team();

		team.setName("DD");
		team.setCountry("India");
		team.setHomeCity("Delhi");

		// adding players
		Set<Player> players = new HashSet<Player>();
		// adding batsmen
		players.add(getPlayer("DDBAT1", Skill.BATSMAN));
		players.add(getPlayer("DDBAT2", Skill.BATSMAN));
		players.add(getPlayer("DDBAT3", Skill.BATSMAN));
		players.add(getPlayer("DDBAT4", Skill.BATSMAN));
		players.add(getPlayer("DDBAT5", Skill.BATSMAN));

		// adding all rounder
		players.add(getPlayer("DDALL1", Skill.ALLROUNDER));
		players.add(getPlayer("DDALL2", Skill.ALLROUNDER));

		// adding bowler
		players.add(getPlayer("DDBOWL1", Skill.BOWLER));
		players.add(getPlayer("DDBOWL2", Skill.BOWLER));
		players.add(getPlayer("DDBOWL3", Skill.BOWLER));
		players.add(getPlayer("DDBOWL4", Skill.BOWLER));

		team.setPlayers(players);

		return team;
	}

	private Team getCSKTeam() {
		Team team = new Team();

		team.setName("CSK");
		team.setCountry("India");
		team.setHomeCity("Chennai");

		// adding players
		Set<Player> players = new HashSet<Player>();
		// adding batsmen
		players.add(getPlayer("CSKBAT1", Skill.BATSMAN));
		players.add(getPlayer("CSKBAT2", Skill.BATSMAN));
		players.add(getPlayer("CSKBAT3", Skill.BATSMAN));
		players.add(getPlayer("CSKBAT4", Skill.BATSMAN));
		players.add(getPlayer("CSKBAT5", Skill.BATSMAN));

		// adding all rounder
		players.add(getPlayer("CSKALL1", Skill.ALLROUNDER));
		players.add(getPlayer("CSKALL2", Skill.ALLROUNDER));

		// adding bowler
		players.add(getPlayer("CSKBOWL1", Skill.BOWLER));
		players.add(getPlayer("CSKBOWL2", Skill.BOWLER));
		players.add(getPlayer("CSKBOWL3", Skill.BOWLER));
		players.add(getPlayer("CSKBOWL4", Skill.BOWLER));

		team.setPlayers(players);

		return team;
	}

	private Team getRCBTeam() {
		Team team = new Team();

		team.setName("RCB");
		team.setCountry("India");
		team.setHomeCity("Bangalore");

		// adding players
		Set<Player> players = new HashSet<Player>();
		// adding batsmen
		players.add(getPlayer("RCBBAT1", Skill.BATSMAN));
		players.add(getPlayer("RCBBAT2", Skill.BATSMAN));
		players.add(getPlayer("RCBBAT3", Skill.BATSMAN));
		players.add(getPlayer("RCBBAT4", Skill.BATSMAN));
		players.add(getPlayer("RCBBAT5", Skill.BATSMAN));

		// adding all rounder
		players.add(getPlayer("RCBALL1", Skill.ALLROUNDER));
		players.add(getPlayer("RCBALL2", Skill.ALLROUNDER));

		// adding bowler
		players.add(getPlayer("RCBBOWL1", Skill.BOWLER));
		players.add(getPlayer("RCBBOWL2", Skill.BOWLER));
		players.add(getPlayer("RCBBOWL3", Skill.BOWLER));
		players.add(getPlayer("RCBBOWL4", Skill.BOWLER));

		team.setPlayers(players);

		return team;
	}

	private Team getKKRTeam() {
		Team team = new Team();

		team.setName("KKR");
		team.setCountry("India");
		team.setHomeCity("Kolkata");

		// adding players
		Set<Player> players = new HashSet<Player>();
		// adding batsmen
		players.add(getPlayer("KKRBAT1", Skill.BATSMAN));
		players.add(getPlayer("KKRBAT2", Skill.BATSMAN));
		players.add(getPlayer("KKRBAT3", Skill.BATSMAN));
		players.add(getPlayer("KKRBAT4", Skill.BATSMAN));
		players.add(getPlayer("KKRBAT5", Skill.BATSMAN));

		// adding all rounder
		players.add(getPlayer("KKRALL1", Skill.ALLROUNDER));
		players.add(getPlayer("KKRALL2", Skill.ALLROUNDER));

		// adding bowler
		players.add(getPlayer("KKRBOWL1", Skill.BOWLER));
		players.add(getPlayer("KKRBOWL2", Skill.BOWLER));
		players.add(getPlayer("KKRBOWL3", Skill.BOWLER));
		players.add(getPlayer("KKRBOWL4", Skill.BOWLER));

		team.setPlayers(players);

		return team;
	}

	private Team getSRHTeam() {
		Team team = new Team();

		team.setName("SRH");
		team.setCountry("India");
		team.setHomeCity("Hyderabad");

		// adding players
		Set<Player> players = new HashSet<Player>();
		// adding batsmen
		players.add(getPlayer("SRHBAT1", Skill.BATSMAN));
		players.add(getPlayer("SRHBAT2", Skill.BATSMAN));
		players.add(getPlayer("SRHBAT3", Skill.BATSMAN));
		players.add(getPlayer("SRHBAT4", Skill.BATSMAN));
		players.add(getPlayer("SRHBAT5", Skill.BATSMAN));

		// adding all rounder
		players.add(getPlayer("SRHALL1", Skill.ALLROUNDER));
		players.add(getPlayer("SRHALL2", Skill.ALLROUNDER));

		// adding bowler
		players.add(getPlayer("SRHBOWL1", Skill.BOWLER));
		players.add(getPlayer("SRHBOWL2", Skill.BOWLER));
		players.add(getPlayer("SRHBOWL3", Skill.BOWLER));
		players.add(getPlayer("SRHBOWL4", Skill.BOWLER));

		team.setPlayers(players);

		return team;
	}

	private Team getRRTeam() {
		Team team = new Team();

		team.setName("RR");
		team.setCountry("India");
		team.setHomeCity("Jaipur");

		// adding players
		Set<Player> players = new HashSet<Player>();
		// adding batsmen
		players.add(getPlayer("RRBAT1", Skill.BATSMAN));
		players.add(getPlayer("RRBAT2", Skill.BATSMAN));
		players.add(getPlayer("RRBAT3", Skill.BATSMAN));
		players.add(getPlayer("RRBAT4", Skill.BATSMAN));
		players.add(getPlayer("RRBAT5", Skill.BATSMAN));

		// adding all rounder
		players.add(getPlayer("RRALL1", Skill.ALLROUNDER));
		players.add(getPlayer("RRALL2", Skill.ALLROUNDER));

		// adding bowler
		players.add(getPlayer("RRBOWL1", Skill.BOWLER));
		players.add(getPlayer("RRBOWL2", Skill.BOWLER));
		players.add(getPlayer("RRBOWL3", Skill.BOWLER));
		players.add(getPlayer("RRBOWL4", Skill.BOWLER));

		team.setPlayers(players);

		return team;
	}

	private Team getKXIPTeam() {
		Team team = new Team();

		team.setName("KXIP");
		team.setCountry("India");
		team.setHomeCity("Panjab");

		// adding players
		Set<Player> players = new HashSet<Player>();
		// adding batsmen
		players.add(getPlayer("KXIPBAT1", Skill.BATSMAN));
		players.add(getPlayer("KXIPBAT2", Skill.BATSMAN));
		players.add(getPlayer("KXIPBAT3", Skill.BATSMAN));
		players.add(getPlayer("KXIPBAT4", Skill.BATSMAN));
		players.add(getPlayer("KXIPBAT5", Skill.BATSMAN));

		// adding all rounder
		players.add(getPlayer("KXIPALL1", Skill.ALLROUNDER));
		players.add(getPlayer("KXIPALL2", Skill.ALLROUNDER));

		// adding bowler
		players.add(getPlayer("KXIPBOWL1", Skill.BOWLER));
		players.add(getPlayer("KXIPBOWL2", Skill.BOWLER));
		players.add(getPlayer("KXIPBOWL3", Skill.BOWLER));
		players.add(getPlayer("KXIPBOWL4", Skill.BOWLER));

		team.setPlayers(players);

		return team;
	}

	/**
	 * private String name;
	 * 
	 * private Skillable skill;
	 */

	private Player getPlayer(String name, Skill skill) {
		final Player player = new Player();

		player.setName(name);
		player.setSkill(skill);

		return player;
	}
}
