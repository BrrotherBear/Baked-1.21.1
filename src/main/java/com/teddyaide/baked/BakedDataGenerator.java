package com.teddyaide.baked;

import com.teddyaide.baked.datagen.*;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class BakedDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack bakedgenpack = fabricDataGenerator.createPack();

		bakedgenpack.addProvider(ModBlockTagProvider::new);
		bakedgenpack.addProvider(ModItemTagProvider::new);
		bakedgenpack.addProvider(ModLootTableProvider::new);
		bakedgenpack.addProvider(ModModelProvider::new);
		bakedgenpack.addProvider(ModRecipeProvider::new);
	}
}
