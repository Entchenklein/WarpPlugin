package entchenklein.warpPlugin.warps;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import entchenklein.warpPlugin.warps.warpObject.WarpPoint;

public class WarpManager
{
	private static ArrayList<WarpPoint> warpPoints = new ArrayList<>();
	public static HashMap<Player, Inventory> currentInventory = new HashMap<>();

	public static void teleportPlayer(Player player, int slot)
	{
		if(slot < 0) return;
		if(warpPoints.size() <= slot) return;
			
		warpPoints.get(slot).teleportPlayer(player);
	}
	public static boolean addWarp(Location loc, String warpName)
	{
		for(WarpPoint warpPoint : warpPoints)
		{
			if(warpPoint.getWarpName().equals(warpName))
			{
				return false;
			}
		}
		WarpPoint warpPoint = new WarpPoint();
		warpPoint.setLocation(loc);
		warpPoint.setWarpName(warpName);
		
		warpPoints.add(warpPoint);
		return true;
	}
	
	public static boolean removeWarp(String warpName)
	{
		WarpPoint warpPointToRemove = null;
		for(WarpPoint warpPoint : warpPoints)
		{
			if(warpPoint.getWarpName().equals(warpName))
			{
				warpPointToRemove = warpPoint;
				break;
			}
		}
		
		return warpPoints.remove(warpPointToRemove);
	}
	
	public static void saveWarps()
	{
		ArrayList<String> convertedWarpList = new ArrayList<>();
		
		for(WarpPoint warpPoint : warpPoints)
		{
			convertedWarpList.add(warpPoint.getStringConversion());
		}
		
		File file = new File("plugins/WarpPlugin/Warps.json");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		cfg.set("Warps", convertedWarpList);
		try
		{
			cfg.save(file);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static void loadWarps()
	{
		File file = new File("plugins/WarpPlugin/Warps.json");
		FileConfiguration cfg = YamlConfiguration.loadConfiguration(file);
		
		List<String> warpStringList = cfg.getStringList("Warps");
		
		for(String warpString : warpStringList)
		{
			WarpPoint warpPoint = new WarpPoint();
			warpPoint.setConvertedString(warpString);
			
			warpPoints.add(warpPoint);
			
			Bukkit.broadcastMessage("" + warpString);
		}
	}
	
	public static void openWarpInventory(Player player)
	{
		Inventory inv = Bukkit.createInventory(null, 45, "§6Warp Inventory");
		
		int counter = 0;
		for(WarpPoint warpPoint : warpPoints)
		{
			ItemStack item = new ItemStack(Material.DIAMOND, 1);
			ItemMeta meta = item.getItemMeta();
			meta.setDisplayName("§2" + warpPoint.getWarpName());
			item.setItemMeta(meta);
			
			inv.setItem(counter, item);
			counter++;
		}

		currentInventory.put(player, inv);
		player.openInventory(inv);
	}
}
