package ru.gorodilov.PolyaPvP.Utils;

import com.google.common.collect.Lists;
import java.util.List;

import ru.gorodilov.PolyaPvP.PolyaPvP;
import ru.gorodilov.PolyaPvP.Utils.MessageType;
import ru.gorodilov.PolyaPvP.Utils.Toggle;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class PlayerBoard {

   private static Scoreboard scoreboard;
   private static List teams;


   public PlayerBoard() {
      scoreboard = PolyaPvP.getInstance().getServer().getScoreboardManager().getMainScoreboard();
      initializeTeam("enabled", ChatColor.translateAlternateColorCodes('&', PolyaPvP.getInstance().getConfig().getString("Enabled Color")));
      initializeTeam("disabled", ChatColor.translateAlternateColorCodes('&', PolyaPvP.getInstance().getConfig().getString("Disabled Color")));
      teams = Lists.newArrayList(scoreboard.getTeams());
   }

   public static void initializeTeam(String teamName, String prefix) {
      if(scoreboard.getTeam(teamName) == null) {
         scoreboard.registerNewTeam(teamName).setPrefix(prefix);
      }

   }

   public static void addPlayerToTeam(Player player) {
      if(Toggle.isPvPEnabled(player)) {
         if(PolyaPvP.getInstance().getConfig().getBoolean("Do Color Change")) {
            ((Team)teams.get(0)).addPlayer(player);
         }

         player.sendMessage(MessageType.PVP_ENABLED.getMsg());
      } else {
         if(PolyaPvP.getInstance().getConfig().getBoolean("Do Color Change")) {
            ((Team)teams.get(1)).addPlayer(player);
         }

         player.sendMessage(MessageType.PVP_DISABLED.getMsg());
      }

   }
}
