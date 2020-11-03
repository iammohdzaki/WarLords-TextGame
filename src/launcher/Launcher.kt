package launcher

import util.Config
import util.Utils

//Game Launcher
fun main(args:Array<String>){
    var spells = Config.getPlayerSpells()
    for (spell in spells){
        println(spell.spellName)
    }
}