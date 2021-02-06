package warfare.gulf;

import net.minecraft.server.v1_12_R1.Scoreboard;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.Bukkit;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.ScoreboardManager;
import org.slf4j.Logger;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static javax.print.attribute.standard.MediaSizeName.B;

public final class Main extends JavaPlugin implements Listener {
    String prefix = "§e§l[걸프전] §f";
    private FileConfiguration config;

    @Override
    public void onEnable() {
        getCommand("걸프").setExecutor(new GulfCommand());
        getCommand("걸프관리").setExecutor(new GulfMCommand());
        Bukkit.getServer().getPluginManager().registerEvents(this, this);
        getLogger().info(ChatColor.GREEN + "워페어 걸프전 플러그인이 활성화 되었습니다.");
        new GulfManager().setStringConfig("Area.1", null);
        new GulfManager().setIntegerConfig("AreaPercent.1", 0);,
        new GulfManager().setLocationConfig("AreaLocation.1", new Location(
                Bukkit.getWorld(new GulfManager().getWorldData().getString("world")),
                new GulfManager().getWorldData().getDouble("Area1.x"),
                new GulfManager().getWorldData().getDouble("Area1.y"),
                new GulfManager().getWorldData().getDouble("Area1.z")
        ));
        new GulfManager().setIntegerConfig("AreaDistance.1", 15);

        new GulfManager().setStringConfig("Area.2", null);
        new GulfManager().setIntegerConfig("AreaPercent.2", 0);
        new GulfManager().setLocationConfig("AreaLocation.2", new Location(
                Bukkit.getWorld(new GulfManager().getWorldData().getString("world")),
                new GulfManager().getWorldData().getDouble("Area2.x"),
                new GulfManager().getWorldData().getDouble("Area2.y"),
                new GulfManager().getWorldData().getDouble("Area2.z")
        ));
        new GulfManager().setIntegerConfig("AreaDistance.2", 15);

        new GulfManager().setStringConfig("Area.3", null);
        new GulfManager().setIntegerConfig("AreaPercent.3", 0);
        new GulfManager().setLocationConfig("AreaLocation.3", new Location(
                Bukkit.getWorld(new GulfManager().getWorldData().getString("world")),
                new GulfManager().getWorldData().getDouble("Area3.x"),
                new GulfManager().getWorldData().getDouble("Area3.y"),
                new GulfManager().getWorldData().getDouble("Area3.z")
        ));
        new GulfManager().setIntegerConfig("AreaDistance.3", 15);
    }

    @Override
    public Logger getSLF4JLogger() {
        return null;
    }

    @Override
    public void onDisable() {
        getLogger().info(ChatColor.RED + "워페어 걸프전 플러그인이 비활성화 되었습니다.");
    }
}
