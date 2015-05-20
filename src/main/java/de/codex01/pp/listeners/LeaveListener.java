package de.codex01.pp.listeners;

import de.codex01.pp.Main;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by König Jonas on 03.05.2015.
 */
public class LeaveListener implements Listener {

    @EventHandler
    public void onLeave(PlayerQuitEvent e) {

        Player p = e.getPlayer();

        if(Main.trails.containsKey(p)) {
            Main.trails.remove(p);
        }
        if(Main.effects.containsKey(p)) {
            Main.effects.remove(p);
        }

    }

}
