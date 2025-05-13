package com.teddyaide.baked.item;

import com.teddyaide.baked.Baked;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {

    public static final Item EMPTY_VILE = registerItem("empty_vile", new Item(new Item.Settings()));
    public static final Item LARGE_EMPTY_VILE = registerItem("large_empty_vile", new Item(new Item.Settings()));




    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(Baked.MOD_ID, name), item);
    }

    public static void registerBakedItems() {
        Baked.LOGGER.info("Registering Baked Items - " + Baked.MOD_ID);

        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register(fabricItemGroupEntries -> {
            fabricItemGroupEntries.add(EMPTY_VILE);
            fabricItemGroupEntries.add(LARGE_EMPTY_VILE);
        });


    }

}
