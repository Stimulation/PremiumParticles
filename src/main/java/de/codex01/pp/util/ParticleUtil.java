package de.codex01.pp.util;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.entity.Player;

/**
 * Created by König Jonas on 01.05.2015.
 */
public class ParticleUtil {

    /**
     *
     * @param p
     * @param e
     *
     * Shows a particle over the head of the given Player
     *
     */
    public static void showParticle(Player p, Effect e) {

        Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() + 2.2, p.getLocation().getZ());
        loc.getWorld().playEffect(loc, e, null);

    }

    /**
     *
     * @param loc
     * @param e
     *
     * Shows a particle at the given location
     *
     */
    public static void showParticle(Location loc, Effect e) {

        loc.getWorld().playEffect(loc, e, null);

    }

    /**
     *
     * @param loc
     * @param e
     *
     * Shows a particle at the given location
     *
     */
    public static void showParticle(Location loc, Effect e, int i) {

        loc.getWorld().playEffect(loc, e, i);

    }

}
