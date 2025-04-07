package net.salamanderyyyy.testArien.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.salamanderyyyy.testArien.TestMod;
import net.salamanderyyyy.testArien.block.ModBlocks;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, TestMod.MODID);

    public static final Supplier<CreativeModeTab> TESTNMOD_ITEMS_TAB = CREATIVE_MODE_TAB.register("testmod_items_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.ESSENCE.get()))
                    .title(Component.translatable("creativetab.saltestingmod.testmod_items"))
                    .displayItems((parameters, output) -> {
                        output.accept(ModItems.ESSENCE);
                        output.accept(ModItems.ARIEN_SWORD);
                        output.accept(ModBlocks.ARIEN_BLOCK);
                        output.accept(ModItems.ARIEN_SPAWN_EGG);

                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
