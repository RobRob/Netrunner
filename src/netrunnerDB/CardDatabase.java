package netrunnerDB;
import java.net.*;
import java.util.*;
import java.io.*;

import javax.imageio.ImageIO;
import java.awt.image.*;

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
	
	public static ArrayList<BufferedImage> getCardImages(ArrayList<Card> cardsToImage) {
		ArrayList<BufferedImage> images = new ArrayList<BufferedImage>();
		String URLPath = "http://netrunnerdb.com/web/bundles/netrunnerdbcards/images/cards/en/";
		URL imageURL;
		for (Card c : cardsToImage) {
			try {
			imageURL = new URL(URLPath+c.getAttribute("code") + ".png");
			images.add(ImageIO.read(imageURL));
			}
			catch (MalformedURLException e) {
				System.out.println("Something went wrong with the card to image conversion URL");
				imageURL = null;
			} catch (IOException e) {
				System.out.println("IOException converting the url into image data");
			}
		}
		return images;
	}
}
