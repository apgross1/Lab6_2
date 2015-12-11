package logic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import domain.CardDomainModel;
import domain.GameRuleCardsDomainModel;
import domain.GameRuleWildDomainModel;
import enums.eRank;
import enums.eSuit;
import base.GameRuleCardsDAL;
import base.GameRuleWildDAL;

public class GameWildRuleBLL {

	public static ArrayList<CardDomainModel> getRuleWilds(int RuleID) {
		
		ArrayList<GameRuleWildDomainModel> grW = new ArrayList<GameRuleWildDomainModel>();
		
		for (GameRuleWildDomainModel grWild: GameRuleWildDAL.getWildRules())
		{
			if (grWild.getRULEID() == RuleID)
			{
				grW.add(grWild);
			}
		}
		
		ArrayList<CardDomainModel> cardDomainWilds = grWildToCardDM(grW);
		
		return cardDomainWilds;

	}
	
	//Do we even need to create a HashMap for the wilds?
	
	/*public static HashMap<Integer,CardDomainModel> getRuleHashSet(int RuleID) {
		HashMap<Integer, CardDomainModel> HashRuleWildSet = new HashMap<Integer, CardDomainModel>();
		
		for (GameRuleWildDomainModel grWild: getRuleWilds(RuleID))
		{
			HashRuleWildSet.put(grWild.getWILDID(), grWild);
		}
		return HashRuleWildSet;
		
	}*/

	private static ArrayList<CardDomainModel> grWildToCardDM(ArrayList<GameRuleWildDomainModel> wilds) {
		ArrayList<CardDomainModel> cardDomainWilds = new ArrayList<CardDomainModel>();
		for (GameRuleWildDomainModel gWD : wilds) {
			CardDomainModel card = new CardDomainModel(eSuit.valueOf(gWD.getCARDSUIT()) , eRank.valueOf(gWD.getCARDRANK()), true, gWD.getWILDID());
			cardDomainWilds.add(card);
		}
		return cardDomainWilds;
	}
	
}
