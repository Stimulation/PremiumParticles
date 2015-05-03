package de.codex01.pp.util;

import de.codex01.pp.listeners.BowListener;
import org.bukkit.Effect;
import org.bukkit.entity.Projectile;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

/**
 * Created by König Jonas on 03.05.2015.
 */
public class BowScheduler extends BukkitRunnable {

    private JavaPlugin plugin;

    public BowScheduler(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void run() {

        final Effect e = BowListener.effect;
        for (Projectile projectile : BowListener.projectiles) {
            ParticleUtil.showParticle(projectile.getLocation(), e);

        }

    }

}