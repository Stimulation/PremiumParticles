package de.codex01.pp.util;

import de.codex01.pp.Main;
import org.bukkit.ChatColor;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by König Jonas on 20.05.2015.
 */
public class MessageManager {

    public static void standardMessages(File f) {

        setMessage(f, "ReloadedMessage", "&aSuccessfully reloaded the config!");
        setMessage(f, "MoveEffectDeactivated", "&aMoveeffects are disabled!");
        setMessage(f, "BowtrailDeactivated", "&aBowtrails are disabled!");
        setMessage(f, "EffectRemoved", "&aSuccessfully disabled all effects!");
        setMessage(f, "EffectCaseSensitive", "&cWarning: All effects are Case Sensitive!");
        setMessage(f, "UnknownEffect", "&cUnkown Effect!");
        setMessage(f, "ActivatedEffect", "&aActivated effect %EFFECT% !");

    }

    public static void setUp(File f) {
        if(!(f.exists())) {
            try {
                standardMessages(f);
                f.createNewFile();
            } catch(IOException e) {
                Main.log.warning("[PremiumParticles] Error while creating File!");
                e.printStackTrace();
            }
        }
    }

    public static void setMessage(File f, String name, String message) {
        YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
        if(!config.isSet(name)) {
            config.set(name, message);
            try {
                config.save(f);
            } catch(IOException e) {
                Main.log.warning("[PremiumParticles] Error while saving File!");
                e.printStackTrace();
            }
        }
    }

    public static String message(File f, String name) {
        String result = ChatColor.translateAlternateColorCodes('&', YamlConfiguration.loadConfiguration(f).getString(name));
        return result;
    }

    public static void reloadConfig(File f) {
        try {
            YamlConfiguration config = YamlConfiguration.loadConfiguration(f);
            config.load(f);
        } catch (FileNotFoundException e) {
            Main.log.warning("[PremiumParticles] Error while reloading the config!");
            e.printStackTrace();
        } catch (InvalidConfigurationException e) {
            Main.log.warning("[PremiumParticles] Error while reloading the config!");
            e.printStackTrace();
        } catch (IOException e) {
            Main.log.warning("[PremiumParticles] Error while reloading the config!");
            e.printStackTrace();
        }
    }


}
