package com.teddyaide.baked.block;

import com.teddyaide.baked.Baked;
import com.teddyaide.baked.block.custom.StrainBankBlock;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {

    public static final Block STRAIN_BANK = registerBakedBlock("strain_bank", new StrainBankBlock(AbstractBlock.Settings.create().nonOpaque()));

    public static final Block PLACE_HOLDER = registerBakedBlock("place_holder", new Block(AbstractBlock.Settings.create()));

    private static Block registerBakedBlock(String name, Block block) {
        registerBakedBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(Baked.MOD_ID, name), block);
    }

    private static void registerBakedBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(Baked.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }



    public static void registerBakedModBlocks() {
        Baked.LOGGER.info("Registering Baked Blocks - " + Baked.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.BUILDING_BLOCKS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(STRAIN_BANK);
            fabricItemGroupEntries.add(PLACE_HOLDER);
        });
    }
}
