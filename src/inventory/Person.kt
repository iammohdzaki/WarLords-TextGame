package inventory

import inventory.items.PlayerItems
import inventory.spells.Spell
import util.Config

class Person(
    var name: String,
    var hp: Int,
    var mp: Int,
    var atk: Int,
    var df: Int,
    var spells: ArrayList<Spell>,
    var items: ArrayList<PlayerItems>
) {

    var maxHp: Int = 0
    var maxMp: Int = 0
    var atkLow: Int = 0
    var atkHigh: Int = 0
    var actions: ArrayList<String> = Config.getPlayerActions()

    init {
        maxHp = hp
        maxMp = mp
        atkLow = atk - 10
        atkHigh = atk + 10
    }
}