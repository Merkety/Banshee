package me.exslodingdogs.anticheat.data;

import org.bukkit.entity.Player;

public class PlayerData {

    private Player player;
    private int KillAuraA_LV = 0;

    private int PacketsBeforeChecks = 0;

    public PlayerData(Player player) {
        this.setPlayer(player);
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getKillAuraA_LV() {
        return KillAuraA_LV;
    }

    public void setKillAuraA_LV(int killAuraA_LV) {
        KillAuraA_LV = killAuraA_LV;
    }

    public int getPacketsBeforeChecks() {
        return PacketsBeforeChecks;
    }

    public void setPacketsBeforeChecks(int packetsBeforeChecks) {
        PacketsBeforeChecks = packetsBeforeChecks;
    }
}
