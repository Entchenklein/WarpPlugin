package entchenklein.warpPlugin.main;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

import entchenklein.warpPlugin.warps.WarpManager;
import entchenklein.warpPlugin.warps.commands.AddWarpAdminCommand;
import entchenklein.warpPlugin.warps.commands.RemoveWarpAdminCommand;
import entchenklein.warpPlugin.warps.commands.SaveWarpsAdminCommand;
import entchenklein.warpPlugin.warps.commands.WarpUserCommand;
import entchenklein.warpPlugin.warps.listener.ClickInWarpInventory;

public class Main extends JavaPlugin
{
	@Override
	public void onEnable()
	{
		//Load Commands
		getCommand("saveWarps").setExecutor(new SaveWarpsAdminCommand());
		getCommand("addWarp").setExecutor(new AddWarpAdminCommand());
		getCommand("removeWarp").setExecutor(new RemoveWarpAdminCommand());
		getCommand("warp").setExecutor(new WarpUserCommand());
		
		//Load Events
		Bukkit.getServer().getPluginManager().registerEvents(new ClickInWarpInventory(), this);
		
		//LoadWarps
		WarpManager.loadWarps();
		
		System.out.println("[WarpPlugin] started!");
	}

	@Override
	public void onDisable()
	{
		System.out.println("[WarpPlugin] stopped!");
	}
}
