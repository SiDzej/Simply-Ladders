package cj.ladders.block;

import java.util.Random;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.BlockVine;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import cj.ladders.Ladders;
import cj.ladders.lib.BlockIds;
import cj.ladders.lib.Reference;
import cj.ladders.lib.Strings;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class BlockLadders extends BlockLadder {

	public BlockLadders(int par1) {
		super(par1);
		//setMaterial(Material.iron);
		this.setCreativeTab(Ladders.tab);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IconRegister ir) {
		if(this.blockID == BlockIds.IRON_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[0] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.GOLDEN_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[1] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.DIAMOND_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[2] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.OBSIDIAN_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[3] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.LAPIS_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[4] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.EMERALD_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[5] + Strings.LADDER_NAME).toLowerCase());
		if(this.blockID == BlockIds.WARN_LADDER)
			blockIcon = ir.registerIcon(Reference.TEXTURES
				+ (Strings.LADDER_TYPE[6] + Strings.LADDER_NAME).toLowerCase());
	}
	
	public String getUnlocalizedName(String par1Str)
    {
        return Strings.LADDER_NAME + this.blockID;
    }
}
