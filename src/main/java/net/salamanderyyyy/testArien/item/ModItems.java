package net.salamanderyyyy.testArien.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.salamanderyyyy.testArien.TestMod;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TestMod.MODID);

    public static final DeferredItem<Item> ESSENCE = ITEMS.register("essence",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ARIEN_SWORD = ITEMS.register("arien_sword",
            () -> new Item(new Item.Properties()));

    public static void register (IEventBus eventbus) {
        ITEMS.register(eventbus);
    }

}
