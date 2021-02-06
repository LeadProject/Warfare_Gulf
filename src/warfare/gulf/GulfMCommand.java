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

public class GulfMCommand implements CommandExecutor{
    String prefix = "§e§l[걸프전] §f";
    private FileConfiguration config;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] args) {
        if (sender instanceof Player) {
            if (sender.isOp()) {
                Player p = (Player) sender;
                if (args.length == 0) {
                    p.sendMessage("");
                    p.sendMessage(prefix + "/걸프관리 공산스폰설정 - 공산권 팀의 스폰을 설정 합니다.");
                    p.sendMessage(prefix + "/걸프관리 민주스폰설정 - 민주권 팀의 스폰을 설정 합니다.");
                    p.sendMessage(prefix + "/걸프관리 강제종료 - 워페어 걸프전을 강제로 종료 합니다.");
                    p.sendMessage(prefix + "/걸프관리 강제시작 - 웨페어 걸프전을 강제로 시작 합니다.");
                    p.sendMessage("");
                    p.sendMessage(prefix + "/걸프관리 점령지1설정 - 첫번째 걸프전 점령지를 설정 합니다.");
                    p.sendMessage(prefix + "/걸프관리 점령지2설정 - 두번째 걸프전 점령지를 설정 합니다.");
                    p.sendMessage(prefix + "/걸프관리 점령지3설정 - 세번째 걸프전 점령지를 설정 합니다.");
                    p.sendMessage("");
                } else {
                    switch (args[0]) {
                        case "공산스폰설정":
                            new GulfManager().setGulfUSSR(p);
                            return false;

                        case "민주스폰설정":
                            new GulfManager().setGulfUSA(p);
                            return false;

                        case "강제종료":
                            new GulfManager().forceStopGame(p);
                            return false;

                        case "강제시작":
                            new GulfManager().forceStartGame(p);
                            return false;
                    }
                }
            } else {
                sender.sendMessage(prefix + "§c당신은 권한이 없습니다.");
            }
        } else {
            sender.sendMessage(prefix + "§c콘솔에서는 사용 할수 없습니다.");
        }
        return false;
    }
}
