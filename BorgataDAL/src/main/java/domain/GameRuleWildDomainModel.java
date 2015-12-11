package domain;

import enums.eRank;
import enums.eSuit;

public class GameRuleWildDomainModel implements java.io.Serializable {
	protected int WILDID;
	protected int RULEID;
	protected String CARDRANK;
	protected String CARDSUIT;
	
	public GameRuleWildDomainModel() {
		
	}

	public int getWILDID() {
		return WILDID;
	}

	public void setWILDID(int wILDID) {
		WILDID = wILDID;
	}

	public int getRULEID() {
		return RULEID;
	}

	public void setRULEID(int rULEID) {
		RULEID = rULEID;
	}

	public String getCARDRANK() {
		return this.CARDRANK;
	}
	
	public void setCARDRANK(String eRank) {
		this.CARDRANK = eRank;
	}

	public void setCARDSUIT(String eSuit) {
		this.CARDSUIT = eSuit;
	}
	
	public String getCARDSUIT() {
		return this.CARDSUIT;
	}


	
	
}
