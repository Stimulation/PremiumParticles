package de.codex01.pp;

import de.codex01.pp.Commands.BowtrailCommand;
import de.codex01.pp.Commands.MoveeffectCommand;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.logging.Logger;

/**
 * Created by König Jonas on 30.04.2015.
 */
public class Main extends JavaPlugin {

    public static Main plugin;
    public static Logger log;

    @Override
    public void onEnable() {

        Main.log = Logger.getLogger("PremiumParticles");
        Main.plugin = this;

        log.info("[MyWarper] Aktiviert!");
        log.info("[MyWarper] Coded by codex01");

        this.getCommand("Bowtrail").setExecutor(new BowtrailCommand());
        this.getCommand("Moveeffect").setExecutor(new MoveeffectCommand());

    }

    @Override
    public void onDisable() {

    }

}
