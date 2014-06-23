package com.brandon3055.draconicevolution.common.blocks;

import java.util.List;
import java.util.Random;

import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import com.brandon3055.draconicevolution.DraconicEvolution;
import com.brandon3055.draconicevolution.common.core.handler.ParticleHandler;
import com.brandon3055.draconicevolution.common.core.network.ExamplePacket;

public class TestBlock extends TolkienBlock {

	protected TestBlock() {
		super(Material.rock);
		this.setBlockName("testBlock");
		this.setCreativeTab(DraconicEvolution.getCreativeTab(2));
		this.setHardness(5f);
		this.setResistance(200.0f);
		//this.setBlockBounds(0.4f, 0f, 0.4f, 0.6f, 1f, 0.6f);
		GameRegistry.registerBlock(this, TestItemBlock.class, this.getUnlocalizedName());
	}

	@Override
	public AxisAlignedBB getCollisionBoundingBoxFromPool(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_)
	{
		return super.getCollisionBoundingBoxFromPool( p_149668_1_,  p_149668_2_,  p_149668_3_,  p_149668_4_);
		//return null;
	}

	@Override
	public ItemStack getPickBlock(MovingObjectPosition target, World world, int x, int y, int z) {
		return new ItemStack(Item.getItemFromBlock(world.getBlock(x,y,z)), 1, world.getBlockMetadata(x,y,z));
		//return super.getPickBlock(target, world, x, y, z);
	}

	@Override
	public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ) {
		return true;
	}

	@Override
	public boolean isOpaqueCube()
	{
		return false;
	}
	

	@Override
	public boolean onBlockActivated(World world, int x, int y, int z, EntityPlayer player, int side, float px, float py, float pz)
	{

		//EntityLightningBolt bolt = new EntityLightningBolt(world, x, y, z + 5);
		System.out.println(world.getBlockMetadata(x,y,z));
		//world.spawnEntityInWorld(bolt);
		/*
		if (!world.isRemote && !player.isSneaking())
		{
			System.out.println("Sending from server");
			DraconicEvolution.channelHandler.sendToAll(new ExamplePacket());
		}

		if (world.isRemote && player.isSneaking())
		{
			System.out.println("Sending from client");
			DraconicEvolution.channelHandler.sendToServer(new ExamplePacket());
		}
		*/
		return true;
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void getSubBlocks(Item item, CreativeTabs p_149666_2_, List list) {
		for (int i = 0; i < 16; i++) {
			list.add(new ItemStack(item, 1, i));
		}
	}

	@Override
	public Item getItemDropped(int p_149650_1_, Random p_149650_2_, int p_149650_3_)
	{
		// TODO Auto-generated method stub
		return super.getItemDropped( p_149650_1_,  p_149650_2_,  p_149650_3_);
	}

	
	@Override
	public void randomDisplayTick(World world, int x, int y, int z, Random rand)
	{

	}
}
