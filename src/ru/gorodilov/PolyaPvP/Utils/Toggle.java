package ru.gorodilov.PolyaPvP.Utils;

import java.util.ArrayList;

import ru.gorodilov.PolyaPvP.PolyaPvP;
import ru.gorodilov.PolyaPvP.Utils.FileManager;
import ru.gorodilov.PolyaPvP.Utils.MessageType;
import ru.gorodilov.PolyaPvP.Utils.PlayerBoard;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class Toggle {

   private static ArrayList toggled = new ArrayList();
   private static int time;


   public static void togglePVP(final Player player) {
      FileConfiguration c = FileManager.getPlayers();
      if(isPvPEnabled(player)) {
         c.set(player.getName(), Boolean.valueOf(false));
         toggled.add(player.getName());
         FileManager.savePlayers();
      } else {
         c.set(player.getName(), Boolean.valueOf(true));
         toggled.add(player.getName());
         FileManager.savePlayers();
      }

      PlayerBoard.addPlayerToTeam(player);
      Bukkit.getScheduler().scheduleSyncDelayedTask(PolyaPvP.getInstance(), new Runnable() {
         public void run() {
            Toggle.toggled.remove(player.getName());
            player.sendMessage(MessageType.CAN_TOGGLE.getMsg());
         }
      }, 20L * PolyaPvP.getInstance().getConfig().getLong("Toggle Delay"));
   }

   public static boolean isPvPEnabled(Player player) {
      return FileManager.getPlayers().getBoolean(player.getName());
   }

   public static ArrayList getList() {
      return toggled;
   }

   public static int getTimeRemaining() {
      time = PolyaPvP.getInstance().getConfig().getInt("Toggle Delay");
      return time;
   }
}
