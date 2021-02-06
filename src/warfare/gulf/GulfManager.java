package warfare.gulf;

import org.bukkit.Location;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

import java.io.File;
import java.io.IOException;

public class GulfManager {
    String prefix = "§e§l[걸프전] §f";

    public String getConfig(String variable) {
        File userdata = new File("plugins");
        File fa = new File(userdata, "Warfare_Gulf//Config.yml");
        FileConfiguration configData = YamlConfiguration.loadConfiguration(fa);
        String result = (String) configData.get(variable);
        return result;
    }

    public FileConfiguration getData() {
        File userdata = new File("plugins");
        File fa = new File(userdata, "Warfare_Gulf//Config.yml");
        FileConfiguration configData = YamlConfiguration.loadConfiguration(fa);
        FileConfiguration result = configData;
        return result;
    }

    public FileConfiguration getWorldData() {
        File userdata = new File("plugins");
        File fa = new File(userdata, "Warfare_Gulf//worldConfig.yml");
        FileConfiguration configData = YamlConfiguration.loadConfiguration(fa);
        FileConfiguration result = configData;
        return result;
    }

    public void setStringConfig(String section, String variable) {
        try {
            File userdata = new File("plugins");
            File fa = new File(userdata, "Warfare_Gulf//Config.yml");
            FileConfiguration configData = YamlConfiguration.loadConfiguration(fa);
            configData.set(section, variable);
            configData.save(fa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setIntegerConfig(String section, Integer variable) {
        try {
            File userdata = new File("plugins");
            File fa = new File(userdata, "Warfare_Gulf//Config.yml");
            FileConfiguration configData = YamlConfiguration.loadConfiguration(fa);
            configData.set(section, variable);
            configData.save(fa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLocationConfig(String section, Location loc) {
        try {
            File userdata = new File("plugins");
            File fa = new File(userdata, "Warfare_Gulf//Config.yml");
            FileConfiguration configData = YamlConfiguration.loadConfiguration(fa);
            configData.set(section, loc);
            configData.save(fa);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGulfUSA(Player p) {
        try {
            getWorldData().set("USA.x", p.getLocation().getX());
            getWorldData().set("USA.y", p.getLocation().getY());
            getWorldData().set("USA.z", p.getLocation().getZ());
            getWorldData().save(new File(new File("plugins"), "Warfare_Gulf//worldConfig.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setGulfUSSR(Player p) {
        try {
            getWorldData().set("USSR.x", p.getLocation().getX());
            getWorldData().set("USSR.y", p.getLocation().getY());
            getWorldData().set("USSR.z", p.getLocation().getZ());
            getWorldData().save(new File(new File("plugins"), "Warfare_Gulf//worldConfig.yml"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void forceStopGame(Player p) {
        setStringConfig("game.sys", "false");
        p.sendMessage(prefix + "§c걸프전을 강제로 종료 하였습니다.");
    }

    public void forceStartGame(Player p) {
        setStringConfig("game.sys", "true");
        p.sendMessage(prefix + "§c걸프전을 강제로 시작 하였습니다.");
    }
}
