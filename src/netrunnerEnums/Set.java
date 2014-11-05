package netrunnerEnums;

public enum Set {
	ANY ("Any", "cards/"), CORE_SET ("Core Set", "set/core"), WHAT_LIES_AHEAD ("What Lies Ahead", "set/wla"), 
	TRACE_AMOUNT ("Trace Amount", "set/ta"), CYBER_EXODUS ("Cyber Exodus", "set/ce"), A_STUDY_IN_STATIC ("A Study In Static", "set/asis"),
	HUMANITYS_SHADOW ("Humanity's Shadow", "set/hs"), FUTURE_PROOF ("Future Proof", "set/fp"), CREATION_AND_CONTROL ("Creation And Control", "set/cac"), 
	OPENING_MOVES ("Opening Moves", "set/om"), SECOND_THOUGHTS ("Second Thoughts", "set/st"), MALA_TEMPORA ("Mala Tempora", "set/mt"),
	TRUE_COLORS ("True Colors", "set/tc"), FEAR_AND_LOATHING ("Fear And Loathing", "set/fal"), DOUBLE_TIME ("Double Time", "set/dt"), 
	HONOR_AND_PROFIT ("Honor And Profit", "set/hap"), UPSTALK ("Upstalk", "set/u"), THE_SPACES_BETWEEN ("The Spaces Between", "set/tsb");
	
	private final String name;
	private final String setCode;
	
	Set(String n, String sC) {
		this.name = n;
		this.setCode = sC;
	}
	
	public String getName() {
		return this.name;
	}
	
	public static Set fromName(String name) {
		for (Set s : Set.values()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return Set.ANY;
	}
	
	public String getSetCode() {
		return this.setCode;
	}
}
