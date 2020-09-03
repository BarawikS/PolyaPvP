package ru.gorodilov.PolyaPvP.Events;

import ru.gorodilov.PolyaPvP.Utils.FileManager;
import ru.gorodilov.PolyaPvP.Utils.PlayerBoard;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

   @EventHandler
   public void onJoin(PlayerJoinEvent e) {
      String name = e.getPlayer().getName();
      if(!FileManager.getPlayers().contains(name)) {
         FileManager.getPlayers().set(name, Boolean.valueOf(true));
         FileManager.savePlayers();
      }

      PlayerBoard.addPlayerToTeam(e.getPlayer());
   }
}
