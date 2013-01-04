package com.gmail.zant95.LiveCraft;

import java.io.File;

import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class LiveCraft extends JavaPlugin {
	Player player = null;

	public void onEnable() {
		File config = new File(getDataFolder() + File.separator + "config.yml");
		if(!config.exists()){
			getConfig().options().copyDefaults(true);
			saveConfig();
			getLogger().info("Config restored!");
		}
		getLogger().info("Plugin enabled!");
	}

	public void onDisable() {
		getLogger().info("Plugin disabled!");
	}

	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			player = (Player)sender;
		}
		if (player == null) {
			return false;
		}
			if(command.getName().equalsIgnoreCase("livecraft")) {
				String n;
				if (args.length == 1) {
					n = args[0];
				} else {
					n = "1";
				}
				reloadConfig();
				player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "==================" + ChatColor.GOLD + "" + ChatColor.BOLD + "Live" + ChatColor.BLUE + "" + ChatColor.BOLD + "Craft" + ChatColor.GRAY + "" + ChatColor.BOLD + "===================");
				if(getConfig().get("(" + n + ")livecraft1") == null) {player.sendMessage(" ");}
					else player.sendMessage(format(getConfig().getString("(" + n + ")livecraft1")));
				if(getConfig().get("(" + n + ")livecraft2") == null) {player.sendMessage(ChatColor.GOLD + " No se encontraron resultados buscando por:");}
					else player.sendMessage(format(getConfig().getString("(" + n + ")livecraft2")));
				if(getConfig().get("(" + n + ")livecraft3") == null) {player.sendMessage(ChatColor.GOLD + " \"" + ChatColor.RESET + n + ChatColor.GOLD + "\".");}
					else player.sendMessage(format(getConfig().getString("(" + n + ")livecraft3")));
				if(getConfig().get("(" + n + ")livecraft4") == null) {player.sendMessage(" ");}
					else player.sendMessage(format(getConfig().getString("(" + n + ")livecraft4")));
				if(getConfig().get("(" + n + ")livecraft5") == null) {player.sendMessage(" ");}
					else player.sendMessage(format(getConfig().getString("(" + n + ")livecraft5")));
				if(getConfig().get("(" + n + ")livecraft6") == null) {player.sendMessage(" ");}
					else player.sendMessage(format(getConfig().getString("(" + n + ")livecraft6")));
				if(getConfig().get("(" + n + ")livecraft7") == null) {player.sendMessage(" ");}
					else player.sendMessage(format(getConfig().getString("(" + n + ")livecraft7")));
				if(getConfig().get("(" + n + ")livecraft8") == null) {player.sendMessage(" ");}
					else player.sendMessage(format(getConfig().getString("(" + n + ")livecraft8")));
				player.sendMessage(ChatColor.GRAY + "" + ChatColor.BOLD + "=============================================");
			}
		if(command.getName().equalsIgnoreCase("permisos")){
			if (args.length == 1) {
				Player user = player.getServer().getPlayer(args[0]);
				if (user != null) {
					player.chat("/manuadd " + user.getPlayer().getName() + " Usuario");
					player.chat("/say Dad la bienvenida a " + user.getPlayer().getName() + " :D");
					player.chat("/spawn " + user.getPlayer().getName());
					user.sendMessage(ChatColor.GOLD + "\u00A1Ya tienes permisos! Pero eso no quita que visites la web para");
					user.sendMessage(ChatColor.GOLD + "poder informarte sobre el servidor. Recuerda que si tienes");
					user.sendMessage(ChatColor.GOLD + "alguna duda puedes hablar con un administrador.");
					return true;
				}
				player.sendMessage(ChatColor.RED + "Error. Jugador no encontrado.");
				return false;
			}
			else {
				player.sendMessage(ChatColor.RED + "Error. Uso correcto /permisos <jugador>.");
				return false;
			}
		}
		if(command.getName().equalsIgnoreCase("usuario")){
			if (args.length == 1) {
				Player user = player.getServer().getPlayer(args[0]);
				if (user != null) {
					player.chat("/manuadd " + user.getPlayer().getName() + " Usuario");
					return true;
				}
				player.sendMessage(ChatColor.RED + "Error. Jugador no encontrado.");
				return false;
			}
			else {
				player.sendMessage(ChatColor.RED + "Error. Uso correcto /usuario <jugador>.");
				return false;
			}
		}
		if(command.getName().equalsIgnoreCase("supporter")){
			if (args.length == 1) {
				Player user = player.getServer().getPlayer(args[0]);
				if (user != null) {
					player.chat("/manuadd " + user.getPlayer().getName() + " Supporter");
					return true;
				}
				player.sendMessage(ChatColor.RED + "Error. Jugador no encontrado.");
				return false;
			}
			else {
				player.sendMessage(ChatColor.RED + "Error. Uso correcto /supporter <jugador>.");
				return false;
			}
		}
		return false;
	}

	private static String format(String text) {
		return text	.replace("&0",ChatColor.BLACK.toString())
					.replace("&1",ChatColor.DARK_BLUE.toString())
					.replace("&2",ChatColor.DARK_GREEN.toString())
					.replace("&3",ChatColor.DARK_AQUA.toString())
					.replace("&4",ChatColor.DARK_RED.toString())
					.replace("&5",ChatColor.DARK_PURPLE.toString())
					.replace("&6",ChatColor.GOLD.toString())
					.replace("&7",ChatColor.GRAY.toString())
					.replace("&8",ChatColor.DARK_GRAY.toString())
					.replace("&9",ChatColor.BLUE.toString())
					.replace("&a",ChatColor.GREEN.toString())
					.replace("&b",ChatColor.AQUA.toString())
					.replace("&c",ChatColor.RED.toString())
					.replace("&d",ChatColor.LIGHT_PURPLE.toString())
					.replace("&e",ChatColor.YELLOW.toString())
					.replace("&f",ChatColor.WHITE.toString())
					.replace("&r",ChatColor.RESET.toString())
					.replace("&l",ChatColor.BOLD.toString())
					.replace("&m",ChatColor.STRIKETHROUGH.toString())
					.replace("&n",ChatColor.UNDERLINE.toString())
					.replace("&o",ChatColor.ITALIC.toString())
					.replace("&k",ChatColor.MAGIC.toString());

	}
}