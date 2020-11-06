package inventory

import inventory.items.PlayerItems
import inventory.spells.Spell
import util.Config
import util.MAX_BAR_VALUE
import util.MAX_MP_BAR_VALUE

/**
 * Person Class represents a entity either player or enemy
 * name represents Name of the Entity
 * hp represents Hit points of the Entity
 * mp represents Money points of the Entity
 * atk represents Attack value of the Entity
 * df represents Name of the Entity
 * spells represents Spells of the Entity
 * items represents Items of the Entity
 */
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

    /**
     * maxHp represents Maximum Hit points a Entity has
     * maxMp represents Maximum Money points a Entity has
     * atkHigh represents Attack High Value
     * atkLow represents Attack Low Value
     */
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

    /**
     * Heals a entity
     */
    fun heal(healPoints: Int) {
        hp += healPoints
        if (hp > maxHp)
            hp = maxHp
    }

    /**
     * Reduce Money Points After Buying
     */
    fun reduceMp(cost: Int) {
        mp -= cost
    }

    /**
     * Represents Entity Action
     */
    fun chooseAction() {
        var i = 1
        println("\nACTIONS:")
        for (action in actions) {
            println("$i. $action")
            i++
        }
    }

    /**
     * Magic Action - Spells
     */
    fun chooseMagic() {
        var i = 1
        println("\nMAGIC:")
        for (spell in spells) {
            println("$i. ${spell.spellName},(Cost: ${spell.spellCost})")
            i++
        }
    }

    /**
     * Items -  Potions etc.
     */
    fun chooseItem() {
        var i = 1
        println("\nITEMS:")
        for (item in items) {
            println("$i. ${item.item.itemName} : ${item.item.itemDescription} (x ${item.quantity})")
            i++
        }
    }

    /**
     * Attack on Enemy Entity
     */
    fun chooseTarget(enemies: ArrayList<Person>): Int {
        var i = 1
        print("\n")
        for (enemy in enemies) {
            if (enemy.hp != 0) {
                println("$i. ${enemy.name}")
            }
            i++
        }
        println("Choose target:")
        return (readLine()?.toInt() ?: 0) - 1
    }

    /**
     * Shows Enemies stats
     * Formula For calculation bars -  15 means full bar
     * (hp / maxHp) * 15 => bars length
     * bar length - 15 => Non filled
     */
    fun getEnemyStats() {
        var barLength: Int = ((hp.toDouble() / maxHp.toDouble()) * MAX_BAR_VALUE).toInt()
        var nonFilled = MAX_BAR_VALUE - barLength

        var barString = ""
        while (barLength > 0) {
            barString += "█"
            barLength--
        }
        while (nonFilled > 0) {
            barString += " "
            nonFilled--
        }

        val stats = "$hp/$maxHp"
        print("$name  |$barString| $stats\n")
    }

    /**
     * Shows Player stats
     * Formula For calculation bars -
     * MP = 10 , HP = 15
     * For Hp Bar -> (hp / maxHp) * 15 => bars length
     * hpBar length - 15 => Non filled
     * For Mp Bar -> (mp / maxMp) * 10 => bars length
     * mpBar length - 10 => Non filled
     */
    fun getPlayerStats() {

        //Hp Bar
        var hpBarLength: Int = ((hp.toDouble() / maxHp.toDouble()) * MAX_BAR_VALUE).toInt()
        var hpNonFilled = MAX_BAR_VALUE - hpBarLength

        var hpBarString = ""
        while (hpBarLength > 0) {
            hpBarString += "█"
            hpBarLength--
        }
        while (hpNonFilled > 0) {
            hpBarString += " "
            hpNonFilled--
        }

        //Mp Bar
        var mpBarLength: Int = ((mp.toDouble() / maxMp.toDouble()) * MAX_MP_BAR_VALUE).toInt()
        var mpNonFilled = MAX_MP_BAR_VALUE - mpBarLength

        var mpBarString = ""
        while (mpBarLength > 0) {
            mpBarString += "█"
            mpBarLength--
        }
        while (mpNonFilled > 0) {
            mpBarString += " "
            mpNonFilled--
        }

        val hpStats = "$hp/$maxHp"
        val mpStats = "$mp/$maxMp"
        print("$name  HP :|$hpBarString| $hpStats   MP :|$mpBarString| $mpStats\n")
    }
}