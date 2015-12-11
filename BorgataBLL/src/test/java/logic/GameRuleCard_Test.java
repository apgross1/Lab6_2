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

import domain.GameRuleCardsDomainModel;
import domain.GameRuleDomainModel;
import logic.GameRuleBLL;

public class GameRuleCard_Test {

	private static ArrayList<GameRuleCardsDomainModel> grCards;
	
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
		grCards = GameRuleCardsBLL.getCardsRules(1);
		
		assertTrue(grCards.size() > 0);
		
	}
	
	/**
	 * Test for getDrawOrder using FiveStud
	 */
	@Test
	public void getOrder() {
		grCards = GameRuleCardsBLL.getCardsRules(1); //FiveStud
		ArrayList<Integer> order = GameRuleCardsBLL.getDrawOrder(grCards);
		
		assertTrue(order.get(0) == 2); //Draw 2
		assertTrue(order.get(1) == 1); //Draw 1
		assertTrue(order.get(2) == 1); //Draw 1
		assertTrue(order.get(3) == 1); //Draw 1
	
	}
	
}
