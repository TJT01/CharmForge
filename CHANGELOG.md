# Changelog

## 2.3.3
* Restored 2x2 bread and paper recipes
* Added missing terracotta firing recipe #82
* Added mixin blacklisting
* Added Bumblezone compatibility for sugar block when touching water

## 2.3.2
* Fixes #68, #72, #61, #59
* Support recipe button hidden by other mods #24
* Support for other mod renderlayers #23
* Crafting table tags #47
* Added zh_tw localization ([Pancakes0228](https://github.com/Pancakes0228)) svenhjol/Charm#434
* Improved Raid Horn model
* Woodcutter and kiln recipe namespaces are now "charm" not "minecraft"
* Atlas renders properly left-handedly
* Disabled oak bookshelf recipe

## 2.3.1
* Acquisition compatibility fixes
* Added missing tag for variant chests guarded by piglins
* Prevent warnings in mineshaft mixin #42
* Check trader has maps to trade #38
* Fix some variant pig textures not being shown
* Fix forge tags for variant chests #18
* Fix bookcase filter #32

## 2.3.0
* Added improved atlases (F43nd1r)
* Added player pressure plates (F43nd1r)
* Remove mob sound culling

## 2.2.3
* Mineshaft improvements no longer apply to mesa/badlands mineshafts

## 2.2.2
* Show repair cost in item tooltip when on the anvil screen
* Rework enchantment hook due to incompatible mods
* Added configurable spawn weight for beekeepers and lumberjacks
* Translations provided by [BardinTheDwarf](https://github.com/BardinTheDwarf) and [ph0elyx](https://github.com/ph0elyx)

## 2.2.1
* Fix inventory buttons not working
* Rework mixin for compatibility with enchantment table display #448
* Remove custom name nbt from variant chests, barrels and crates
* Added aerial affinity (F43nd1r)
* Added extra recipes (Coranthes)

## 2.2.0
* Fix Wandering Trader not spawning (F43nd1r)
* Fix grindstone xp exploit (sven)
* Enchantment descriptions support (F43nd1r)
* Coral Squids may now be captured in a bucket. They do not despawn when placed (Coranthes)
* Feeding animals restocks item (F43nd1r)
* Hoe harvesting no longer places block in offhand (F43nd1r)
* Config option to enable no trampling of crops even without feather falling (F43nd1r)
* Config option to allow opening of atlas in off-hand (F43nd1r)

## 2.1.11
* Added mob sound culling

## 2.1.10
* Fix exploit with books on grindstone
* Fix crates losing their content on world save/load
* Fix Quark overrides not working properly (F43nd1r)
* Fix village builds not spawning villages (Coranthes)
* Remove wither rose from custom village flower builds
* Atlas recipe has been changed
* Dynamic data for custom village builds
* Added More Portal Frames
* Added Map Tooltips with atlas support (F43nd1r)

## 2.1.9
* Fix grindstone enchantment extraction consuming an entire book stack (ridjack)
* Fix crash and compat issues with latest Quark version #424
* [Forge] Fix mod context issue not loading Charmonium properly (#414, others)
* Added Atlas (F43nd1r)

## 2.1.8
* Fix itemgroups. #406
* Fix render hover in incorrect place
* Fix village jigsaw piece problems. #409
* Fix modules being enabled when they shouldn't (#414, others)
* Fix bookshelf recipe in wrong place

## 2.1.7
* Added StackableStews (F43nd1r)
* Fix shulker box tooltip duplication (F43nd1r)
* Fix crates client crash

## 2.1.6
* Fix bowl stack lost when milking Mooblooms #403
* [Forge] Fix ghost entity when using /give #395
* AutoRestock now works properly when adding items to composter (F43nd1r)
* Remove Wandering Trader signal fire restriction
* Remove treasure enchantment cost on grindstone
* Hoe harvesting fully grown crop now plays sound

## 2.1.5
* Fix missing spruce bookshelf recipe
* Fix acquisition enchantment not dropping XP from harvested blocks
* Fix grindstone not showing the XP cost when the player has enough XP
* Fix crates showing tooltip when empty
* Fix overworld music sometimes playing when entering the nether
* Reduce spawn weights of lumberjack and beekeeper village pieces
* Raid Horns volume reduced by 25% and is configurable
* Raid Horns have cooldown after use
* Default amount of levels required to extract a treasure enchantment has been decreased from 15 to 10

## 2.1.4
* Fix mod init load event #392, [Charmonium#8](https://github.com/svenhjol/Charmonium/issues/8)
* Fix overlapping craft and chest buttons. #387
* Fix inventory button flicker when display Quark's backpack ui (F43nd1r)

## 2.1.3-forge-hotfix1
* Fix mod init race condition
* Fix loot table regression

## 2.1.3
* Added AutoRestock (F43nd1r)
* Fix Bookcases not opening #382 (F43nd1r)
* Fix revenge of extract enchantments crash #388

## 2.1.2
* Fix keybinds opening inventories when typing in chat or other guis. #368
* Fix dropped netherite-based items cause crash on dedicated server
* Fix Keybind issues #363
* Fix disabled modules do not disable recipes after change to toml config
* Fix shulker boxes not being craftable with variant chests
* Fix dispenser not firing glowballs
* Fix refined obsidian walls not connecting
* Fix glowballs converting blocks to water source blocks
* Fix super fun post-release text problem with grindstone
* Fix super fun post-release tinted enchantment loot derp
* Reduce spawn weight and group size of Coral Squids
* After much deliberation, we decided Coral Squids should no longer spawn uncontrollably and crash servers
* Enchantments are now extracted by the grindstone (Credit to [martenschaefer](https://github.com/mschae23/grind-enchantments))
* Added Mooblooms
* Added Snow storms
* Added Raid horns
* Added Acquisition enchantment
* Added Tinted enchantment
* JEI woodcutter and kiln integration

## 2.1.1
* Fix Coral Squid hitboxes. #351, #361
* Fix Candles not making sound when lighting
* Fix incompatibilities with Optifine
* Restore Quark integration for crates and bookcases
* Glow balls are now known as glowballs
* Placeable Glowstone Dust has been removed
* Update glowball texture

## 2.1.0
* Totem of Undying causing crash on server. Fixes #339
* VariantAnimalTextures has become VariantMobTextures. This changes the charm.json config file
* Added feature Coral Squids
* Added feature Coral Sea Lanterns
* Added Snow Golem derp face variants
* Added Kilns
* Added Refined Obsidian
* Added Smooth Glowstone
* Glow Pearls and placed glowstone can now light up any solid block face
* Removed invisible mineshaft spiders

## 2.0.4
* Added feature Placeable Glowstone Dust that lets you... place glowstone dust
* Added feature Glow Balls which are projectiles that light up the block they impact
* Added variant snow golem derp faces

## 2.0.3
* Darkness check for Husks and Strays, fixes them spawning in full light
* Lecterns can now be crafted from variant bookshelves. Fixes #330
* Explicit registration of Charm sounds. Relates to #333
* Changed block entity for barrel to fix a server bug. Fixes #332

## 2.0.2
* Candles are now valid decoration blocks when generating structures
* Restored vanilla chests and barrels, crafted using mixed wood
* Added hopper and minecart chest recipes with variant chests #231

## 2.0.1
* Fixed crash when trying to open lumberjack trades (dedicated server)
* Fixed missing loot tables for some custom village structures

## 2.0.0
* Fixed tidy button position on village trade screens
* Fixed broken armor invisibility when stripping in front of mobs
* Updated ladder textures
* Removed tidy button from beacon inventory
* Empty crates no longer drop themselves when in creative mode
* Added config option for chorus fruit teleport range
* Added more lumberjack and beekeeper house builds
* Added Lumberjack and Beekeeper trades
* Added Lumberjack and Beekeeper loot table for their village houses
* Beekeeper trades now use tagged flowers
* Chest texture and trim improvements
* Custom villagers now have zombie textures
* Removed "More Villager Trades" feature
* Axe now effective tool for woodcutter block
* Bump to Minecraft 1.16.3
* Removed improved lanterns due to unsolvable graphical issue
* Reduced mineshaft default ore spawn rate
* Lumberjacks log trade now only uses logs and stripped logs as requested item
* Lumberjacks now sell noteblocks and jukeboxes instead of converting logs to planks