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

public class BlockSLadders extends BlockContainer {

	public BlockSLadders(int par1) {
		super(par1,Material.iron);
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
	
	@Override
    public boolean isLadder(World world, int x, int y, int z) 
    {
        return true;
    }
    
        @Override
    public boolean canPlaceBlockOnSide(World var1, int var2, int var3, int var4, int var5)
    {
        switch (var5)
        {
            case 1:
                return this.canBePlacedOn(var1.getBlockId(var2, var3, var4 + 1));
            case 2:
                return this.canBePlacedOn(var1.getBlockId(var2, var3, var4 + 1));
            case 3:
                return this.canBePlacedOn(var1.getBlockId(var2, var3, var4 - 1));
            case 4:
                return this.canBePlacedOn(var1.getBlockId(var2 + 1, var3, var4));
            case 5:
                return this.canBePlacedOn(var1.getBlockId(var2 - 1, var3, var4));
            default:
                return false;
        }
    }
        
    private boolean canBePlacedOn(int var1)
    {
        if (var1 == 0)
        {
            return false;
        }
        else
        {
            Block var2 = Block.blocksList[var1];
            return var2.renderAsNormalBlock() && var2.blockMaterial.blocksMovement();
        }
    }


        @Override
    public AxisAlignedBB getCollisionBoundingBoxFromPool(World world, int i, int j, int k)
    {
        int l = world.getBlockMetadata(i, j, k);
        float f = 0.125F;
        if(l == 1)
        {
            setBlockBounds(0.0F, 0.0F, 1.0F - f, 1.0F, 1.0F, 1.0F);
        }
        if(l == 4)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, f);
        }
        if(l == 8)
        {
            setBlockBounds(1.0F - f, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
        }
        if(l == 2)
        {
            setBlockBounds(0.0F, 0.0F, 0.0F, f, 1.0F, 1.0F);
        }
        return super.getCollisionBoundingBoxFromPool(world, i, j, k);
    }
    
        @Override
    public void setBlockBoundsForItemRender()
    {
        this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 1.0F, 1.0F);
    }


        @Override
    public boolean isOpaqueCube()
    {
        return false;
    }


        @Override
    public boolean renderAsNormalBlock()
    {
        return false;
    }
    
        @Override
    public void setBlockBoundsBasedOnState(IBlockAccess var1, int var2, int var3, int var4)
    {
        int metaData = var1.getBlockMetadata(var2, var3, var4);
        float var7 = 1.0F;
        float var8 = 1.0F;
        float var9 = 1.0F;
        float var10 = 0.0F;
        float var11 = 0.0F;
        float var12 = 0.0F;
        boolean var13 = metaData > 0;
        if ((metaData & 2) != 0)
        {
            var10 = Math.max(var10, 0.0625F);
            var7 = 0.0F;
            var8 = 0.0F;
            var11 = 1.0F;
            var9 = 0.0F;
            var12 = 1.0F;
            var13 = true;
        }


        if ((metaData & 8) != 0)
        {
            var7 = Math.min(var7, 0.9375F);
            var10 = 1.0F;
            var8 = 0.0F;
            var11 = 1.0F;
            var9 = 0.0F;
            var12 = 1.0F;
            var13 = true;
        }


        if ((metaData & 4) != 0)
        {
            var12 = Math.max(var12, 0.0625F);
            var9 = 0.0F;
            var7 = 0.0F;
            var10 = 1.0F;
            var8 = 0.0F;
            var11 = 1.0F;
            var13 = true;
        }


        if ((metaData & 1) != 0)
        {
            var9 = Math.min(var9, 0.9375F);
            var12 = 1.0F;
            var7 = 0.0F;
            var10 = 1.0F;
            var8 = 0.0F;
            var11 = 1.0F;
            var13 = true;
        }


        this.setBlockBounds(var7, var8, var9, var10, var11, var12);
    }


        @Override
    public int getRenderType()
    {
                return Block.vine.getRenderType();
    }


        @Override
    public int quantityDropped(Random random)
    {
        return 0;
    }
    
        @Override
    public void onBlockDestroyedByPlayer(World world, int i, int j, int k, int l)
    {
        onBlockDestroyed(world, i, j, k);
    }


        @Override
    public void onBlockDestroyedByExplosion(World world, int i, int j, int k, Explosion e)
    {
        onBlockDestroyed(world, i, j, k);
    }
        
    public void onBlockDestroyed(World world, int a, int b, int c)
    {}
        


        @Override
        public TileEntity createNewTileEntity(World var1)
        {
                return null;
        }
}
