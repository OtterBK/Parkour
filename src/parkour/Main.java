package parkour;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerToggleSneakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;

public class Main extends JavaPlugin implements Listener {

	public static final String MS = "§f[§b파쿠르§f] ";
	
	private ParkourManager parkourManager;
	
	public void onEnable() {
		parkourManager = new ParkourManager(this);
		getLogger().info("[보끔] 파쿠르 플러그인이 로드 되었습니다.");
	}

	public void onDisable() {
		getLogger().info("[보끔] 파쿠르 플러그인이 언로드 되었습니다.");
	}

	public boolean onCommand(CommandSender talker, Command command, String str, String args[]) {
		if (talker instanceof Player) {
			Player p = (Player) talker;
			if (str.equalsIgnoreCase("pkr")) {
				if (!p.hasPermission("parkourmanager")) {
					p.sendMessage(MS + "권한이 없습니다.");
					return false;
				}
				if (args.length <= 0) {
					p.sendMessage(MS + "§e/pkr join <닉네임> - 파쿠르 권한 부여");
					p.sendMessage(MS + "§e/pkr quit <닉네임> - 파쿠르 권한 박탈");
					return true;
				} else {
					if (args[0].equalsIgnoreCase("join")) {
						if (args.length > 1) {
							parkourManager.join(args[1]);
						} else {
							p.sendMessage(MS + "닉네임을 입력해주세요.");
						}
						return true;
					}
					if (args[0].equalsIgnoreCase("quit")) {
						if (args.length > 1) {
							parkourManager.quit(args[1]);
						} else {
							p.sendMessage(MS + "닉네임을 입력해주세요.");
						}
						return true;
					}
				}
			}
		}
		return false;
	}

}
