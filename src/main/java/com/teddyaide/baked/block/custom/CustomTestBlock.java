package com.teddyaide.baked.block.custom;

import com.teddyaide.baked.Baked;
import com.teddyaide.baked.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;



public class CustomTestBlock extends Block {
    public CustomTestBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {

        world.playSound(player, pos, SoundEvents.BLOCK_MUD_BREAK, SoundCategory.BLOCKS);
        return ActionResult.SUCCESS;
    }


    @Override
    public void onSteppedOn(World world, BlockPos pos, BlockState state, Entity entity) {
        if(entity instanceof ItemEntity ItemEntity) {
            if(ItemEntity.getStack().getItem() == ModItems.YEAST_CELLS_VILE) {
                ItemEntity.setStack(new ItemStack(ModItems.BAKERS_YEAST, ItemEntity.getStack().getCount()));
            }
        }


        super.onSteppedOn(world, pos, state, entity);
    }
}
