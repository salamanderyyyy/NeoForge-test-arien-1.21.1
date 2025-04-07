package net.salamanderyyyy.testArien.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.salamanderyyyy.testArien.TestMod;
import net.salamanderyyyy.testArien.entity.custom.ArienEntity;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, TestMod.MODID);

    public static final Supplier<EntityType<ArienEntity>> ARIEN =
            ENTITY_TYPES.register("arien", () -> EntityType.Builder.of(ArienEntity::new, MobCategory.CREATURE)
                    .sized(0.6f, 1.8f).build("arien"));

    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}
