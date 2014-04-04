package net.bukkit_plugin.kojima1021.BarLeaveMessage.event;

import me.confuser.barapi.BarAPI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

public class LeaveEvent implements Listener {

	@EventHandler
    public void OnJoin(PlayerQuitEvent e) {
	int seconds = 15;
	Player join = e.getPlayer();
	String message = ChatColor.AQUA + join.getName() + ChatColor.WHITE + "さんがサーバーからでました。";
	Player[] pls = Bukkit.getOnlinePlayers();
	for(int i = 0; i < pls.length; i++)
	{
		Player player = pls[i];
	BarAPI.setMessage(player, message, seconds);
    }
}
}