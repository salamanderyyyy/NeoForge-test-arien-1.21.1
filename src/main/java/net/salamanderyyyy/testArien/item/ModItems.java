package net.salamanderyyyy.testArien.item;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import net.minecraft.world.item.enchantment.Enchantment;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.DeferredSpawnEggItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.salamanderyyyy.testArien.TestMod;
import net.salamanderyyyy.testArien.entity.ModEntities;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);

    public static final DeferredItem<Item> ESSENCE = ITEMS.register("essence",
            () -> new Item(new Item.Properties().food(ModFoodProperties.ESSENCE)){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.saltestingmod.essence.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    public static final DeferredItem<AxeItem> ARIEN_SWORD = ITEMS.register("arien_sword",
            () -> new AxeItem(ModToolTiers.Arien, new Item.Properties()
                    .attributes(AxeItem.createAttributes(ModToolTiers.Arien, 6.0f, -2.4f))) {

                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.saltestingmod.arien_sword.tooltip"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }

                @Override
                public boolean isEnchantable(ItemStack stack) {
                    return true;
                }

            });

    public static final DeferredItem<Item> ARIEN_SPAWN_EGG = ITEMS.register("arien_spawn_egg",
            () -> new DeferredSpawnEggItem(ModEntities.ARIEN,0x137A7F, 0x86CECB,
                    new Item.Properties()));


    public static void register (IEventBus eventbus) {
        ITEMS.register(eventbus);
    }





}
