package entchenklein.warpPlugin.warps.listener;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.inventory.Inventory;

import entchenklein.warpPlugin.warps.WarpManager;

public class ClickInWarpInventory implements Listener
{
	@EventHandler (priority = EventPriority.LOWEST)
	public void onInvClick(InventoryClickEvent event)
	{
		Player player = (Player) event.getWhoClicked();
		
		Inventory inv = WarpManager.currentInventory.getOrDefault(player, null);
		
		if(inv != null)
		{
			int slot = event.getSlot();
			WarpManager.teleportPlayer(player, slot);
			event.setCancelled(true);
		}
	}
	
	@EventHandler (priority = EventPriority.LOWEST)
	public void onInvClick(InventoryCloseEvent event)
	{
		WarpManager.currentInventory.put((Player) event.getPlayer(), null);
	}
}
