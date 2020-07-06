package me.scidev.spigotIdeaGenerator.ideaText;

public enum TextSnippetType {
	THING, PERSON, ACTION, LOCATION;
	
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
		else {
			return null;
		}
	}
}
