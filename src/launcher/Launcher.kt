package launcher

import util.Config
import util.Utils

//Game Launcher
fun main(args:Array<String>){
    var players = Config.getPlayers()
    for (player in players){
        println("${player.name} maxHp:${player.maxHp}")
    }
}