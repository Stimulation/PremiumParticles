package de.codex01.pp.commands;

import de.codex01.pp.Main;
import de.codex01.pp.util.MessageManager;
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
            sender.sendMessage(ChatColor.GREEN + "/pp reload - Reloades the config!");
            return true;
        } else {
            if(args[0].equalsIgnoreCase("reload") && sender.hasPermission("pp.reload")) {
                sender.sendMessage(ChatColor.GREEN + MessageManager.message(Main.messageFile, "ReloadedMessage"));
                Main.plugin.reloadConfig();
                MessageManager.reloadConfig(Main.messageFile);
                return true;
            }
        }

        return false;
    }

}
