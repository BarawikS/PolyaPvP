package ru.gorodilov.PolyaPvP;

import ru.gorodilov.PolyaPvP.Commands.CommandToggleAdmin;
import ru.gorodilov.PolyaPvP.Commands.CommandTogglePlayer;
import ru.gorodilov.PolyaPvP.Events.EntityDamage;
import ru.gorodilov.PolyaPvP.Events.PlayerJoin;
import ru.gorodilov.PolyaPvP.Utils.FileManager;
import ru.gorodilov.PolyaPvP.Utils.PlayerBoard;

import org.bukkit.plugin.java.JavaPlugin;

public class PolyaPvP extends JavaPlugin {

   private static PolyaPvP plugin;


   public void onEnable() {
      plugin = this;
      new PlayerBoard();
      this.getServer().getPluginManager().registerEvents(new PlayerJoin(), this);
      this.getServer().getPluginManager().registerEvents(new EntityDamage(), this);
      this.getCommand("pvp").setExecutor(new CommandTogglePlayer());
      this.getCommand("pvpadm").setExecutor(new CommandToggleAdmin());
      this.saveDefaultConfig();
      FileManager.saveDefaultPlayers();

   }

   public void onDisable() {
      plugin = null;
   }

   public static PolyaPvP getInstance() {
      return plugin;
   }
}
