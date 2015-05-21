package de.codex01.pp.listeners;

import de.codex01.pp.Main;
import de.codex01.pp.util.ParticleUtil;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

/**
 * Created by König Jonas on 03.05.2015.
 */
public class MoveListener implements Listener {

    @EventHandler
    public void onMoveEvent(PlayerMoveEvent e) {

        if(!(Main.plugin.getConfig().getBoolean("PP.moveeffect.enabled")))
            return;

        Player p = e.getPlayer();

        if (Main.effects.containsKey(p)) {
            Effect effect = Main.effects.get(p);
            ParticleUtil.showParticle(p, effect);
        }
    }


}
