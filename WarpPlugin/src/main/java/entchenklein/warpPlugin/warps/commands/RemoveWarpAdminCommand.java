package entchenklein.warpPlugin.warps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import entchenklein.warpPlugin.warps.WarpManager;

public class RemoveWarpAdminCommand implements CommandExecutor
{
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		if(sender instanceof Player)
		{
			Player player = (Player) sender;
			if(player.hasPermission("warp.admin"))
			{
				if(args.length == 1)
				{
					if(WarpManager.removeWarp(args[0])) player.sendMessage("§2Warp removed Sucessfully!");
					else player.sendMessage("§4Warp with Name §2" + args[0] + " §4doesnt Exist!");
				}
				else
				{
					player.sendMessage("§4/removeWarp [Name]");
				}
			}
		}
		return true;
	}
}
