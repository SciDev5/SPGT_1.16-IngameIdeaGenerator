package me.scidev.spigotIdeaGenerator.ideaText;

public enum TextSnippetType {
	THING, PERSON, ACTION, LOCATION, BASE;
	
	public static TextSnippetType getByName(String name) {
		if (name.equalsIgnoreCase("THING")) {
			return THING;
		} 
		else if (name.equalsIgnoreCase("PERSON")) {
			return PERSON;
		}
		else if (name.equalsIgnoreCase("ACTION")) {
			return ACTION;
		}
		else if (name.equalsIgnoreCase("LOCATION")) {
			return LOCATION;
		}
		else if (name.equalsIgnoreCase("BASE")) {
			return BASE;
		}
		else {
			return null;
		}
	}
}
