package com.teddyaide.baked.item;

import com.teddyaide.baked.Baked;
import com.teddyaide.baked.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {
    public static final ItemGroup BAKED_ITEMS = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(Baked.MOD_ID, "baked_items"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModItems.YEAST_CELLS_VILE))
                    .displayName(Text.translatable("itemgroup.baked.baked_items"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModItems.EMPTY_VILE);
                        entries.add(ModItems.LARGE_EMPTY_VILE);
                        entries.add(ModItems.YEAST_CELLS_VILE);
                        entries.add(ModItems.LARGE_YEAST_CELLS_VILE);
                        entries.add(ModItems.BAKERS_YEAST);
                        entries.add(ModBlocks.STRAIN_BANK);
                    }).build());


    public static void registerBakedItemGroups() {
        Baked.LOGGER.info("Registering Baked Item Groups - " + Baked.MOD_ID);
    }
}
