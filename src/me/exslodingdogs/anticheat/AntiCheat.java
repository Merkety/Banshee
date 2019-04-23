package me.exslodingdogs.anticheat;

import me.exslodingdogs.anticheat.check.Check;
import me.exslodingdogs.anticheat.data.DataManager;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class AntiCheat extends JavaPlugin {

    public static AntiCheat plugin;
    private static AntiCheat instance;
    private DataManager dataManager;
    @Override
    public void onEnable() {
        plugin = AntiCheat.getPlugin(AntiCheat.class);
        instance = this;
        dataManager = new DataManager();
        removeAllPlayers();
        addAllPlayers();
        setUpConfig();
        registerEvents();
    }

    @Override
    public void onDisable() {
        removeAllPlayers();
        super.onDisable();
    }

    public static AntiCheat getInstance() {
        return instance;
    }

    public DataManager getDataManager() {
        return dataManager;
    }

    private void registerEvents() {

    }

    public void addAllPlayers() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            getInstance().getDataManager().addPlayerData(player);
        }
    }

    private void removeAllPlayers() {
        for(Player player : Bukkit.getOnlinePlayers()) {
            getInstance().getDataManager().removePlayerData(player);
        }
    }

    private void setUpConfig() {
        for(Check checks : getInstance().getDataManager().getChecks()) {
            if(getConfig().get("checks." + checks.getName() + "." + checks.getType() + ".IsEnabled") != null){
                checks.setEnabled(getConfig().getBoolean("checks." + checks.getName() + "." + checks.getType() + ".IsEnabled"));
            }else {
                getConfig().set("checks." + checks.getName() + "." + checks.getType() + ".IsEnabled", checks.isEnabled());
                getConfig().set("checks." + checks.getName() + "." + checks.getType() + ".Debug", false);
                saveConfig();
            }
        }
    }
}
