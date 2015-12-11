package logic;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.CardDomainModel;
import domain.GameRuleDomainModel;
import enums.eRank;
import enums.eSuit;
import logic.GameRuleBLL;
import pokerBase.Card;
import pokerBase.GamePlay;
import pokerBase.Hand;
import pokerBase.Rule;

public class GameRule_Test {

	private static ArrayList<GameRuleDomainModel> gr;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void GetRules()
	{
		gr = GameRuleBLL.getRules();
		
		assertTrue(gr.size() > 0);
		
	}
	
	/**
	 * Game test given set of hands, pulling game from database
	 */
	@Test
	public void testTexas() {
		HashMap<String, GameRuleDomainModel> gameRules = logic.GameRuleBLL.getRuleHashSet();
		GameRuleDomainModel texas_hold_em = gameRules.get("Texas Hold'em");
		Rule texasHoldEm = new Rule(texas_hold_em);
		GamePlay game = new GamePlay(texasHoldEm);
		
		Hand playerHand = new Hand();
		Card plrCard1 = new Card(eSuit.DIAMONDS, eRank.FOUR, false, 0);
		Card plrCard2 = new Card(eSuit.DIAMONDS, eRank.KING, false, 0);
		Card plrCard3 = new Card(eSuit.DIAMONDS, eRank.SIX, false, 0);
		Card plrCard4 = new Card(eSuit.SPADES, eRank.FIVE, false, 0);
		Card plrCard5 = new Card(eSuit.DIAMONDS, eRank.TEN, false, 0);
		
		playerHand.AddCardToHand(plrCard1);
		playerHand.AddCardToHand(plrCard2);
		playerHand.AddCardToHand(plrCard3);
		playerHand.AddCardToHand(plrCard4);
		playerHand.AddCardToHand(plrCard5);
		
		Hand commHand = new Hand();
		Card commCard1 = new Card(eSuit.HEARTS, eRank.KING, false, 0);
		Card commCard2 = new Card(eSuit.SPADES, eRank.KING, false, 0);
		Card commCard3 = new Card(eSuit.CLUBS, eRank.KING, false, 0);
		Card commCard4 = new Card(eSuit.HEARTS, eRank.FOUR, false, 0);
		Card commCard5 = new Card(eSuit.DIAMONDS, eRank.JACK, false, 0);
		
		commHand.AddCardToHand(commCard1);
		commHand.AddCardToHand(commCard2);
		commHand.AddCardToHand(commCard3);
		commHand.AddCardToHand(commCard4);
		commHand.AddCardToHand(commCard5);
		
		ArrayList<Hand> hands = pokerBase.Hand.ListHands(playerHand, commHand, game);
		Hand bestHand = pokerBase.Hand.PickBestHand(hands);
		System.out.println();
		
		//Will return true if best hand ranks are equal to those of the winning hand
		assertTrue(bestHand.getCardsInHand().get(0).getRank() == eRank.KING);
		assertTrue(bestHand.getCardsInHand().get(1).getRank() == eRank.KING);
		assertTrue(bestHand.getCardsInHand().get(2).getRank() == eRank.KING);
		assertTrue(bestHand.getCardsInHand().get(3).getRank() == eRank.KING);
		assertTrue(bestHand.getCardsInHand().get(4).getRank() == eRank.TEN);
		
		for (Card card : bestHand.getCardsInHand()) {
			System.out.println(card.getRank() + " " + card.getSuit());
		}
		
		
	}
}
