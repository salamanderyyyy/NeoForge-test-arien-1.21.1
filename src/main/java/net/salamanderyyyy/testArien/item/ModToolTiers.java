package net.salamanderyyyy.testArien.item;

import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.salamanderyyyy.testArien.util.ModTags;

public class ModToolTiers {
    public static final Tier Arien = new SimpleTier(ModTags.Blocks.INCORRECT_FOR_ARIEN_TOOL,
            1000, 4f, 3f, 20, () -> Ingredient.of(ModItems.ESSENCE));
}
