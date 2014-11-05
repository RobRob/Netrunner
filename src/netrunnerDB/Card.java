package netrunnerDB;

import java.util.*;

public class Card {
	
	Map<String, String> attributes = new HashMap<String, String>();
	
	public Card(String text) {
		text = text.replaceAll("\\{", "");
		text = text.replaceAll("\\}", "");
		text = text.replaceAll("\":\"", "dataSeparator");
		text = text.replaceAll("\",\"", "dataSeparator");
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
	public String getTitle() {return attributes.get("title");}
	public String getFlavour() {return attributes.get("flavour");}
	public String getText() {return attributes.get("text");}
	public String getCode() {return attributes.get("code");}
	public String getType() {return attributes.get("type");}
	public String getFaction() {return attributes.get("faction");}
	public String getSetCode() {return attributes.get("set_code");}
	public String getSide() {return attributes.get("side");}
}
