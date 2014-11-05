package netrunnerDB;
import java.net.*;
import java.util.*;
import java.io.*;

public class CardDatabase {
	
	public static ArrayList<Card> getCardDatabase() {
		String[] cardArray = null;
		ArrayList<Card> cardList = new ArrayList<Card>();
		try {
			URL cardData = new URL("http://netrunnerdb.com/api/cards/");
			InputStream csvByteStream = cardData.openStream();
			InputStreamReader csvCharStream = new InputStreamReader(csvByteStream);
			BufferedReader buffRead = new BufferedReader(csvCharStream);
			String newLine;
			String cardCSV = "";
			while ((newLine = buffRead.readLine()) != null ) {
				cardCSV += newLine;
			}
			cardArray = cardCSV.split("\\},\\{");
			cardArray[0].replaceAll("\\[\\{", "");
		}
		catch (Exception e) {System.out.println(e);}
		
		if (cardArray != null) {
			for (String s : cardArray) {
				cardList.add(new Card(s));
			}
		}
		return cardList;
	}
	
	public static ArrayList<Card> searchTitles(ArrayList<Card> cardsToSearch, String targetString) {
		ArrayList<Card> returnList = new ArrayList<Card>();
		for (Card c : cardsToSearch) {
			if (c.getTitle().toLowerCase().contains(targetString.toLowerCase())) {
				returnList.add(c);
			}
		}
		return returnList;
	}
	
	public static ArrayList<Card> searchText(ArrayList<Card> cardsToSearch, String targetString) {
		ArrayList<Card> returnList = new ArrayList<Card>();
		for (Card c : cardsToSearch) {
			if (c.getText().toLowerCase().contains(targetString.toLowerCase())) {
				returnList.add(c);
			}
		}
		return returnList;
	}
	
	public static ArrayList<Card> searchFlavour(ArrayList<Card> cardsToSearch, String targetString) {
		ArrayList<Card> returnList = new ArrayList<Card>();
		for (Card c : cardsToSearch) {
			if (c.getFlavour().toLowerCase().contains(targetString.toLowerCase())) {
				returnList.add(c);
			}
		}
		return returnList;
	}
}
