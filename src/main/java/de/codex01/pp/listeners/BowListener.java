package de.codex01.pp.listeners;

import de.codex01.pp.Main;
import de.codex01.pp.util.ParticleUtil;
import org.bukkit.Effect;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.Projectile;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityShootBowEvent;
import org.bukkit.event.entity.ProjectileHitEvent;

import java.util.ArrayList;

/**
 * Created by König Jonas on 03.05.2015.
 */
public class BowListener implements Listener {

    public static ArrayList<Projectile> projectiles = new ArrayList<Projectile>();

    public static Effect effect;

    @EventHandler
    public void onBow(EntityShootBowEvent e) {
        if(!(Main.plugin.getConfig().getBoolean("PP.bowtrail.enabled")))
            return;

        if(e.getEntity().getType().equals(EntityType.PLAYER)) {
            if(e.getProjectile().getType().equals(EntityType.ARROW)) {

                Player p = (Player)e.getEntity();

                if(Main.trails.containsKey(p)) {

                    effect = Main.trails.get(p);
                    projectiles.add((Projectile) e.getProjectile());
                }
            }
        }

    }

    @EventHandler
    public void onLand(ProjectileHitEvent e) {
        if(!(Main.plugin.getConfig().getBoolean("PP.bowtrail.enabled")))
            return;

        Projectile p = e.getEntity();
        if(p.getType() == EntityType.ARROW) {
            if(projectiles.contains(p)) {
                projectiles.remove(p);

                if(Main.plugin.getConfig().getBoolean("PP.bowtrail.landing.enabled"))
                    ParticleUtil.showParticle(p.getLocation(), Effect.STEP_SOUND, 152);
                
            }
        }

    }

}
