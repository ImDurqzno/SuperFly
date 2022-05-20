package me.durqznohh.fly.commands;

import me.durqznohh.fly.SuperFly;
import me.durqznohh.fly.utils.CC;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class FlyCommand implements CommandExecutor {

    private SuperFly main;

    public FlyCommand() {
        this.main = main;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.translate("&cCommand only for players!"));
            return false;
        }

        Player p = (Player) sender;

        if (args.length == 1) {
            String name = args[0];
            Player t = Bukkit.getPlayer(name);
            if (t == null) {
                p.sendMessage(CC.translate(main.getConfig().getString("PlayerNotExist")).replace("{arg}", name));
                p.playSound(p.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
                return false;
            }
            return execute(p, t);
        }


        return execute(p, p);
    }

    public boolean execute(Player a, Player b) {
        if (a.hasPermission("superfly.use")) {
            b.sendMessage(CC.translate(main.getConfig().getString("Fly-Enabled")));
            if (a != b) {
                a.sendMessage(CC.translate(main.getConfig().getString("Fly-Enabled-Others")).replace("{player}", b.getName()));
            }
            b.playSound(b.getLocation(), Sound.ENTITY_VILLAGER_YES, 1.0F, 1.0F);
            b.setFlying(true);
            b.setAllowFlight(true);
        } else {
            a.sendMessage(CC.translate(main.getConfig().getString("No-perms")));
        }

        if (b.isFlying()) {
            b.sendMessage(CC.translate(main.getConfig().getString("Fly-Disabled")));
            if (a != b) {
                a.sendMessage(CC.translate(main.getConfig().getString("Fly-Disabled-Others")).replace("{player}", b.getName()));
            }
            b.playSound(b.getLocation(), Sound.ENTITY_VILLAGER_NO, 1.0F, 1.0F);
            b.setAllowFlight(false);
            b.setFlying(false);
        } else {
            b.sendMessage(CC.translate(main.getConfig().getString("Fly-Enabled")));
            if (a != b) {
                a.sendMessage(CC.translate(main.getConfig().getString("Fly-Enabled-Others")).replace("{player}", b.getName()));
            }
            b.playSound(b.getLocation(), Sound.ENTITY_VILLAGER_YES, 1.0F, 1.0F);
            b.setFlying(true);
            b.setAllowFlight(true);
        }
        return false;
    }
}