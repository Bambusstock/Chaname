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
    
    private Chaname 	plugin;
    private Boolean 	copyTo;
    private String 	senderColor;
    private String 	messageColor;
    private Boolean 	forceColor;
    
    public PlayerListener(Chaname instance) {
	this.plugin = instance;
	
	copyTo 		= this.plugin.getConfig().getBoolean("copyTo");
	senderColor 	= this.plugin.getConfig().getString("senderColor");
	messageColor 	= this.plugin.getConfig().getString("messageColor");
	forceColor 	= this.plugin.getConfig().getBoolean("forceColor");
    }
    
    public Boolean sendMessage(Player sender, Player receiver, String msg) {
	String chatMessage;
	String copyToMessage;
	
	if(receiver != null){
	    if(this.forceColor == true) {
		chatMessage = ChatColor.valueOf(this.senderColor) + "<" + sender.getName() + "> " + ChatColor.valueOf(this.messageColor) + msg.trim();
		copyToMessage = ChatColor.valueOf(this.senderColor) + "<" + sender.getName() + "> -> <" + receiver.getName() + "> " + ChatColor.valueOf(this.messageColor) + msg.trim();
	    }
	    else {
		chatMessage = ChatColor.valueOf(this.senderColor) + "<" + sender.getDisplayName() + "> " + ChatColor.valueOf(this.messageColor) + msg.trim();
		copyToMessage = ChatColor.valueOf(this.senderColor) + "<" + sender.getDisplayName() + "> -> <" + receiver.getDisplayName() + "> " + ChatColor.valueOf(this.messageColor) + msg.trim();
	    }

	    receiver.sendMessage(chatMessage);
	    if(this.copyTo == true) sender.sendMessage(copyToMessage);
	    return true;
	}
	return false;
    }
    
    @EventHandler
    public void onPlayerChat(PlayerChatEvent event) {	
	String msg = event.getMessage();
	Matcher matcher = Pattern.compile("@(.*):(.*)").matcher(msg);
	if(matcher.matches() == true && matcher.group(1).isEmpty() == false && matcher.group(2).isEmpty() == false) {
	    Player sender = event.getPlayer();
	    Player receiver = Bukkit.getPlayer(matcher.group(1).trim());
	    String plainMsg = matcher.group(2);

	    if(!sendMessage(sender, receiver, plainMsg)) {
		sender.sendMessage(ChatColor.RED + "The User '" + matcher.group(1).trim() + "' seems to be offline or doesn't exist. Check spelling. ;)");
	    }
	    event.setCancelled(true);
	}	
    }
}
