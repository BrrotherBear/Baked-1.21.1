package com.teddyaide.baked.datagen;

import com.teddyaide.baked.block.ModBlocks;
import com.teddyaide.baked.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.Models;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {


        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(ModBlocks.STRAIN_BANK);

    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.YEAST_CELLS_VILE, Models.GENERATED);
        itemModelGenerator.register(ModItems.BAKERS_YEAST, Models.GENERATED);
        itemModelGenerator.register(ModItems.EMPTY_VILE, Models.GENERATED);
        itemModelGenerator.register(ModItems.STRAW, Models.GENERATED);
        itemModelGenerator.register(ModItems.LARGE_EMPTY_VILE, Models.GENERATED);
        itemModelGenerator.register(ModItems.LARGE_YEAST_CELLS_VILE, Models.GENERATED);
    }
}
