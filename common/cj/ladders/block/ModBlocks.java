package cj.ladders.block;

import net.minecraft.block.Block;
import cj.ladders.lib.BlockIds;
import cj.ladders.lib.Strings;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class ModBlocks {

	/* Mod block instances */

	public static Block ironladder,goldenladder,diamondladder,obsidianladder,
		lapisladder,emeraldladder,warnladder;

	public static void init() {
		int i = 0;
		// init ladders
		ironladder = new BlockSLadders(BlockIds.IRON_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(ironladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		goldenladder = new BlockSLadders(BlockIds.GOLDEN_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(goldenladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		diamondladder = new BlockSLadders(BlockIds.DIAMOND_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(diamondladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		obsidianladder = new BlockSLadders(BlockIds.OBSIDIAN_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(obsidianladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		lapisladder = new BlockSLadders(BlockIds.LAPIS_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(lapisladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		emeraldladder = new BlockSLadders(BlockIds.EMERALD_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(emeraldladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		warnladder = new BlockSLadders(BlockIds.WARN_LADDER).setUnlocalizedName(Strings.LADDER_TYPE[i]+Strings.LADDER_NAME);
		GameRegistry.registerBlock(warnladder, Strings.LADDER_TYPE[i++]+Strings.LADDER_NAME);
		
		i=0;
		LanguageRegistry.addName(ironladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(goldenladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(diamondladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(obsidianladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(lapisladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(emeraldladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);
		LanguageRegistry.addName(warnladder, Strings.LADDER_TYPE[i++]+" "+Strings.LADDER_NAME);

	}

}
