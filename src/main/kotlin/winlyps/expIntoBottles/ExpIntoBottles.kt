package winlyps.expIntoBottles

import org.bukkit.plugin.java.JavaPlugin

class ExpIntoBottles : JavaPlugin() {

    override fun onEnable() {
        // Register the command
        getCommand("expintobottles")?.setExecutor(ExpIntoBottlesCommand(this))
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}