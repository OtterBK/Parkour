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

	public static final String MS = "��f[��b������f] ";
	
	private ParkourManager parkourManager;
	
	public void onEnable() {
		parkourManager = new ParkourManager(this);
		getLogger().info("[����] ���� �÷������� �ε� �Ǿ����ϴ�.");
	}

	public void onDisable() {
		getLogger().info("[����] ���� �÷������� ��ε� �Ǿ����ϴ�.");
	}

	public boolean onCommand(CommandSender talker, Command command, String str, String args[]) {
		if (talker instanceof Player) {
			Player p = (Player) talker;
			if (str.equalsIgnoreCase("pkr")) {
				if (!p.hasPermission("parkourmanager")) {
					p.sendMessage(MS + "������ �����ϴ�.");
					return false;
				}
				if (args.length <= 0) {
					p.sendMessage(MS + "��e/pkr join <�г���> - ���� ���� �ο�");
					p.sendMessage(MS + "��e/pkr quit <�г���> - ���� ���� ��Ż");
					return true;
				} else {
					if (args[0].equalsIgnoreCase("join")) {
						if (args.length > 1) {
							parkourManager.join(args[1]);
						} else {
							p.sendMessage(MS + "�г����� �Է����ּ���.");
						}
						return true;
					}
					if (args[0].equalsIgnoreCase("quit")) {
						if (args.length > 1) {
							parkourManager.quit(args[1]);
						} else {
							p.sendMessage(MS + "�г����� �Է����ּ���.");
						}
						return true;
					}
				}
			}
		}
		return false;
	}

}
