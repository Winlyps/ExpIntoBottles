package winlyps.expIntoBottles

import org.bukkit.ChatColor
import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

class ExpIntoBottlesCommand(private val plugin: ExpIntoBottles) : CommandExecutor {

    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (sender !is Player) {
            sender.sendMessage(ChatColor.RED.toString() + "Only players can use this command!")
            return true
        }

        val player = sender
        val levelsToConvert = player.level

        if (levelsToConvert <= 0) {
            player.sendMessage(ChatColor.RED.toString() + "You don't have any levels to convert!")
            return true
        }

        // Deduct the levels
        player.level = 0

        // Give the player the bottles
        player.inventory.addItem(ItemStack(Material.EXPERIENCE_BOTTLE, levelsToConvert))

        player.sendMessage(ChatColor.GREEN.toString() + "You have converted $levelsToConvert levels into $levelsToConvert experience bottles!")

        return true
    }
}