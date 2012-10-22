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
				player.sendMessage("§7§l==================§6§lLive§9§lCraft§7§l===================");
				if(getConfig().get("(" + n + ")livecraft1") == null) {player.sendMessage(" ");}
					else player.sendMessage(getConfig().getString("(" + n + ")livecraft1"));
				if(getConfig().get("(" + n + ")livecraft2") == null) {player.sendMessage(ChatColor.GOLD + " No se encontraron resultados buscando por el término:");}
					else player.sendMessage(getConfig().getString("(" + n + ")livecraft2"));
				if(getConfig().get("(" + n + ")livecraft3") == null) {player.sendMessage(ChatColor.GOLD + " \"" + ChatColor.RESET + n + ChatColor.GOLD + "\".");}
					else player.sendMessage(getConfig().getString("(" + n + ")livecraft3"));
				if(getConfig().get("(" + n + ")livecraft4") == null) {player.sendMessage(" ");}
					else player.sendMessage(getConfig().getString("(" + n + ")livecraft4"));
				if(getConfig().get("(" + n + ")livecraft5") == null) {player.sendMessage(" ");}
					else player.sendMessage(getConfig().getString("(" + n + ")livecraft5"));
				if(getConfig().get("(" + n + ")livecraft6") == null) {player.sendMessage(" ");}
					else player.sendMessage(getConfig().getString("(" + n + ")livecraft6"));
				if(getConfig().get("(" + n + ")livecraft7") == null) {player.sendMessage(" ");}
					else player.sendMessage(getConfig().getString("(" + n + ")livecraft7"));
				if(getConfig().get("(" + n + ")livecraft8") == null) {player.sendMessage(" ");}
					else player.sendMessage(getConfig().getString("(" + n + ")livecraft8"));
				player.sendMessage("§7§l=============================================");
			}
		if(command.getName().equalsIgnoreCase("permisos")){
			if (args.length == 1) {
				Player user = player.getServer().getPlayer(args[0]);
				if (user != null) {
					player.chat("/manuadd " + user.getPlayer().getName() + " Usuario");
					player.chat("/say Dad la bienvenida a " + user.getPlayer().getName() + " :D");
					player.chat("/spawn " + user.getPlayer().getName());
					user.sendMessage(ChatColor.GOLD + "¡Ya tienes permisos! Pero eso no quita que visites la web para");
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
}