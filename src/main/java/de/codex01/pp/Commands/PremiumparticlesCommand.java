package de.codex01.pp.commands;

import de.codex01.pp.Main;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

/**
 * Created by König Jonas on 01.05.2015.
 */
public class PremiumparticlesCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {


        if(args.length < 1) {
            sender.sendMessage(ChatColor.DARK_PURPLE + "---- " + ChatColor.DARK_GREEN + "Premium" + ChatColor.AQUA + "Particles" + ChatColor.DARK_PURPLE +  " ----");
            sender.sendMessage(ChatColor.GREEN + "Coded by codex01");
            sender.sendMessage(ChatColor.GREEN + "/pp reload - Reloaded die Config");
            return true;
        } else {
            if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("pp.relaod")) {
                sender.sendMessage(ChatColor.GREEN + "Die Config wurde gereloaded!");
                Main.plugin.reloadConfig();
                return true;
            }
        }

        return false;
    }

}
