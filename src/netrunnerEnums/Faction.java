package netrunnerEnums;

public enum Faction {
	ANARCH("a"), CRIMINAL("c"), SHAPER("s"), HAAS_BIOROID("h"), JINTEKI("j"), NBN("n"), WEYLAND("w"), NEUTRAL("-");
	
	private String factionCode;
	
	Faction(String fC) {
		factionCode = fC;
	}
	
	public String getFactionCode() {
		return factionCode;
	}
}
