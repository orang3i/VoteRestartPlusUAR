package com.orang3i.voting;

import com.orang3i.RestartVoteMain;
import com.orang3i.iridium.IridiumColorAPI;
import dev.norska.uar.UltimateAutoRestart;
import dev.norska.uar.api.UARAPI;
import dev.norska.uar.api.UARRestartEvent;


import net.md_5.bungee.api.chat.ClickEvent;

import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;

import org.bukkit.permissions.PermissionAttachment;


import java.util.HashMap;
import java.util.UUID;

public class VoteExecutor implements Listener{


    private RestartVoteMain plugin;

    public VoteExecutor(RestartVoteMain pl) {

        plugin = pl;
    }

    private VotingLogic ch1;

    public VoteExecutor(VotingLogic cl) {

        ch1 = cl;
    }



    @EventHandler
    public void onRestart(UARRestartEvent e) {


        if (plugin.MAXR > 0) {

            UARAPI.setInterval(UltimateAutoRestart.getInstance(), 60);

            String announcement = plugin.getConfig().getString("announcement message.value");
            boolean announceb = plugin.getConfig().getBoolean("announcement message.enabled");

            for (Player player : Bukkit.getOnlinePlayers()) {

                HashMap<UUID, PermissionAttachment> perms = new HashMap<UUID, PermissionAttachment>();
                PermissionAttachment attachment = player.addAttachment(plugin);
                perms.put(player.getUniqueId(), attachment);

                PermissionAttachment pperms = perms.get(player.getUniqueId());
                pperms.setPermission("voterestart.vote", true);
                if (announceb) {
                    Bukkit.broadcastMessage(IridiumColorAPI.process(IridiumColorAPI.process(announcement)));
                }else {
                    player.sendMessage(IridiumColorAPI.process("<GRADIENT:9281fb>VoteRestart</GRADIENT:eb93fc>" + " " + "<SOLID:FFFFFF>» Click on vote to delay the restart" ));
                }
                TextComponent message = new TextComponent(ChatColor.LIGHT_PURPLE + "vote");
                message.setClickEvent(new ClickEvent(ClickEvent.Action.RUN_COMMAND, "/restartvote"));
                player.spigot().sendMessage(message);

                --plugin.MAXR;

            }

        }

    }

}




