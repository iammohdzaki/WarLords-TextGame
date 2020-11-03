package inventory.spells

/**
 * Spell Class - Creates a spell
 */
class Spell(
    var spellName: String,
    var spellCost: Int,
    var spellDamage: Int,
    var spellType: String) {

    /**
     * Generate a random damage of dark spells
     */
    fun generateDamage():Int{
        var minDmg = spellDamage - 15
        var maxDmg = spellDamage + 15
        return (minDmg..maxDmg).random()
    }

    /**
     * Generate a random heal of white spells
     */
    fun generateHealing():Int{
        return generateDamage()
    }
}