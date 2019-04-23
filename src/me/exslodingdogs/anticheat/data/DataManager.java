package me.exslodingdogs.anticheat.data;

import me.exslodingdogs.anticheat.check.Check;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DataManager {

    public List<Check> checks;
    public List<PlayerData> players;
    public DataManager instance;
    public DataManager() {
        this.instance = this;
        players = new ArrayList<>();
        checks = new ArrayList<Check>();
        registerChecks();
    }

    public void removeCheck(Check check) {
        if(checks.contains(check)) checks.remove(check);

    }

    public boolean isCheck(Check check) {
        return checks.contains(check);
    }

    public Check getCheckByName(String checkName) {
        for(Check checkLoop : Collections.synchronizedList(checks)) {
            if(checkLoop.getName().equalsIgnoreCase(checkName)) return checkLoop;
        }
        return null;
    }

    public void addCheck(Check check) {
        if(!checks.contains(check)) checks.add(check);
    }

    public List<Check> getChecks() {
        return checks;
    }

    public void registerChecks() {
        //ADD Checks here

    }

    public void addPlayerData(Player player) {
        players.add(new PlayerData(player));
    }

    public PlayerData getData(Player player) {
        for(PlayerData dataLoop : Collections.synchronizedList(players)) {
            if(dataLoop.getPlayer() == player) {
                return dataLoop;
            }
        }
        return null;
    }

    public void removePlayerData(Player player) {
        for(PlayerData dataLoop : Collections.synchronizedList(players)) {
            if(dataLoop.getPlayer() == player) {
                players.remove(dataLoop);
                break;
            }
        }
    }


}
