package netrunnerUI;

import netrunnerDB.CardDatabase;
import netrunnerEnums.*;
import netrunnerDB.*;
import java.util.*;

public class SearchForm {
	
	String title, text, flavourText, sortBy;
	CardType type;
	Subtype subtype;
	CardSet set;
	Side side;
	Map<Faction, Boolean> factions;
	Unique unique;
	String costComparator, influenceComparator;
	int cost, influence;
	
	public SearchForm(String title, String text, String flavour, CardSet set, CardType type, Subtype subtype, Side side, Map<Faction, Boolean> factions,
			Unique unique, String costComparator, String influenceComparator, int cost, int influence, String sortBy) {
		this.title = title;
		this.text = text;
		this.flavourText = flavour;
		this.set = set;
		this.type = type;
		this.subtype = subtype;
		this.side = side;
		this.factions = factions;
		this.unique = unique;
		this.costComparator = costComparator;
		this.influenceComparator = influenceComparator;
		this.cost = cost;
		this.influence = influence;
		this.sortBy = sortBy;
	}
	
	public void getResults() {
		ArrayList<Card> searchDB = CardDatabase.getCardDatabase();
		if (!title.equals("")) {searchDB = CardDatabase.searchAttribute(searchDB, "title", title);}
		if (!text.equals("")) {searchDB = CardDatabase.searchAttribute(searchDB, "text", text);}
		if (!flavourText.equals("")) {searchDB = CardDatabase.searchAttribute(searchDB, "flavour", flavourText);}
		if (set != CardSet.ANY) {searchDB = CardDatabase.searchAttribute(searchDB, "set_code", set.getSetCode());}
		if (type != CardType.ANY) {searchDB = CardDatabase.searchAttribute(searchDB, "type", type.getName());}
		if (subtype != Subtype.ANY) {searchDB = CardDatabase.searchAttribute(searchDB, "subtype", subtype.getName());}
		if (side != Side.EITHER) {searchDB = CardDatabase.searchAttribute(searchDB, "side_code", side.toString());}
		if (unique != Unique.ANY) {searchDB = CardDatabase.searchAttribute(searchDB, "uniqueness", String.valueOf(unique.isUnique()));}
		if (cost != -1) {searchDB = CardDatabase.searchAttributeWithComparator(searchDB, "cost", cost, costComparator);}
		if (influence != -1) {searchDB = CardDatabase.searchAttributeWithComparator(searchDB, "factioncost", influence, influenceComparator);}
		
		ArrayList<Card> factionSearch = new ArrayList<Card>();
		boolean factionSpecified = false;
		for (Map.Entry<Faction, Boolean> f : factions.entrySet()) {
			if (f.getValue()) {
				// Concatenates separate searches for specific factions into an overall search for multiple factions
				factionSearch.addAll(CardDatabase.searchAttribute(searchDB, "faction_letter", f.getKey().getFactionCode()));
				factionSpecified = true;
			}
		}
		if (factionSpecified) {searchDB = factionSearch;}
		// only sets the search to the result if the user wanted to search at least one faction, to prevent
		// searches for factions being mandatory when the user doesn't want to
		
		for (Card c : searchDB) {
			System.out.println(c.getAttribute("title"));
		}
		
	}
	
	public String toString() {
		String returnString = "";
		returnString += title + text + flavourText + set + type + subtype + sortBy + side;
		for (Map.Entry<Faction, Boolean> f : factions.entrySet()) {
			returnString += f.getValue();
		}
		returnString += unique + costComparator + influenceComparator + cost + influence;
		return returnString;
	}
	
}
