package me.Bambusstock.Chaname;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChatEvent;

public class PlayerListener implements Listener{
    
    Logger log = Logger.getLogger("Minecraft");
    @SuppressWarnings("unused")
    private Chaname plugin;
    
    public PlayerListener(Chaname instance) {
	this.plugin = instance;
    }
    
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {	
	String msg = event.getMessage();
	Matcher matcher = Pattern.compile("@(.*):(.*)").matcher(msg);
	if(matcher.matches() == true && matcher.group(1).isEmpty() == false && matcher.group(2).isEmpty() == false) {
	    Player sender = event.getPlayer();
	    Player receiver = Bukkit.getPlayer(matcher.group(1).trim());
	    if(receiver != null) {
		receiver.sendMessage(ChatColor.DARK_AQUA + "<" + sender.getName().trim() + ">" + ChatColor.GOLD + matcher.group(2));
	    }
	    else {
		sender.sendMessage(ChatColor.RED + "The User '" + matcher.group(1).trim() + "' seems to be offline or doesn't exist. Check spelling. ;)");
	    }
	    event.setCancelled(true);
	}	
    }
}
