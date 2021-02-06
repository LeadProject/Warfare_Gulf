package warfare.gulf;

import net.minecraft.server.v1_12_R1.*;
import org.bukkit.*;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.craftbukkit.v1_12_R1.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.lang.reflect.Array;
import java.util.*;
import java.io.IOException;

public class GulfCommand implements CommandExecutor{
    String prefix = "§e§l[걸프전] §f";
    private FileConfiguration config;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            Player p = (Player) sender;
            if (args.length == 0) {
                p.sendMessage(prefix + "/걸프 참가 - 워페어 걸프전에 참가 합니다.");
                p.sendMessage(prefix + "/걸프 나가기 - 워페어 걸프전에서 나갑니다.");
            } else {
                switch (args[0]) {
                    case "참가":
                        return false;

                    case "나가기":
                        return false;
                }
            }
        } else {
            sender.sendMessage(prefix + "§c콘솔에서는 사용 할수 없습니다.");
        }
        return false;
    }
}
