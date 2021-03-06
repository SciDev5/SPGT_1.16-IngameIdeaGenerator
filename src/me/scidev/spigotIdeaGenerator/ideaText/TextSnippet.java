package me.scidev.spigotIdeaGenerator.ideaText;

public class TextSnippet {
	
	private String textType;
	private String[] textSections;
	private String[] replacerTypes;
	
	// textIn should contain '%type%' for where more text should be spliced in. Order determines what replacer type will be used.
	public TextSnippet(String thisTypeIn, String textIn) {

		this.textType = thisTypeIn;
		this.textSections = textIn.split("%.*?%");
		
		// Get the number of subsections by finding the number of spaces in this.textSections by taking its length - 1. 
		int numTextSubSections = this.textSections.length-1;
		if (textIn.matches(".*?%.*?%$")) 
			numTextSubSections++;
		this.replacerTypes = new String[numTextSubSections];
		
		// Every odd element inside replacerTypeStrings is inside a % sign and is meant to be a replacer type, select by name and insert into array.
		String[] replacerTypeStrings = textIn.split("%");
		for (int i = 1; i < replacerTypeStrings.length; i += 2) {
			this.replacerTypes[i / 2] = replacerTypeStrings[i].toUpperCase();
		}
	}
	
	public String spliceTextIn(String[] textArrayIn) {
		// Ensure proper amount of text in.
		if (textArrayIn.length != this.replacerTypes.length)
			return null; 
		
		String result = "";
		for (int i = 0; i < textArrayIn.length; i++) {
			result += this.textSections[i] + textArrayIn[i];
		}
		
		// Make sure all the text gets in without causing problems.
		if (this.textSections.length > this.replacerTypes.length)
			result += this.textSections[this.textSections.length-1];
		
		return result;
	}
	
	public String getType() {
		return this.textType;
	}
	
	public String[] getReplacerTypes() {
		return this.replacerTypes.clone();
	}
	
	public static TextSnippet parseSnippetString(String textIn) {
		int indexOfSplit = textIn.indexOf(":");
		String type = textIn.substring(0, indexOfSplit).toUpperCase();
		return new TextSnippet(type, textIn.substring(indexOfSplit+1));
	}
}
