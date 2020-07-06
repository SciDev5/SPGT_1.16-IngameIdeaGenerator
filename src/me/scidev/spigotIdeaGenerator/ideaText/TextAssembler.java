package me.scidev.spigotIdeaGenerator.ideaText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TextAssembler {
	
	private static Map<TextSnippetType,List<TextSnippet>> allTextSnippets;
	private static Random random;

	public static void init() {
		// Initialize variables.
		allTextSnippets = new HashMap<TextSnippetType, List<TextSnippet>>();
		random = new Random();
	}
	
	public static void addSnippet(TextSnippet snippet) {
		// Get the list corresponding with the new snippet's type to insert into.
		TextSnippetType snippetType = snippet.getType();
		List<TextSnippet> snippetGroup = allTextSnippets.get(snippetType);
		
		// If the snippetGroup is null, create it and insert it into the map.
		if (snippetGroup == null) { 
			snippetGroup = new ArrayList<TextSnippet>();
			allTextSnippets.put(snippetType, snippetGroup);
		}
		
		// Add the new snippet if it is not already in the list.
		if (!snippetGroup.contains(snippet)) 
			snippetGroup.add(snippet);
	}
	
	private static TextSnippet randomSnippetByType(TextSnippetType type) {
		// Get the list corresponding with the new snippet's type to insert into.
		List<TextSnippet> snippetGroup = allTextSnippets.get(type);
		
		// If the snippetGroup is null or empty, return null, there are no snippets of this type.
		if (snippetGroup == null) return null;
		if (snippetGroup.isEmpty()) return null;
		
		// Select a random snippet from the list.
		int index = random.nextInt(snippetGroup.size());
		return snippetGroup.get(index);
	}
	
	public static String assembleSnippet(TextSnippet snippetIn) {
		// Get the replacerTypes of text to substitute into the current snippet.
		TextSnippetType[] replacerTypes = snippetIn.getReplacerTypes();
		String[] subSnippetStrings = new String[replacerTypes.length];
		
		// Select and fill in random snippets according to the replacerTypes from the snippet.
		for (int i = 0; i < replacerTypes.length; i++) {
			TextSnippet subSnippet = randomSnippetByType(replacerTypes[i]);
			subSnippetStrings[i] = assembleSnippet(subSnippet);
		}
		
		// Assemble the text into the snippet.
		return snippetIn.spliceTextIn(subSnippetStrings);
	}
}
