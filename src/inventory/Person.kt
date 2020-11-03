package inventory

import inventory.items.PlayerItems
import inventory.spells.Spell
import util.Config
import util.SpellType

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

    /**
     * Generates Damage
     */
    fun generateDamage(): Int {
        return (atkLow..atkHigh).random()
    }

    /**
     * Take Damage
     * @param dmg as Damage Done
     * @return hp as Hit Points After Damage
     */
    fun takeDamage(dmg: Int): Int {
        hp -= dmg
        if (hp < 0)
            hp = 0
        return hp
    }

    fun heal(healPoints: Int) {
        hp += healPoints
        if (hp > maxHp)
            hp = maxHp
    }

    fun reduceMp(cost: Int) {
        mp -= cost
    }

    fun chooseAction() {
        var i = 1
        print("\nACTIONS:")
        for (action in actions) {
            print("$i. $action")
            i++
        }
    }

    fun chooseMagic() {
        var i = 1
        print("\nMAGIC:")
        for (spell in spells) {
            print("$i. ${spell.spellName},(Cost: ${spell.spellCost})")
            i++
        }
    }

    fun chooseItem() {
        var i = 1
        print("\nITEMS:")
        for (item in items) {
            print("$i. ${item.item.itemName} :,${item.item.itemName} (x ${item.quantity})")
            i++
        }
    }

    fun chooseTarget(enemies: ArrayList<Person>): Int {
        var i = 1
        print("\n")
        for (enemy in enemies) {
            if (enemy.hp != 0) {
                print("$i. ${enemy.name}")
            }
            i++
        }
        print("Choose target:")
        return (readLine()?.toInt() ?: 0) - 1
    }

    fun chooseEnemySpells(){
        var magicChoice = (0 until spells.size).random()
        var spell = spells[magicChoice]
        var magicDmg= spell.generateDamage()

        var pct = hp/maxHp*100
        if(mp < spell.spellCost || spell.spellType == SpellType.WHITE && pct > 50){
            chooseEnemySpells()
        }else{

        }
    }
}