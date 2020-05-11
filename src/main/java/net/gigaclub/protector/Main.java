package net.gigaclub.protector;

import net.gigaclub.protector.listener.CommandListener;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;

public final class Main extends JavaPlugin {

    String prefix = "[GC Protection] ";
    public static Main plugin;

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(prefix + "Ich werde aktiviert!");
        registerListener();
        setPlugin(this);
        createConfig();
        System.out.println(prefix + "Fertig :)");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static void setPlugin(Main plugin) {
        Main.plugin = plugin;
    }

    public static Main getPlugin() {
        return Main.plugin;
    }

    private void registerListener() {
        System.out.println(prefix + "Registriere Listener zum blockieren der Commands!");
        getServer().getPluginManager().registerEvents(new CommandListener(), this);
    }

    private void createConfig() {
        System.out.println(prefix + "Erstelle die Config zum speichern der zu blockierenden Commands!");
        FileConfiguration config = getConfig();

        if(config.getStringList("BlockedCommands").isEmpty()) {
            ArrayList<String> commandsToBlock = new ArrayList<>();
            commandsToBlock.add("/pl");
            commandsToBlock.add("/plugins");
            commandsToBlock.add("/help");
            commandsToBlock.add("/bukkit");
            commandsToBlock.add("/bukkit:?");
            commandsToBlock.add("/bukkit:about");
            commandsToBlock.add("/bukkit:pl");
            commandsToBlock.add("/bukkit:plugins");
            commandsToBlock.add("/bukkti:ver");
            commandsToBlock.add("/bukkit:version");
            commandsToBlock.add("/me");
            commandsToBlock.add("/?");
            config.addDefault("BlockedCommands", commandsToBlock);
            config.options().copyDefaults(true);
            saveConfig();
        }
    }
}
