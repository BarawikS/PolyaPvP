package ru.gorodilov.PolyaPvP.Commands;

import ru.gorodilov.PolyaPvP.Commands.CommandModel;
import ru.gorodilov.PolyaPvP.Utils.MessageType;
import ru.gorodilov.PolyaPvP.Utils.Toggle;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandTogglePlayer extends CommandModel {

   public CommandTogglePlayer() {
      super("polyapvp.player.use", "/pvp");
   }

   public boolean onCmd(CommandSender sender, Command cmd, String cml, String[] args) {
      Player p = (Player)sender;
      if(cml.equalsIgnoreCase("pvp")) {
         if(args.length != 0) {
            return false;
         }

         if(!Toggle.getList().contains(p.getName())) {
            Toggle.togglePVP(p);
         } else {
            p.sendMessage(MessageType.PREFIX.getMsg() + ChatColor.GRAY + "Вы не можете использовать смену режима еще в течении " + ChatColor.LIGHT_PURPLE + this.getTime() + ChatColor.GRAY + this.getEnding());
         }
      }

      return true;
   }

   private String getEnding() {
      String time = null;
      if(Toggle.getTimeRemaining() >= 60) {
         time = " минут!";
      } else {
         time = " секунд!";
      }

      return time;
   }

   private int getTime() {
      boolean time = false;
      int time1;
      if(Toggle.getTimeRemaining() >= 60) {
         time1 = Toggle.getTimeRemaining() / 60;
      } else {
         time1 = Toggle.getTimeRemaining();
      }

      return time1;
   }
}
