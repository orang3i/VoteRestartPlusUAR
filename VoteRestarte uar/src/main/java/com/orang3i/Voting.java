package com.orang3i;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;

import static org.bukkit.Bukkit.getServer;

public class Voting implements Listener {

    public static int vote11;
    public static double vote22 = 1;
    public static double votea;

    private voterestart plugin;


    public Voting(voterestart pl) {

        plugin = pl;
    }


    @EventHandler

    public void onPlayerChat(AsyncPlayerChatEvent event) {
        double plo = getServer().getOnlinePlayers().size();
        int restartmode = plugin.getConfig().getInt("restart mode.value");
        double perc = plugin.getConfig().getDouble("percentage of votes needed to restart.value");
        int vote_valuex = plugin.getConfig().getInt("number of votes needed to restart.value");
        int vote_value = vote_valuex - 1;

        if (event.getMessage().equalsIgnoreCase("ar no")) {

            if (restartmode == 1) {


                if (vote11 < vote_value) {
                    ++vote11;
                }

            }

            if (restartmode == 2) {

                votea = (vote22 / plo) * 100;

                if (votea < perc) {
                    ++vote22;

                }

            }

            }

        }
    }


