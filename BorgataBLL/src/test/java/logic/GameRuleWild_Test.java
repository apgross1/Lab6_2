package logic;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import domain.CardDomainModel;
import domain.GameRuleDomainModel;
import domain.GameRuleWildDomainModel;
import pokerBase.Deck;

public class GameRuleWild_Test {

	/**
	 * Test to see if wilds are added to deck
	 */
	@Test
	public void ruleWild_Test() {
		boolean wild_1 = false;
		boolean wild_2 = false;
		ArrayList<CardDomainModel> wilds = logic.GameWildRuleBLL.getRuleWilds(1);
		Deck wildDeck = new Deck(0,wilds);
		for (CardDomainModel card : wildDeck.getCards()) {
			if (card.getWild() == true && wild_1 == false) {
				wild_1 = true;
			}
			else if (card.getWild() == true && wild_1 == true) {
				wild_2 = true;
			}
			else
				continue;
		}
		
		assertTrue(wild_1);
		assertTrue(wild_2);
	}

}
