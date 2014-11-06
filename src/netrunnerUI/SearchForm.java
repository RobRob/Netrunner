package netrunnerUI;

import netrunnerCode.*;
import netrunnerDB.CardDatabase;
import netrunnerEnums.Set;
import netrunnerEnums.Side;
import netrunnerEnums.Unique;
import netrunnerDB.*;
import java.util.*;

public class SearchForm {
	
	String title, text, flavourText, type, subtype, sortBy;
	Set set;
	Side side;
	boolean[] faction;
	Unique unique;
	String costComparator, influenceComparator;
	int cost, influence;
	
	public SearchForm() {
		title = "";
		text = "";
		flavourText = "";
		set = Set.ANY;
		type = "any";
		subtype = "any";
		side = Side.EITHER;
		faction = new boolean[8];
		unique = Unique.ANY;
		costComparator = "=";
		influenceComparator = "=";
		cost = -1;
		influence = -1;
		sortBy = "";
	}
	
	public void getResults() {
		ArrayList<Card> searchDB = CardDatabase.getCardDatabase();
		if (!title.equals("")) {searchDB = CardDatabase.searchAttribute(searchDB, "title", title);}
		if (!text.equals("")) {searchDB = CardDatabase.searchAttribute(searchDB, "text", text);}
		if (!flavourText.equals("")) {searchDB = CardDatabase.searchAttribute(searchDB, "flavour", flavourText);}
		if (set != Set.ANY) {searchDB = CardDatabase.searchAttribute(searchDB, "set_code", set.getSetCode());}
		// search for type
		// search for subtype
		if (side != Side.EITHER) {searchDB = CardDatabase.searchAttribute(searchDB, "side_code", side.toString());}
		// search for faction
		if (unique != Unique.ANY) {searchDB = CardDatabase.searchAttribute(searchDB, "uniqueness", String.valueOf(unique.isUnique()));}
		if (cost != -1) {searchDB = CardDatabase.searchAttributeWithComparator(searchDB, "cost", cost, costComparator);}
		if (influence != -1) {searchDB = CardDatabase.searchAttributeWithComparator(searchDB, "factioncost", influence, influenceComparator);}
		
		for (Card c : searchDB) {
			System.out.println(c.getAttribute("title"));
		}
		
	}
	
	public void setTitle(String t) {title = t;}
	public void setText(String t) {text = t;}
	public void setFlavourText(String f) {flavourText = f;}
	public void setSide(netrunnerEnums.Side s) {side = s;}
	
	public void setFaction(int f) {faction[f] = true;}
	public void removeFaction(int f) {faction[f] = false;}
	
	public void setUnique(netrunnerEnums.Unique u) {unique = u;}
	public void setSet(String s) {set = Set.fromName(s);}
	public void setType(Object t) {type = (String)t;}
	public void setSubType(Object t) {subtype = (String)t;}
	
	public void setCostComparator(Object c) {costComparator = (String)c;}
	public void setCost(int c) {cost = c;}
	
	public void setInfluenceComparator(Object i) {influenceComparator = (String)i;}
	public void setInfluence(int i) {influence = i;}
	
	public void setSortBy(Object s) {sortBy = (String)s;}
	
	public String toString() {
		String returnString = "";
		returnString += title + text + flavourText + set + type + subtype + sortBy + side;
		for (boolean f : faction) {
			returnString += f;
		}
		returnString += unique + costComparator + influenceComparator + cost + influence;
		return returnString;
	}
	
}
