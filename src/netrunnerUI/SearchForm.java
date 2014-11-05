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
		costComparator = "";
		influenceComparator = "";
		cost = -1;
		influence = -1;
		sortBy = "";
	}
	
	public void getResults() {
		ArrayList<Card> searchDB = CardDatabase.getCardDatabase();
		if (!title.equals("")) {searchDB = CardDatabase.searchTitles(searchDB, title);}
		if (!text.equals("")) {searchDB = CardDatabase.searchTitles(searchDB, text);}
		if (!flavourText.equals("")) {searchDB = CardDatabase.searchFlavour(searchDB, flavourText);}
		if (set != Set.ANY) {}
		
		for (Card c : searchDB) {
			System.out.println(c.getTitle());
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
