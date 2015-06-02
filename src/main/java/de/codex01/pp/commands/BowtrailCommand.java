package de.codex01.pp.commands;

import de.codex01.pp.Main;
import de.codex01.pp.util.MessageManager;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by König Jonas on 30.04.2015.
 */
public class BowtrailCommand implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {

        if(!(sender instanceof Player))
            return false;

        Player p = (Player) sender;

        if(!(Main.plugin.getConfig().getBoolean("PP.bowtrail.enabled"))) {
            p.sendMessage(MessageManager.message(Main.messageFile, "BowtrailDeactivated"));
            return true;
        }

        ArrayList<Effect> blacklist = new ArrayList<Effect>();
        Effect[] blacklistItems =  { Effect.EXPLOSION_HUGE, Effect.TILE_DUST, Effect.TILE_BREAK, Effect.ITEM_BREAK, Effect.EXPLOSION_LARGE };
        for(int x = 0; x < blacklistItems.length; x++) {
            blacklist.add(blacklistItems[x]);
        }


        if(p.hasPermission("pp.bowtrail")) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < Effect.values().length; i++) {
                if(Effect.values()[i].getType().equals(Effect.Type.PARTICLE)     ) {
                    if(!blacklist.contains(Effect.values()[i])) {
                        sb.append(Effect.values()[i].getName()).append(" , ");
                    }
                }

            }

            String list = sb.toString().trim();

            if(args.length == 0) {

                p.sendMessage("§c/bowtrail clear - Removes all effects");
                p.sendMessage("§c/bowtrail <Effect> - Activates an effect");
                p.sendMessage("§c/bowtrail effects - Shows all effects");
                return true;
            }
            if(args.length >= 1) {

                if(args[0].equalsIgnoreCase("clear") ||args[0].equalsIgnoreCase("remove")) {
                    Main.trails.remove(p);
                    p.sendMessage(MessageManager.message(Main.messageFile, "EffectRemoved"));
                    return true;
                } else if(args[0].equalsIgnoreCase("effects") || args[0].equalsIgnoreCase("list")) {
                    p.sendMessage("§cEffects: §a" + list);
                    p.sendMessage(MessageManager.message(Main.messageFile, "EffectCaseSensitive"));
                    return true;
                }
                else {

                    Effect e = Effect.getByName(args[0]);

                    if(e == null)  {
                        p.sendMessage(MessageManager.message(Main.messageFile, "UnknownEffect"));
                        return true;
                    } else {
                        Main.trails.put(p, e);
                        p.sendMessage(MessageManager.message(Main.messageFile, "ActivatedEffect").replace("%EFFECT%", args[0]));
                        return true;
                    }

                }

            }
        }

        return false;
    }
}
