package ru.gorodilov.PolyaPvP.Utils;

import org.bukkit.ChatColor;

public enum MessageType {

   PREFIX("PREFIX", 0, "&8[&dPolyaPvP&8] "),
   NO_PERM("NO_PERM", 1, PREFIX.getMsg() + "&4У вас недостаточно прав :c"),
   CAN_TOGGLE("CAN_TOGGLE", 2, PREFIX.getMsg() + "&7Вы можете переключить режим PVP защиты"),
   PLAYER_ONLY("PLAYER_ONLY", 3, PREFIX.getMsg() + "&7Для выполнения данной команды необходимо быть игроком."),
   PVP_ENABLED("PVP_ENABLED", 4, PREFIX.getMsg() + "&7Ваш режим PVP защиты &cвыключен"),
   PVP_DISABLED("PVP_DISABLED", 5, PREFIX.getMsg() + "&7Ваш режим PVP защиты &aвключен");
   String msg;
   // $FF: synthetic field
   @SuppressWarnings("unused")
private static final MessageType[] ENUM$VALUES = new MessageType[]{PREFIX, NO_PERM, CAN_TOGGLE, PLAYER_ONLY, PVP_ENABLED, PVP_DISABLED};


   private MessageType(String var1, int var2, String s) {
      this.msg = s;
   }

   public String getMsg() {
      return ChatColor.translateAlternateColorCodes('&', this.msg);
   }
}
