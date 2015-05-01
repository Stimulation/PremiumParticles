package de.codex01.pp.commands;

import de.codex01.pp.Main;
import org.bukkit.Effect;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

/**
 * Created by König Jonas on 30.04.2015.
 */
public class MoveeffectCommand implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String cmdLabel, String[] args) {

        Player p = (Player) sender;

        ArrayList<Effect> blacklist = new ArrayList<Effect>();
        Effect[] blacklistItems =  { Effect.EXPLOSION_HUGE, Effect.TILE_DUST, Effect.TILE_BREAK, Effect.ITEM_BREAK, Effect.EXPLOSION_LARGE };
        for(int x = 0; x < blacklistItems.length; x++) {
            blacklist.add(blacklistItems[x]);
        }


        if(p.hasPermission("PowerMiners.moveeffect")) {
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

                p.sendMessage("§c/moveeffect clear - Entfernt alle Effekte");
                p.sendMessage("§c/moveeffect <Effekt> - Fügt den Effekt hinzu");
                p.sendMessage("§c/moveeffect effects - Zeigt alle Effekt Namen");
                return true;
            }
            if(args.length >= 1) {

                if(args[0].equalsIgnoreCase("clear")) {
                    Main.effects.remove(p);
                    p.sendMessage("§a Erfolgreich alle Effekte entfernt!");
                    return true;
                } else if(args[0].equalsIgnoreCase("effects") || args[0].equalsIgnoreCase("list")) {
                    p.sendMessage("§cEffects: §a" + list);
                    p.sendMessage("§cAchtung: Alle Effekte sind Case Sensitive!");
                    return true;
                }
                else {

                    Effect e = Effect.getByName(args[0]);

                    if(e == null)  {
                        p.sendMessage("§aUngültiger Effekt!");
                        return true;
                    } else {
                        Main.effects.put(p, e);
                        p.sendMessage("§aEffekt §c" + args[0] + "§a aktiviert!");
                        return true;
                    }

                }

            }
        }

        return false;
    }
}
