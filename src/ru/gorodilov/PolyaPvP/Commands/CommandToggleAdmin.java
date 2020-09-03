package ru.gorodilov.PolyaPvP.Commands;

import ru.gorodilov.PolyaPvP.Commands.CommandModel;
import ru.gorodilov.PolyaPvP.Utils.MessageType;
import ru.gorodilov.PolyaPvP.Utils.Toggle;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandToggleAdmin extends CommandModel {

   public CommandToggleAdmin() {
      super("polyapvp.admin.use", "/pvpadm <player>");
   }

   @SuppressWarnings("deprecation")
public boolean onCmd(CommandSender sender, Command cmd, String cml, String[] args) {
      if(cml.equalsIgnoreCase("pvpadm")) {
         if(args.length != 1) {
            return false;
         }

         Player t = Bukkit.getPlayer(args[0]);
         Toggle.togglePVP(t);
         String answer = "";
         if(Toggle.isPvPEnabled(t) == true) {
        	 answer = "\u00a7cвыключен";
         } else {
        	 answer = "\u00a7aвключен";
         }
         sender.sendMessage(MessageType.PREFIX.getMsg() + ChatColor.GRAY + "Установлен режим PVP защиты " + answer + ChatColor.GRAY + " для " + ChatColor.LIGHT_PURPLE + t.getName());
      }

      return true;
   }
}
