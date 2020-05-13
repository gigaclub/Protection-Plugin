package net.gigaclub.protector.listener;

import net.gigaclub.protector.Main;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

public class CommandListener implements Listener {

    @EventHandler
    public void onPlayerCommand(PlayerCommandPreprocessEvent event) {
        String message = event.getMessage();
        Player player = event.getPlayer();

        for(String command : Main.getPlugin().getConfig().getStringList("BlockedCommands")) {
            if (message.startsWith(command) && !player.isOp()) {
                player.sendMessage(ChatColor.RED + "Du hast keine Berechtigung diesen Command auszuführen!");
                event.setCancelled(true);
                break;
            }
        }
    }

}
