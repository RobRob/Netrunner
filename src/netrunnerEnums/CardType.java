package netrunnerEnums;

public enum CardType {
	ANY("Any"), AGENDA("Agenda"), ASSET("Asset"), EVENT("Event"), HARDWARE("Hardware"), ICE("Ice"), 
	IDENTITY("Identity"), OPERATION("Operation"), PROGRAM("Program"), RESOURCE("Resource"), UPGRADE("Upgrade");
	
	private String name;
	
	CardType(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
	
	public static CardType fromName(String name) {
		for (CardType s : CardType.values()) {
			if (s.getName().equals(name)) {
				return s;
			}
		}
		return CardType.ANY;
	}
}
