package me.scidev.spigotIdeaGenerator;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import me.scidev.spigotIdeaGenerator.ideaText.TextAssembler;
import me.scidev.spigotIdeaGenerator.ideaText.TextSnippet;

public class Main extends JavaPlugin {
	@Override
	public void onLoad() {
		TextAssembler.init();
		loadConfig();
	}
	
	private void loadConfig() {
		saveDefaultConfig();
		List<String> snippetDataStrings = getConfig().getStringList("spigotIdeaGenerator.snippets");
		
		for (String snippetData : snippetDataStrings) 
			TextAssembler.addSnippet(TextSnippet.parseSnippetString(snippetData));
	}
}
