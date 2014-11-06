package netrunnerDB;

import java.util.*;

public class Card {
	
	Map<String, String> attributes = new HashMap<String, String>();
	
	public Card(String text) {
		
		text = text.replaceAll("\\{", "");
		text = text.replaceAll("\\}", "");
		
		text = text.replaceAll("\":\"", "dataSeparator");
		text = text.replaceAll("\":(?=[0-9+])", "dataSeparator");
		
		text = text.replaceAll("\",\"", "dataSeparator");
		text = text.replaceAll("(?<=[0-9+]),\"", "dataSeparator");
		boolean isKey = true;
		String[] attributesArray = text.split("dataSeparator");
		String key = "";
		for (String s : attributesArray) {
			if (isKey) {
				key = s;
			}
			else {
				attributes.put(key, s);
			}
			isKey = !isKey;
		}
	}
	
	// all cards should have these attributes
	public String getAttribute(String attributeKey) {return attributes.get(attributeKey);}
}
