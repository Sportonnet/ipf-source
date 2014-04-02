import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.util.Assert;

import com.iplfreaks.core.BonusEntity;
import com.iplfreaks.core.Challenger;
import com.iplfreaks.dao.impl.CricketLeagueScoreDaoImpl;
import com.iplfreaks.game.Player;
import com.iplfreaks.game.Team;
import com.iplfreaks.game.cricket.CricketChallenge;
import com.iplfreaks.game.cricket.CricketLeagueScore;
import com.iplfreaks.game.cricket.CricketPrediction;
import com.iplfreaks.user.User;

/**
 * 
 */

/**
 * @author jayeshm3
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/META-INF/spring/spring-config-test.xml")
public class CricketLeagueScoreDaoImplTest {
	

	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Autowired
	private CricketLeagueScoreDaoImpl cricketLeagueScoreDaoImpl;
	
	//@Test
	public void testInsertCricketLeagueScore()
	{
		this.cricketLeagueScoreDaoImpl.createNewCricketLeagueScore(createCricketLeagueScore());
	}
	
	@Test
	public void testAddChallengerPrediction()
	{
		final CricketPrediction cricketPrediction = new CricketPrediction();
		
		final Player player = new Player();
		player.setName("Sachin Tendulkar");
		
		final User user = new User();
		user.setEmail("ch1@gmail.com");
		
		final Challenger challenger = new Challenger();
		challenger.setName("ch1");
		challenger.setUser(user);
		
		final Team team = new Team();
		team.setName("MI");
		
		final List<BonusEntity> bonus = new ArrayList<BonusEntity>();
		
		final BonusEntity be1 = new BonusEntity();
		be1.setBonusQuestion("Which team will win the toss ?");
		be1.setBonusAnswer("MI");
		bonus.add(be1);
		
		final BonusEntity be2 = new BonusEntity();
		be2.setBonusQuestion("What will be the distance of the longest of the six in the match ?");
		be2.setBonusAnswer("80 - 85 yards");
		bonus.add(be2);
		
		cricketPrediction.setBestBatsman(player);
		cricketPrediction.setBestBowler(player);
		cricketPrediction.setManOfTheMatch(player);
		cricketPrediction.setWinnerTeam(team);
		cricketPrediction.setBonus(bonus);
		
		cricketPrediction.setChallenger(challenger);
		
		this.cricketLeagueScoreDaoImpl.addChallengerPrediction("l1", "DD vs MI @ 25-03-2014", cricketPrediction);
		
	}
	
	@Test
	public void testFetchUserChallenge()
	{
		final CricketLeagueScore leagueScoreDetails = this.cricketLeagueScoreDaoImpl.fetchUserChallenge("l1", "DD vs MI @ 25-03-2014", "ch1@gmail.com");
		Assert.notNull(leagueScoreDetails);
		
		final Set<CricketChallenge> challenges = leagueScoreDetails.getFixturePredictionList();
		System.out.println("Challenges size : " + challenges.size());
		
		for(final CricketChallenge challenge : challenges)
		{
			System.out.println("Fixture : " + challenge.getFixtureId());
			final Set<CricketPrediction> predictions = challenge.getPredictions();
			if(predictions == null || predictions.isEmpty())
			{
				System.out.println("No pred");
				continue;
			}
			
			for(final CricketPrediction cp : predictions)
			{
				System.out.println(cp.getBonus().get(1).getBonusAnswer());
			}
		}
		
	}
	
	private CricketLeagueScore createCricketLeagueScore()
	{
		final CricketLeagueScore lsd = new CricketLeagueScore("l1");
		
		Set<CricketChallenge> challenges = new HashSet<CricketChallenge>();
		
		final CricketChallenge challenge1 = new CricketChallenge();
		challenge1.setFixtureId("MI vs RCB @ 27-03-2014");
		challenges.add(challenge1);
		
		final CricketChallenge challenge2 = new CricketChallenge();
		challenge2.setFixtureId("DD vs RCB @ 26-03-2014");
		challenges.add(challenge2);
		
		final CricketChallenge challenge3 = new CricketChallenge();
		challenge3.setFixtureId("DD vs MI @ 25-03-2014");
		challenges.add(challenge3);
		
		lsd.addAllFixturePrediction(challenges);
		
		return lsd;
	}

	/**
	 * @return the mongoTemplate
	 */
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	/**
	 * @param mongoTemplate the mongoTemplate to set
	 */
	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	/**
	 * @return the cricketLeagueScoreDaoImpl
	 */
	public CricketLeagueScoreDaoImpl getCricketLeagueScoreDaoImpl() {
		return cricketLeagueScoreDaoImpl;
	}

	/**
	 * @param cricketLeagueScoreDaoImpl the cricketLeagueScoreDaoImpl to set
	 */
	public void setCricketLeagueScoreDaoImpl(CricketLeagueScoreDaoImpl cricketLeagueScoreDaoImpl) {
		this.cricketLeagueScoreDaoImpl = cricketLeagueScoreDaoImpl;
	}



}
