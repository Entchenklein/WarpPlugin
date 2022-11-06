package entchenklein.warpPlugin.warps.warpObject;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WarpPoint
{
	Location _Loc = null;
	String _WarpName = "";
	
	public void teleportPlayer(Player player)
	{
		if(_Loc != null)
		{
			player.teleport(_Loc);
			player.sendTitle(" ", "§2Teleportet To §3" + _WarpName, 20, 20, 20);
		}
	}
	public void setLocation(Location loc)
	{
		_Loc = loc;
	}
	public void setWarpName(String warpName)
	{
		_WarpName = warpName;
	}
	public String getWarpName()
	{
		return _WarpName;
	}
	
	String conversionSpace = ";";
	public String getStringConversion()
	{
		return _WarpName + conversionSpace
				+ _Loc.getWorld().getName() + conversionSpace
				+ _Loc.getX() + conversionSpace
				+ _Loc.getY() + conversionSpace
				+ _Loc.getZ() + conversionSpace
				+ _Loc.getYaw() + conversionSpace
				+ _Loc.getPitch();
	}
	
	public void setConvertedString(String convertedString)
	{
		String[] stringArray = convertedString.split(conversionSpace);
		
		_WarpName = stringArray[0];
		_Loc = new Location(Bukkit.getWorld(stringArray[1]),
				Float.valueOf(stringArray[2]),
				Float.valueOf(stringArray[3]),
				Float.valueOf(stringArray[4]),
				Float.valueOf(stringArray[5]),
				Float.valueOf(stringArray[6]));
	}
}
