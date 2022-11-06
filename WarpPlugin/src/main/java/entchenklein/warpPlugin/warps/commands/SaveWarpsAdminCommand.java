package entchenklein.warpPlugin.warps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import entchenklein.warpPlugin.warps.WarpManager;

public class SaveWarpsAdminCommand implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(player.hasPermission("warp.admin"))
			{
				WarpManager.saveWarps();
				player.sendMessage("§2Warps Saved!");
			}
		}
		return true;
	}
}
