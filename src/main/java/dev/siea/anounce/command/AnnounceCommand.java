package dev.siea.anounce.command;

import dev.siea.anounce.AnnouncementManager;
import dev.siea.anounce.Anounce;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AnnounceCommand implements CommandExecutor {
    private final AnnouncementManager am;

    public AnnounceCommand(Anounce a){
        am = a.getAm();
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        int lastArgPosition = args.length - 1;
        String lastArg = args[lastArgPosition];
        int time;

        try{
            time = Integer.getInteger(lastArg);
        } catch (Exception e){
            return false;
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (String arg : args){
            i++;
            if (i == args.length) break;
            sb.append(arg + " ");
        }
        String announcement = sb.toString();

        if (am.TryAnnounceTitle(commandSender, announcement, time)){
            commandSender.sendMessage("Announcement created!");
        }
        else{
            commandSender.sendMessage("There is currently an announcement being displayed");
        }
        return true;
    }

}
