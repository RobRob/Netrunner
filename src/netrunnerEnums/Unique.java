package netrunnerEnums;

public enum Unique {
	ANY(false), YES(true), NO(false); // any uses false, even though it should never be the subject of a search
	
	private boolean uniqueness;
	
	Unique(boolean b) {
		uniqueness = b;
	}
	
	public boolean isUnique() {return uniqueness;}
}
