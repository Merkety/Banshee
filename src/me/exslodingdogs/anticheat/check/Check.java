package me.exslodingdogs.anticheat.check;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Check {

    protected String name, type;
    protected int maxLV;
    boolean Enabled;

    public Check(String name, String type, int maxLV, boolean enabled){

        this.name = name;
        this.type = type;
        this.maxLV = maxLV;
        this.Enabled = enabled;

    }

    public void flag(Player player){
        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', "&8( &c&lBanshee &8) &f" + player.getName() + " &7failed &f" + name + " (" + type + ")"));
    }

    public String getName(){
        return name;
    }

    public String getType(){
        return type;
    }

    public int getMaxLV(){
        return maxLV;
    }

    public void SetMaxLV(int lv){
        maxLV = lv;
    }

    public boolean isEnabled(){
        return Enabled;
    }

    public void setEnabled(boolean toggle){
        Enabled = toggle;
    }


}
