package ru.gorodilov.PolyaPvP.Commands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import ru.gorodilov.PolyaPvP.Utils.MessageType;

public abstract class CommandModel implements CommandExecutor {

   private String perms;
   private String usage;


   public CommandModel(String permission, String usage) {
      this.perms = permission;
      this.usage = usage;
   }

   public abstract boolean onCmd(CommandSender var1, Command var2, String var3, String[] var4);

   public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
      if(!sender.hasPermission(this.perms)) {
         sender.sendMessage(MessageType.NO_PERM.getMsg());
         return false;
      } else {
         if(!this.onCmd(sender, cmd, commandLabel, args) && this.usage != null) {
            sender.sendMessage(MessageType.PREFIX.getMsg() + ChatColor.DARK_RED + "Некорректное использование команды. Попробуйте " + this.usage);
         }

         return true;
      }
   }
}
