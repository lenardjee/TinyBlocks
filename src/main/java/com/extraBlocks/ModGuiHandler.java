package com.extraBlocks;

import com.extraBlocks.block.miniBlock.TileEntityMiniBlock;
import com.extraBlocks.item.tool.SaveModelBase.ContainerSaveModel;
import com.extraBlocks.item.tool.SaveModelBase.GuiSaveModel;
import com.extraBlocks.pedestal.ContainerPedestal;
import com.extraBlocks.pedestal.GuiPedestal;
import com.extraBlocks.pedestal.TileEntityPedestal;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class ModGuiHandler implements IGuiHandler {

	public static final int PEDESTAL = 0, SAVEBLOCKGUI = 1;

	@Override
	public Container getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case PEDESTAL:
				return new ContainerPedestal(player.inventory, (TileEntityPedestal) world.getTileEntity(new BlockPos(x, y, z)));
			case SAVEBLOCKGUI:
				return new ContainerSaveModel(player, (TileEntityMiniBlock) world.getTileEntity(new BlockPos(x, y, z)));
			default:
				return null;
		}
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch (ID) {
			case PEDESTAL:
				return new GuiPedestal(getServerGuiElement(ID, player, world, x, y, z), player.inventory);
			case SAVEBLOCKGUI:
				return new GuiSaveModel((ContainerSaveModel) getServerGuiElement(ID, player, world, x, y, z), player);
			default:
				return null;
		}
	}

	

}