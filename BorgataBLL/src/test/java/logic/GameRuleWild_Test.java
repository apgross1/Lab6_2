package logic;

import static org.junit.Assert.*;

import org.junit.Test;
import domain.GameRuleDomainModel;
import domain.GameRuleWildDomainModel;

public class GameRuleWild_Test {

	@Test
	public void ruleWild_Test() {
		GameRuleDomainModel gr = new GameRuleDomainModel();
		pokerBase.Rule rle = new pokerBase.Rule(gr);
		
		for (Integer i : rle.getiCardsToDraw()) {
			System.out.println("PEANUTS!");
		}
	}

}
