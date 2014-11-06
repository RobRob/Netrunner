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
	
	public static ArrayList<Card> searchAttribute(ArrayList<Card> cardsToSearch, String attribute, String targetString) {
		ArrayList<Card> returnList = new ArrayList<Card>();
		String att;
		for (Card c : cardsToSearch) {
			if ((att = c.getAttribute(attribute))!= null) {
				if (att.toLowerCase().contains(targetString.toLowerCase())) {
					returnList.add(c);
				}
			}
		}
		return returnList;
	}
	
	public static ArrayList<Card> searchAttributeWithComparator(ArrayList<Card> cardsToSearch, String attribute, int targetInt, String comparator) {
		ArrayList<Card> returnList = new ArrayList<Card>();
		String att; 
		int intAtt;
		for (Card c : cardsToSearch) {
			if ((att = c.getAttribute(attribute)) != null) {
				intAtt = Integer.parseInt(att);
				if (comparator.equals("=")) {
					if (intAtt == targetInt) {returnList.add(c);}
				}
				else if (comparator.equals(">")) {
					if (intAtt > targetInt) {returnList.add(c);}
				}
				else if (comparator.equals("<")) {
					if (intAtt < targetInt) {returnList.add(c);}
				}
			}
		}
		return returnList;
	}
}
