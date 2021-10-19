package undefined.aquasmp.aquaclanchat;

import org.bukkit.Color;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class Clanchat {

    // Needed Vars
    private String clanchatName = "unnamed";
    private boolean clanchatPublic = false;
    private ArrayList<Player> clanchatPlayers;
    private ArrayList<Player> clanchatAdminPlayers;
    private ArrayList<Player> clanchatInvitedPlayers;
    private Player owner;

    // The other Vars
    private Color clanchatMetaColor = Color.BLACK;
    private Color clanchatTextColor = Color.WHITE;

    public void sendMessage(String message, Player sender) { // Sends message to all players in Clanchat
        StringBuilder builderMessage = new StringBuilder(clanchatMetaColor.toString()).append("[").append(clanchatName).append(" | ").append(sender.getName()).append("] ").append(clanchatTextColor).append(message);

        for (Player player:clanchatPlayers) {
            player.sendMessage(builderMessage.toString());
        }
    }

    /*#***********************************#*/
    /* Following functions are for player  */
    /* management.                         */
    /*#***********************************#*/

    public boolean isAdmin(Player checkedPlayer) {
        return clanchatAdminPlayers.contains(checkedPlayer);
    }

    public boolean isOwner(Player checkedPlayer) {
        return checkedPlayer == owner;
    }

    public boolean isInvited(Player checkedPlayer) {
        return clanchatInvitedPlayers.contains(checkedPlayer);
    }

    public void invite(Player player, Player sender) {
        if (isAdmin(sender))
            clanchatInvitedPlayers.add(player);
    }

    public void addPlayer(Player player, Player sender) {

    }

    public void removePlayer(Player player, Player sender) {
        if (isAdmin(sender))
            clanchatPlayers.remove(player);
    }

    public void addAdmin(Player player, Player sender) {
        if (isAdmin(sender))
            clanchatAdminPlayers.add(player);
    }

    public void removeAdmin(Player player, Player sender) {
        if (isAdmin(sender))
            clanchatAdminPlayers.remove(player);
    }

    /*#***********************************#*/
    /* Following functions are for         */
    /* "The important Vars"                */
    /*#***********************************#*/

    public void changeName(String name, Player sender) {
        if (isOwner(sender))
            clanchatName = name;
    }

    /*#***********************************#*/
    /* Following functions are for         */
    /* "The other Vars"                    */
    /*#***********************************#*/

    public void changeMetaColor(Color color, Player sender) {
        if (isAdmin(sender))
            clanchatMetaColor = color;
    }

    public void changeTextColor(Color color, Player sender) {
        if (isAdmin(sender))
            clanchatTextColor = color;
    }
}
