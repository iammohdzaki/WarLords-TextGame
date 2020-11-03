package inventory.spells

import util.SpellType

object SpellsInventory {

    /**
     * Black Magic Spells
     */
    fun getFireSpell():Spell{
        return Spell("Fire", 25, 600, SpellType.DARK)
    }

    fun getThunderSpell():Spell{
        return Spell("Thunder", 20, 500, SpellType.DARK);
    }

    fun getBlizzardSpell():Spell{
        return Spell("Blizzard", 15, 400, SpellType.DARK)
    }

    fun getMeteorSpell():Spell{
        return Spell("Meteor", 40, 1200, SpellType.DARK)
    }

    fun getQuakeSpell():Spell{
        return Spell("Quake", 10, 100, SpellType.DARK)
    }

    /**
     * White Magic Spells
     */
    fun getCureSpell():Spell{
        return Spell("Cure", 25, 620, SpellType.WHITE)
    }

    fun getCuraSpell():Spell{
        return Spell("Cura", 32, 1500, SpellType.WHITE)
    }

    fun getCuragaSpell():Spell{
        return Spell("Curaga", 50, 6000, SpellType.WHITE)
    }
}