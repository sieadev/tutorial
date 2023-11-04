package dev.siea.anounce;

import dev.siea.anounce.command.AnnounceCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class Anounce extends JavaPlugin {
    AnnouncementManager am;
    @Override
    public void onEnable() {
        am = new AnnouncementManager(this);

    }

    @Override
    public void onDisable() {
        try{
            getCommand("announce").setExecutor(new AnnounceCommand(this));
        } catch (Exception e){
            System.out.println("There was an error loading commands: " + e);
        }
    }

    public AnnouncementManager getAm() {
        return am;
    }
}
