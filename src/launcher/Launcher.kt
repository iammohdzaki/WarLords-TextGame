package launcher

import util.*

//Game Launcher
fun main(args:Array<String>){

    var isGameRunning = true
    var i=0
    var players = Config.getPlayers()
    var enemies = Config.getEnemies()

    while (isGameRunning){
        println("==================================================")
        print("------------ Welcome to War Lords ----------------")
        print("\n\n")

        //Player Stats
        println("===============* Player Stats *====================")
        for (player in players){
            player.getPlayerStats()
        }
        print("=====================================================\n")

        //Enemy Stats
        println("===============* Enemy Stats *====================")
        for (enemy in enemies){
            enemy.getEnemyStats()
        }
        println("=====================================================")

        //Player Phase
        PlayerLoop@ for (player in players){
            //Let player choose a action

            println("Player ${player.name.replace(" ","")} turn : ")

            player.chooseAction()
            var choice:Int = (readLine()?.toInt() ?: -1) - 1

            //Perform Accordingly
            when(choice){
                PlayerActionIndex.ATTACK  -> {
                    var dmg = player.generateDamage()
                    var enemyIndex = player.chooseTarget(enemies)
                    enemies[enemyIndex].takeDamage(dmg)
                    println("You attacked ${enemies[enemyIndex].name.replace(" ","")} " +
                            "for $dmg, points of damage.")

                    //Check if enemy dies
                    if(enemies[enemyIndex].hp == 0){
                        println("${enemies[enemyIndex].name.replace(" ","")} has died.")
                        enemies.removeAt(enemyIndex)
                    }
                }
                PlayerActionIndex.MAGIC -> {
                    player.chooseMagic()

                    var magicChoice:Int = (readLine()?.toInt() ?: 0) - 1
                    //Get the choose spell and generate damage
                    var spell = player.spells[magicChoice]
                    var magicDmg = spell.generateDamage()

                    //Check if user can buy
                    var currentMp = player.mp

                    if(spell.spellCost > currentMp){
                        println("Insufficient MP")
                        continue@PlayerLoop
                    }

                    player.reduceMp(spell.spellCost)

                    //Check if spell is dark or white
                    if(spell.spellType == SpellType.WHITE){
                        //Heal
                        player.heal(magicDmg)
                        println("${spell.spellName} heals for $magicDmg HP.")
                    }else if(spell.spellType == SpellType.DARK){
                        //Damage
                        var enemy = player.chooseTarget(enemies)
                        enemies[enemy].takeDamage(magicDmg)

                        println("${spell.spellName} deals $magicDmg, points of damage to" +
                                "${enemies[enemy].name.replace(" ","")}.")

                        //Check if Enemy Dies
                        if(enemies[enemy].hp == 0){
                            println("${enemies[enemy].name.replace(" ","")} has died.")
                            enemies.removeAt(enemy)
                        }
                    }
                }
                PlayerActionIndex.ITEMS -> {
                    player.chooseItem()

                    var itemChoice = (readLine()?.toInt() ?: 0) - 1
                    if(itemChoice < 0 || itemChoice > 6){
                        continue@PlayerLoop
                    }

                    var item = player.items[itemChoice].item
                    var quantity = player.items[itemChoice].quantity

                    if(quantity == 0){
                        println("None Left..")
                        continue@PlayerLoop
                    }

                    quantity--
                    player.items[itemChoice].quantity = quantity

                    //CHeck For Item Type and perform accordingly
                    if(item.itemType == ItemType.POTION){
                        player.heal(item.itemProperty)
                        println("${item.itemName} heals for ${item.itemProperty}.")
                    }else if(item.itemType == ItemType.ELIXIR){
                        //Check for Mega Elixir or Elixir
                        if(item.itemName == "MegaElixir"){
                            for (p in players){
                                p.hp = p.maxHp
                                p.mp = p.maxMp
                            }
                        }else{
                            player.mp = player.maxMp
                            player.hp = player.maxHp
                        }
                        println("${item.itemName} fully restores HP/MP.")
                    }else if(item.itemType == ItemType.ATTACK){
                        var enemy = player.chooseTarget(enemies)
                        enemies[enemy].takeDamage(item.itemProperty)

                        println("${item.itemName} deals, ${item.itemProperty} points of damage to ${enemies[enemy].name}")

                        if(enemies[enemy].hp == 0){
                            println("${enemies[enemy].name.replace(" ","")} has died.")
                            enemies.removeAt(enemy)
                        }
                    }
                }
            }
        }

        //Check if Battle is Over
        var defeatedEnemies = 0
        var defeatedPlayers = 0

        //Check if any enemy defeated
        for (enemy in enemies){
            if(enemy.hp == 0){
                defeatedEnemies++
            }
        }
        //Check if any player defeated
        for (player in players){
            if(player.hp == 0){
                defeatedPlayers++
            }
        }

        //Check if Player Won
        if(defeatedEnemies == 2){
            println("You Win!")
            isGameRunning = false
        }

        //Check if Enemy Won
        if(defeatedPlayers == 2){
            println("Your Enemies Defeated you!")
            isGameRunning = false
        }


        //Enemy Attack Phase
        for(enemy in enemies){
            var enemyChoice = (0 until 2).random()

            if(enemyChoice == 0){
                var target = (0 until 3).random()
                var enemyDmg = enemy.generateDamage()
                players[target].takeDamage(enemyDmg)

                println("${enemy.name.replace(" ","")} attacks ${players[target].name.replace(" ","")}" +
                        "for $enemyDmg.")
            }else if(enemyChoice == 1){
                //(TODO)Choose Spell
            }
        }

    }




}