package com.orang3i;

import org.bukkit.plugin.java.JavaPlugin;

public final class voterestart extends JavaPlugin {

    private static voterestart instance;

    @Override
    public void onEnable() {

        instance = this;
        System.out.println("orange is proe");

        saveDefaultConfig();
        new restartvote(this);
    }

    @Override


    public void onDisable() {
        System.out.println("server bout to slep");
    }

    public  static  voterestart getInstance () {

        return  instance ;
    }
}
