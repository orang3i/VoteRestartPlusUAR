package com.orang3i;

import dev.norska.uar.UltimateAutoRestart;
import dev.norska.uar.api.UltimateAutoRestartAutoDelayEvent;
import dev.norska.uar.api.UltimateAutoRestartDelayEvent;
import dev.norska.uar.api.UltimateAutoRestartRestartEvent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.CommandSender;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.server.ServerCommandEvent;

import static com.orang3i.Voting.vote11;
import static com.orang3i.Voting.votea;

public class RestartVote_UAR implements Listener {

    private voterestart plugin;

    public RestartVote_UAR(voterestart pl){

        plugin = pl;
    }

    private Voting test;

    public  RestartVote_UAR(Voting ttt){

        test = ttt;
    }

    @EventHandler
    public  void onUAR(UltimateAutoRestartRestartEvent event){

        Bukkit.dispatchCommand(Bukkit.getConsoleSender() , "ar delay 60");

        Bukkit.broadcastMessage(ChatColor.GREEN + "type ar no to delay the restart" );


    }
    @EventHandler
    public  void onDelay(ServerCommandEvent event) {

        int vote_valuex = plugin.getConfig().getInt("number of votes needed to restart.value");
        int vote_value = vote_valuex - 1;

        if (event.getCommand().equalsIgnoreCase("ar delay 60")) {

            if (test.vote11 >= vote_value) {

                Bukkit.broadcastMessage(ChatColor.GREEN + "number of votes to delay reached delaying restart");

                Bukkit.dispatchCommand(Bukkit.getConsoleSender() , "ar delay 3600");
            }

            if (test.votea > vote_value) {

                Bukkit.broadcastMessage(ChatColor.GREEN + "percentage of votes to delay reached delaying restart");

                Bukkit.dispatchCommand(Bukkit.getConsoleSender() , "ar delay 3600");
            }

        }

    }


    }



