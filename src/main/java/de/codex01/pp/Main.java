package de.codex01.pp;

import de.codex01.pp.cmds.BowtrailCommand;
import de.codex01.pp.cmds.MoveeffectCommand;
import de.codex01.pp.cmds.PremiumparticlesCommand;
import de.codex01.pp.listeners.BowListener;
import de.codex01.pp.listeners.LeaveListener;
import de.codex01.pp.listeners.MoveListener;
import de.codex01.pp.util.BowScheduler;
import de.codex01.pp.util.MessageManager;
import org.bukkit.Effect;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by König Jonas on 30.04.2015.
 */
public class Main extends JavaPlugin {

    public static Main plugin;
    public static Logger log;

    public static File messageFile = new File("plugins/PremiumParticles", "messages.yml");
    public static File configFile = new File("plugins/PremiumParticles", "config.yml");

    public static Map<Player, Effect> effects = new HashMap<Player, Effect>();
    public static Map<Player, Effect> trails = new HashMap<Player, Effect>();
    public static Map<Player, Effect> achievements = new HashMap<Player, Effect>();

    @Override
    public void onEnable() {

        MessageManager.setUp(messageFile);

        Main.log = Logger.getLogger("PremiumParticles");
        Main.plugin = this;

        log.info("[PremiumParticles] Activated!");
        log.info("[PremiumParticles] Coded by codex01");

        this.getCommand("PremiumParticles").setExecutor(new PremiumparticlesCommand());
        this.getCommand("Bowtrail").setExecutor(new BowtrailCommand());
        this.getCommand("Moveeffect").setExecutor(new MoveeffectCommand());

        PluginManager pm = this.getServer().getPluginManager();
        pm.registerEvents(new MoveListener(), this);
        pm.registerEvents(new BowListener(), this);
        pm.registerEvents(new LeaveListener(), this);

        BowScheduler bs = new BowScheduler(this);
        bs.runTaskTimer(this, 20, 1);

        this.getConfig().addDefault("PP.bowtrail.enabled", true);
        this.getConfig().addDefault("PP.bowtrail.landing.enabled", true);
        this.getConfig().addDefault("PP.moveeffect.enabled", true);
        this.saveDefaultConfig();
        this.getConfig().options().copyDefaults(true);

        this.saveConfig();
    }

    @Override
    public void onDisable() {

        log.info("[PremiumParticles] Deactivated!");

    }

}
