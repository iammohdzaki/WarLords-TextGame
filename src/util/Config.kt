package util

import inventory.Person
import inventory.items.ItemsInventory
import inventory.items.PlayerItems
import inventory.spells.Spell
import inventory.spells.SpellsInventory

object Config {

    /**
     * Returns Players
     */
    fun getPlayers(): ArrayList<Person> {
        val players = ArrayList<Person>()
        players.add(Person("Valos ", 3260, 132, 300, 34, getPlayerSpells(), getPlayerItems()))
        players.add(Person("Nick  ", 4160, 188, 311, 34, getPlayerSpells(), getPlayerItems()))
        players.add(Person("Robot ", 3089, 174, 288, 34, getPlayerSpells(), getPlayerItems()))
        return players
    }

    /**
     * Returns Enemies
     */
    fun getEnemies(): ArrayList<Person> {
        val enemies = ArrayList<Person>()
        enemies.add(Person("Imp    ", 1250, 130, 560, 325, getEnemySpells(), ArrayList()))
        enemies.add(Person("Magus  ", 18200, 701, 525, 25, getEnemySpells(), ArrayList()))
        enemies.add(Person("Goblin ", 1250, 130, 560, 325, getEnemySpells(), ArrayList()))
        return enemies
    }

    /**
     * Player Spells - Fire,Thunder,Blizzard,Meteor,Cure,Cura
     */
    private fun getPlayerSpells(): ArrayList<Spell> {
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
    private fun getEnemySpells(): ArrayList<Spell> {
        val whiteSpells = ArrayList<Spell>()
        whiteSpells.add(SpellsInventory.getFireSpell())
        whiteSpells.add(SpellsInventory.getMeteorSpell())
        whiteSpells.add(SpellsInventory.getCuragaSpell())
        return whiteSpells
    }

    /**
     * Get Player Items - Potion,HiPotion,SuperPotion,Elixir,MegaElixir,Poison
     */
    fun getPlayerItems(): ArrayList<PlayerItems> {
        val playerItems = ArrayList<PlayerItems>()
        playerItems.add(PlayerItems(ItemsInventory.getPotion(), 15))
        playerItems.add(PlayerItems(ItemsInventory.getHiPotion(), 5))
        playerItems.add(PlayerItems(ItemsInventory.getSuperPotion(), 5))
        playerItems.add(PlayerItems(ItemsInventory.getElixir(), 5))
        playerItems.add(PlayerItems(ItemsInventory.getMegaElixir(), 2))
        playerItems.add(PlayerItems(ItemsInventory.getPoison(), 5))
        return playerItems
    }

    /**
     * Get Player Actions
     */
    fun getPlayerActions(): ArrayList<String> {
        val playerActions = ArrayList<String>()
        playerActions.add(PlayerActions.ATTACK)
        playerActions.add(PlayerActions.MAGIC)
        playerActions.add(PlayerActions.ITEMS)
        return playerActions
    }
}