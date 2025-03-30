package net.salamanderyyyy.testArien.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.salamanderyyyy.testArien.TestMod;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> INCORRECT_FOR_ARIEN_TOOL = createTag("incorrect_for_arien_tool");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, name));
        }
    }

    public static class Items {


        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, name));
        }
    }
}
