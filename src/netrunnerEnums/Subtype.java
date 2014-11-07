package netrunnerEnums;

public enum Subtype {ANY("Any"), AI("AI"), AP("AP"), ADVERTISEMENT("Advertisement"), AMBUSH("Ambush"), BARRIER("Barrier"), 
	BIOROID("Bioroid"), BLACK_OPS("Black Ops"), CAISSA("Caissa"), CHIP("Chip"), CLONE("Clone"), CLOUD("Cloud"), 
	CODE_GATE("Code Gate"), CONDITION("Condition"), CONNECTION("Connection"), CONSOLE("Console"), CURRENT("Current"), 
	CYBERNETIC("Cybernetic"), CYBORG("Cyborg"), DAEMON("Daemon"), DECODER("Decoder"), DEFLECTOR("Deflector"), 
	DESTROYER("Destroyer"), DIVISION("Division"), DOUBLE("Double"), EXECUTIVE("Executive"), EXPANSION("Expansion"), 
	FACILITY("Facility"), FRACTER("Fracter"), G_MOD("G-Mod"), GEAR("Gear"), GOVERNMENT("Government"), GRAY_OPS("Gray Ops"),
	HOSTILE("Hostile"), ICEBREAKER("Icebreaker"), ILLICIT("Illicit"), INITIATIVE("Initiative"), JOB("Job"),
	KILLER("Killer"), LINK("Link"), LOCATION("Location"), MEGACORP("Megacorp"), MOD("Mod"), MYTHIC("Mythic"), 
	NEXT("NEXT"), NATURAL("Natural"), OBSERVER("Observer"), PRIORITY("Priority"), PSI("Psi"), REGION("Region"), 
	REMOTE("Remote"), RESEARCH("Research"), RITZY("Ritzy"), RUN("Run"), SABOTAGE("Sabotage"), SECURITY("Security"), 
	SEEDY("Seedy"), SENTRY("Sentry"), STEALTH("Stealth"), SYSOP("Sysop"), TRACER("Tracer"), TRANSACTION("Transaction"), 
	TRAP("Trap"), UNORTHODOX("Unorthodox"), VIRTUAL("Virtual"), VIRUS("Virus");

	private String name;

	Subtype(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public static Subtype fromName(String name) {
		for (Subtype s : Subtype.values()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return Subtype.ANY;
	}
	
}
