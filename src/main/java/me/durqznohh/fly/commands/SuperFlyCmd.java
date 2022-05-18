package me.durqznohh.fly.commands;


import me.durqznohh.fly.Main;
import me.durqznohh.fly.utils.CC;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SuperFlyCmd implements CommandExecutor {

    private Main main;

    public SuperFlyCmd() {
        this.main = main;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(CC.translate("&cCommand only for players."));
        }

        if (sender instanceof Player) {
            Player player = (Player) sender;

            player.sendMessage(CC.translate("&e======================================"));
            player.sendMessage(CC.translate("&a              SuperFly                "));
            player.sendMessage(CC.translate("&7                                      "));
            player.sendMessage(CC.translate("&e   /fly - Activate your flight mode   "));
            player.sendMessage(CC.translate("&e /superfly admin &7if you are an admin"));
            player.sendMessage(CC.translate("&7                                      "));
            player.sendMessage(CC.translate("&e======================================"));

            if(player.hasPermission("superfly.admin")) {
                if(args.length == 1) {
                    if (args[0].equalsIgnoreCase("admin")) {
                        ((Player)  sender).sendMessage(CC.translate("&cAdmin commands: /fly [user] & /superfly reload"));
                    }
                }
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("reload")) {
                        ((Player) sender).sendMessage(CC.translate(main.getConfig().getString("Reload")));
                        main.reloadConfig();
                    }

                }
            }
            

        }

        return false;
    }
}
