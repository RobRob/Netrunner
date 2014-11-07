package netrunnerEnums;

public enum CardSet {
	ANY ("Any", "cards/"), CORE_SET ("Core Set", "core"), WHAT_LIES_AHEAD ("What Lies Ahead", "wla"), 
	TRACE_AMOUNT ("Trace Amount", "ta"), CYBER_EXODUS ("Cyber Exodus", "ce"), A_STUDY_IN_STATIC ("A Study In Static", "asis"),
	HUMANITYS_SHADOW ("Humanity's Shadow", "hs"), FUTURE_PROOF ("Future Proof", "fp"), CREATION_AND_CONTROL ("Creation And Control", "cac"), 
	OPENING_MOVES ("Opening Moves", "om"), SECOND_THOUGHTS ("Second Thoughts", "st"), MALA_TEMPORA ("Mala Tempora", "mt"),
	TRUE_COLORS ("True Colors", "tc"), FEAR_AND_LOATHING ("Fear And Loathing", "fal"), DOUBLE_TIME ("Double Time", "dt"), 
	HONOR_AND_PROFIT ("Honor And Profit", "hap"), UPSTALK ("Upstalk", "u"), THE_SPACES_BETWEEN ("The Spaces Between", "tsb");
	
	private final String name;
	private final String setCode;
	
	CardSet(String n, String sC) {
		this.name = n;
		this.setCode = sC;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getSetCode() {
		return this.setCode;
	}
	
	public static CardSet fromName(String name) {
		for (CardSet s : CardSet.values()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return CardSet.ANY;
	}
}
