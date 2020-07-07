package me.scidev.spigotIdeaGenerator.commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import me.scidev.spigotIdeaGenerator.ideaText.TextAssembler;
import me.scidev.spigotIdeaGenerator.ideaText.TextSnippet;

public class IdeaCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String alias, String[] args) {
		if (args.length != 0) {
			sender.sendMessage(ChatColor.RED+"Error: Must have 0 arguments.");
			return true;
		}
		
		TextSnippet base = TextAssembler.randomBaseSnippet();
		String ideaString = TextAssembler.assembleSnippet(base);
		
		sender.sendMessage(ChatColor.GREEN+"Here's an idea: \""+ideaString+"\"");
		
		return true;
	}

}
