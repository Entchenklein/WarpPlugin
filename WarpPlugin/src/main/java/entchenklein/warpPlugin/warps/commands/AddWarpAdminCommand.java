package entchenklein.warpPlugin.warps.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import entchenklein.warpPlugin.warps.WarpManager;

public class AddWarpAdminCommand implements CommandExecutor
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
					if(WarpManager.addWarp(player.getLocation(), args[0])) player.sendMessage("§2Warp added Sucessfully!");
					else player.sendMessage("§4Warp with Name §2" + args[0] + " §4already Exist!");
				}
				else
				{
					player.sendMessage("§4/addWarp [Name]");
				}
			}
		}
		return true;
	}
}
