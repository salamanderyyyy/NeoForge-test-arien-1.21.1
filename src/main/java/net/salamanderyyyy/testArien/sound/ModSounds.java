package net.salamanderyyyy.testArien.sound;

import net.minecraft.core.registries.BuiltInRegistries;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.salamanderyyyy.testArien.TestMod;

import java.util.function.Supplier;

public class ModSounds {
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS =
            DeferredRegister.create(BuiltInRegistries.SOUND_EVENT, TestMod.MODID);

    public static final Supplier<SoundEvent> ARIEN_AMBIENT =
            SOUND_EVENTS.register("entity.arien.ambient",
                    () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "entity.arien.ambient")));

    public static final Supplier<SoundEvent> ARIEN_HURT =
            SOUND_EVENTS.register("entity.arien.hurt",
                    () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "entity.arien.hurt")));

    public static final Supplier<SoundEvent> ARIEN_DEATH =
            SOUND_EVENTS.register("entity.arien.death",
                    () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "entity.arien.death")));
    public static final Supplier<SoundEvent> ARIEN_BREED =
            SOUND_EVENTS.register("entity.arien.breed",
                    () -> SoundEvent.createVariableRangeEvent(ResourceLocation.fromNamespaceAndPath(TestMod.MODID, "entity.arien.breed")));
}

