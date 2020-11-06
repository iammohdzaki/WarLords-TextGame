package util


const val MAX_BAR_VALUE=15
const val MAX_MP_BAR_VALUE=10

/**
 * Types of Spells
 */
object SpellType {
    const val DARK = "DARK"
    const val WHITE = "WHITE"
}

/**
 * Types of Items
 */
object ItemType {
    const val POTION = "potion"
    const val ELIXIR = "elixer"
    const val ATTACK = "attack"
}

/**
 * Player Actions
 */
object PlayerActions {
    const val ATTACK = "ATTACK"
    const val MAGIC = "MAGIC"
    const val ITEMS = "ITEMS"
}

object PlayerActionIndex{
    const val ATTACK = 0
    const val MAGIC = 1
    const val ITEMS = 2
}

