package finalexam;

import stdlib.StdOut;

public class TestHashTable {

	public static void main(String[] args) {
		HashTable<String, String> states = new HashTable<>(101);
		states.put("Kansas", "Topeka");
		states.put("Hawaii", "Honolulu");
		states.put("Maryland", "Annapolis");
		states.put("Washington", "");
		states.put("Massachusetts", "Boston");
		states.put("Maine", "");
		states.put("California", "Sacremento");
		states.put("Idaho", "Boise");
		states.put("Nevada", "Carson City");
		states.put("West Virginia", "");
		states.put("New York", "Albany");
		states.put("New Hampshire", "Concord");
		states.put("Vermont", "Montpelier");
		states.put("Delaware", "Dover");
		states.put("Nebraska", "Lincoln");
		states.put("New Jersey", "Trenton");
		states.put("New Mexico", "Santa Fe");
		states.put("Texas", "Austin");
		states.put("Pennsylvania", "Harrisburg");
		states.put("Tennessee", "Nashville");
		states.put("Georgia", "Atlanta");
		states.put("Kentucky", "Frankfort");
		states.put("Ohio", "Columbus");
		states.put("Rhode Island", "Providence");
		states.put("Wisconsin", "Madison");
		states.put("Missouri", "Jefferson City");
		states.put("Michigan", "Lansing");
		states.put("Minnesota", "St. Paul");
		states.put("Mississippi", "Jackson");
		states.put("Virginia", "Richmond");
		states.put("Oklahoma", "Oklahoma City");
		states.put("Alaska", "Juneau");
		states.put("Alabama", "Montgomery");
		states.put("Illinois", "Springfield");
		states.put("Florida", "Tallahassee");
		states.put("Indiana", "Indianapolis");
		states.put("Colorado", "Denver");
		states.put("Montana", "Helena");
		states.put("Connecticut", "Hartford");
		states.put("South Dakota", "Pierre");
		states.put("North Carolina", "Raleigh");
		states.put("South Carolina", "Columbia");
		states.put("Louisiana", "Baton Rouge");
		states.put("Iowa", "Des Moines");
		states.put("North Dakota", "Bismarck");
		states.put("Arizona", "Phoenix");
		states.put("Arkansas", "Little Rock");
		states.put("Oregon", "Salem");
		states.put("Utah", "Salt Lake City");
		states.put("Wyoming", "Cheyenne");
		// The states should print in alphabetical order.
		for (String state: states.keys()) {
			StdOut.println(state + ": " + states.get(state));
		}
	}
}
