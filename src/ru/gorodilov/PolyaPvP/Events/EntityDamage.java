package ru.gorodilov.PolyaPvP.Events;

import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

import ru.gorodilov.PolyaPvP.Utils.Toggle;

public class EntityDamage implements Listener {

   @SuppressWarnings("deprecation")
   @EventHandler
   public void onDmg(EntityDamageByEntityEvent e) {
      Entity damager = e.getDamager();
      Entity damaged = e.getEntity();
      Player shooter;
      if(damager instanceof Player && damaged instanceof Player) {
         Player arrow = (Player)damaged;
         shooter = (Player)damager;
         if(!Toggle.isPvPEnabled(arrow) || !Toggle.isPvPEnabled(shooter)) {
            e.setCancelled(true);
         }
      }

      if(damager instanceof Arrow) {
         Arrow arrow1 = (Arrow)damager;
         if(arrow1.getShooter() instanceof Player) {
            shooter = (Player)arrow1.getShooter();
            if(damaged instanceof Player) {
               Player p = (Player)damaged;
               if(!Toggle.isPvPEnabled(p) || !Toggle.isPvPEnabled(shooter)) {
                  e.setCancelled(true);
               }
            }
         }
      }
   }
}
