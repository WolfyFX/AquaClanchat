package undefined.aquasmp.aquaclanchat.command;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

import java.util.concurrent.RecursiveTask;

public class Ccreate extends Event implements Cancellable {

    private Player owner;
    private String ClanName;

    private boolean isCancelled;

    private static final HandlerList handlers = new HandlerList();

    public void ClanCreateEvent(Player owner, String clanName, boolean cancelled){
        this.owner = owner;
        this.ClanName = clanName;
        this.isCancelled = cancelled;
    }
    public Player getPlayer() {
        return owner;
    }
    public String getClanName() {
        return ClanName;
    }

    @Override
    public boolean isCancelled() {

        return isCancelled;
    }

    @Override
    public void setCancelled(boolean cancel) {
        this.isCancelled = cancel;
    }

    public static HandlerList getHandlersList() {
        return handlers;
    }

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }
}
