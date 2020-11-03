package util

import inventory.spells.Spell
import inventory.spells.SpellsInventory

object Config {

    /**
     * Player Spells - Fire,Thunder,Blizzard,Meteor,Cure,Cura
     */
    fun getPlayerSpells():ArrayList<Spell>{
        val blackSpells = ArrayList<Spell>()
        blackSpells.add(SpellsInventory.getFireSpell())
        blackSpells.add(SpellsInventory.getThunderSpell())
        blackSpells.add(SpellsInventory.getBlizzardSpell())
        blackSpells.add(SpellsInventory.getMeteorSpell())
        blackSpells.add(SpellsInventory.getCureSpell())
        blackSpells.add(SpellsInventory.getCuraSpell())
        return blackSpells
    }

    /**
     * Enemy Spells - Fire,Meteor,Curaga
     */
    fun getEnemySpells():ArrayList<Spell>{
        val whiteSpells = ArrayList<Spell>()
        whiteSpells.add(SpellsInventory.getFireSpell())
        whiteSpells.add(SpellsInventory.getMeteorSpell())
        whiteSpells.add(SpellsInventory.getCuragaSpell())
        return whiteSpells
    }
}