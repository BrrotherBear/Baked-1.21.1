package com.teddyaide.baked;

import com.teddyaide.baked.block.ModBlocks;
import com.teddyaide.baked.item.ModItemGroups;
import com.teddyaide.baked.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Baked implements ModInitializer {

	public static final String MOD_ID = "baked";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItemGroups.registerBakedItemGroups();


		ModItems.registerBakedItems();
		ModBlocks.registerBakedModBlocks();
	}
}