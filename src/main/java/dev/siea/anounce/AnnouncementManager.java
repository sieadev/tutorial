package dev.siea.anounce;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

public class AnnouncementManager {
    private final Plugin plugin;
    public boolean active;
    public AnnouncementManager(Plugin p){
        active = false;
        plugin = p;
    }

    public boolean TryAnnounceTitle(CommandSender p, String s, int time){
        if (active){
            return false;
        }
        else{
            announceTitle(p, s, time);
            return true;
        }
    }

    public void forceAnnounceTitle(CommandSender p, String s, int time){
        // announceTitle(p, s, time);
    }

    private void announceTitle(CommandSender p, String s, int time){
        for(Player player : p.getServer().getOnlinePlayers()){
            player.sendTitle(s, null, 0, time, 0);
        }
        p.sendMessage("Send your command to " + p.getServer().getOnlinePlayers().size() + " players");
        waitOutAnnouncement(time);
    }

    private void waitOutAnnouncement(int time){
        new BukkitRunnable() {
            public void run() {
                active = false;
            }
        }.runTaskTimer(plugin, time * 20, 1L); // Run the task every second (20 ticks)
    }
}
