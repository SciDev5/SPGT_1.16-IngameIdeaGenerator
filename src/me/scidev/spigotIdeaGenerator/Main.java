package me.scidev.spigotIdeaGenerator;

import java.util.List;

import org.bukkit.plugin.java.JavaPlugin;

import me.scidev.spigotIdeaGenerator.commands.IdeaCommand;
import me.scidev.spigotIdeaGenerator.ideaText.TextAssembler;
import me.scidev.spigotIdeaGenerator.ideaText.TextSnippet;

public class Main extends JavaPlugin {
	
	public static Main instance;
	
	@Override
	public void onEnable() {
		Main.instance = this;
		
		TextAssembler.init();
		loadConfig();
		registerCommands();
	}
	
	
	private void loadConfig() {
		saveDefaultConfig();
		List<String> snippetDataStrings = getConfig().getStringList("spigotIdeaGenerator.snippets");
		
		for (String snippetData : snippetDataStrings) 
			TextAssembler.addSnippet(TextSnippet.parseSnippetString(snippetData));
	}
	
	private void registerCommands() {
		this.getServer().getPluginCommand("idea").setExecutor(new IdeaCommand());
		this.getServer().getPluginCommand("idea").setPermission("spigotIdeaGenerator.commands.idea.use");
	}
}
