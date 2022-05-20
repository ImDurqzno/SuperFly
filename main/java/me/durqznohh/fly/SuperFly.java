package me.durqznohh.fly;


import me.durqznohh.fly.commands.FlyCommand;
import me.durqznohh.fly.commands.SuperFlyCmd;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;


public final class SuperFly extends JavaPlugin implements Listener {

    public String version;
    public String latestversion;

    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();



        Bukkit.getConsoleSender().sendMessage("=============================");
        Bukkit.getConsoleSender().sendMessage("                             ");
        Bukkit.getConsoleSender().sendMessage("          SuperFly           ");
        Bukkit.getConsoleSender().sendMessage(" The plugin has been enabled ");
        Bukkit.getConsoleSender().sendMessage("                              ");
        Bukkit.getConsoleSender().sendMessage("      Made with love by      ");
        Bukkit.getConsoleSender().sendMessage("         Durqznohh <3        ");
        Bukkit.getConsoleSender().sendMessage("                             ");
        Bukkit.getConsoleSender().sendMessage("=============================");



        Bukkit.getPluginManager().registerEvents(this, this);

        getCommand("fly").setExecutor(new FlyCommand());
        getCommand("superfly").setExecutor(new SuperFlyCmd());


    }



    @Override
    public void onDisable() {
        System.out.println("[SuperFly] SuperFly has been disabled correctly. Thanks for use the plugin!");
    }
}
