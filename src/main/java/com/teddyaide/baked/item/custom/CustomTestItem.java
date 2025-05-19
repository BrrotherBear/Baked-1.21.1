package com.teddyaide.baked.item.custom;


import com.teddyaide.baked.block.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemUsageContext;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.world.World;

import java.util.Map;

public class CustomTestItem extends Item {
    private static final Map<Block, Block> BAKED_BLOCK_MAP =
            Map.of(
                    ModBlocks.PLACE_HOLDER, Blocks.IRON_BLOCK,
                    Blocks.IRON_BLOCK, ModBlocks.PLACE_HOLDER
            );

    public CustomTestItem(Settings settings) {
        super(settings);
    }

    @Override
    public ActionResult useOnBlock(ItemUsageContext context) {
        World world = context.getWorld();
        Block clickedBakedBlock = world.getBlockState(context.getBlockPos()).getBlock();

        if(BAKED_BLOCK_MAP.containsKey(clickedBakedBlock)) {
            if(!world.isClient()) {
                world.setBlockState(context.getBlockPos(), BAKED_BLOCK_MAP.get(clickedBakedBlock).getDefaultState());

                context.getStack().damage(1,((ServerWorld) world), ((ServerPlayerEntity) context.getPlayer()),
                        item -> context.getPlayer().sendEquipmentBreakStatus(item, EquipmentSlot.MAINHAND));

                world.playSound(null, context.getBlockPos(), SoundEvents.BLOCK_ANCIENT_DEBRIS_HIT, SoundCategory.BLOCKS);
            }
        }


        return ActionResult.SUCCESS;
    }
}
