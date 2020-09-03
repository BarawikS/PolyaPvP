package ru.gorodilov.PolyaPvP.Utils;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import ru.gorodilov.PolyaPvP.PolyaPvP;
import ru.gorodilov.PolyaPvP.Utils.MessageType;

public class FileManager {

   private static FileConfiguration config = null;
   private static File players = null;


   public static FileConfiguration getPlayers() {
      if(config == null) {
         reloadPlayers();
      }

      return config;
   }

   public static void reloadPlayers() {
      if(players == null) {
         players = new File(PolyaPvP.getInstance().getDataFolder(), "players.yml");
      }

      config = YamlConfiguration.loadConfiguration(players);
      InputStream defConfigStream = PolyaPvP.getInstance().getResource("players.yml");
      if(defConfigStream != null) {
         YamlConfiguration defConfig = YamlConfiguration.loadConfiguration(defConfigStream);
         config.setDefaults(defConfig);
      }

   }

   public static void savePlayers() {
      if(config != null && players != null) {
         try {
            getPlayers().save(players);
         } catch (IOException var1) {
            System.out.println(MessageType.PREFIX.getMsg() + "Could not save config to " + players);
         }

      }
   }

   public static void saveDefaultPlayers() {
      if(players == null) {
         players = new File(PolyaPvP.getInstance().getDataFolder(), "players.yml");
      }

      if(!players.exists()) {
    	  PolyaPvP.getInstance().saveResource("players.yml", false);
      }

   }
}
