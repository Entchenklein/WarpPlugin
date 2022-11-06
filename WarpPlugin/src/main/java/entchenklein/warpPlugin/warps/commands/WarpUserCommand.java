package entchenklein.warpPlugin.warps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import entchenklein.warpPlugin.warps.WarpManager;

public class WarpUserCommand implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(player.hasPermission("warp.user"))
			{
				WarpManager.openWarpInventory(player);
			}
		}
		return true;
	}
}
