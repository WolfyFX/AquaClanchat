package undefined.aquasmp.aquaclanchat;

import org.bukkit.plugin.java.JavaPlugin;
import undefined.aquasmp.aquaclanchat.command.*;

public final class AquaClanchat extends JavaPlugin {

    @Override
    public void onEnable() {

        this.getCommand("c").setExecutor(new C());
        this.getCommand("cedit").setExecutor(new Cedit());
        this.getCommand("cjoin").setExecutor(new Cjoin());
        this.getCommand("cleave").setExecutor(new Cleave());
        this.getCommand("ckick").setExecutor(new Ckick());

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
