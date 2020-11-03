package inventory.items

object ItemsInventory {

    /**
     * Healing Items
     */
    fun getPotion():Item{
        return Item("Potion", "potion", "Heals 50 HP", 50)
    }

    fun getHiPotion():Item{
        return  Item("Hi-Potion", "potion", "Heals 100 HP", 100)
    }

    fun getSuperPotion():Item{
        return  Item("Super Potion", "potion", "Heals 1000 HP", 1000)
    }

    fun getElixir():Item{
        return Item("Elixer", "elixer", "Fully restores HP/MP of one party member", 9999)
    }

    fun getMegaElixir():Item{
        return Item("MegaElixer", "elixer", "Fully restores party's HP/MP", 9999)
    }

    /**
     * Damage Items
     */
    fun getPoison():Item{
        return Item("Poison", "attack", "Deals 500 damage", 500)
    }
}