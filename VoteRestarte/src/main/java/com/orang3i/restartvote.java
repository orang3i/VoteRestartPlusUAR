package com.orang3i;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import static org.bukkit.Bukkit.getServer;


public   class restartvote {

    public  static int vote1 ;
    public  static double vote2 = 1;
    public  static  double votee;

    public  restartvote(voterestart plugin) {

        new CommandBase("restartvote" , true) {

            @Override

            public  boolean onCommand(CommandSender sender , String [] args) {


               double plo = getServer().getOnlinePlayers().size();
                FileConfiguration config = plugin.getConfig();
                 int restartmode = config.getInt("restart mode.value");
                 double perc = config.getInt("percentage of votes needed to restart.value");
                int vote_valuex = config.getInt("number of votes needed to restart.value");

                String restart_command = config.getString("restart command.value");

                int vote_value = vote_valuex -1;

               if(restartmode == 1) {


                   if (vote1 < vote_value) {
                       ++vote1;

                       Player player = (Player) sender;
                       Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.RED + " has voted to restart" + " " + "now there are " + " " + vote1 + " " + "votes" + " " + vote_valuex + " " + "required to restart");

                   } else {


                       Player player = (Player) sender;
                       Bukkit.broadcastMessage(ChatColor.GREEN + "number of votes to restart reached restarting.....");

                       Bukkit.dispatchCommand(player, "" + restart_command);
                   }
               }

               if (restartmode == 2){

                   votee = (vote2/plo) * 100 ;

                   if (votee < perc) {
                       ++vote2;

                       Player player = (Player) sender;
                       Bukkit.broadcastMessage(ChatColor.GREEN + player.getName() + ChatColor.RED + " has voted to restart" + " " + "now there are " + " " + votee + "%" + " " + "of players who voted " +perc + "%" + " " + "of players must vote to restart");

                   } if(votee > perc){


                       Player player = (Player) sender;
                       Bukkit.broadcastMessage(ChatColor.GREEN + "percentage of votes to restart" + "[" + perc+ "]" + " "+"restarting.....");

                       Bukkit.dispatchCommand(player, "restart");
                   }

               }

                    return true;
            }
            @Override

            public  String getUsage() {

                return "/prefix <user> <prefix>";
            }
        }.enableDelay(999999999).setPermission("voterestart.vote");
    }
}
