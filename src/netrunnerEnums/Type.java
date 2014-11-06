package netrunnerEnums;

public enum Type {
	ANY("Any"), AGENDA("Agenda"), ASSET("Asset"), EVENT("Event"), HARDWARE("Hardware"), ICE("Ice"), 
	IDENTITY("Identity"), OPERATION("Operation"), PROGRAM("Program"), RESOURCE("Resource"), UPGRADE("Upgrade");
	
	private String name;
	
	Type(String n) {
		name = n;
	}
	
	public String getName() {
		return name;
	}
}
