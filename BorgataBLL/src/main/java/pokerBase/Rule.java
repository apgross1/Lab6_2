package pokerBase;

import java.util.ArrayList;
import java.util.UUID;

import domain.CardDomainModel;
import domain.GameRuleDomainModel;
import enums.eGame;
import enums.eRank;
import enums.eSuit;
import logic.GameRuleCardsBLL;

public class Rule {

	private UUID GAMEID;
	private ArrayList<Integer> iCardsToDraw;
	private ArrayList<CardDomainModel> RuleCards;
	private ArrayList<CardDomainModel> WildCards;
	private int TotalCardsToDraw;
	private GameRuleDomainModel grD;
	
	public Rule() {
		
	}
	
	public Rule(GameRuleDomainModel grD) {
		this.setGrD(grD);
		this.setiCardsToDraw();
	}
	
	public ArrayList<CardDomainModel> GetRuleCards()
	{
		return this.RuleCards;
	}


	public void setRuleCards(ArrayList<CardDomainModel> ruleCards) {
		RuleCards = ruleCards;
	}

	public int getTotalCardsToDraw()
	{
		return this.getGrD().getPLAYERNUMBEROFCARDS()+ this.getGrD().getCOMMUNITYCARDSMAX();
	}

	public ArrayList<Integer> getiCardsToDraw() {
		return iCardsToDraw;
	}

	public void setiCardsToDraw() {
		this.iCardsToDraw = GameRuleCardsBLL.getDrawOrder(GameRuleCardsBLL.getCardsRules(getGrD().getRULEID()));
	}
	
	public UUID getGAMEID() {
		return GAMEID;
	}
	public void setGAMEID(UUID gAMEID) {
		GAMEID = gAMEID;
	}
	
	public ArrayList<CardDomainModel> getWildCards() {
		return WildCards;
	}
	public void setWildCards(ArrayList<CardDomainModel> wildCards) {
		this.WildCards = wildCards;
	}

	public GameRuleDomainModel getGrD() {
		return grD;
	}

	public void setGrD(GameRuleDomainModel grD) {
		this.grD = grD;
	}
}