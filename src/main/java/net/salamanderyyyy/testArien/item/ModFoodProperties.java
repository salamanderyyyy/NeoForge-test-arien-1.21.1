package net.salamanderyyyy.testArien.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoodProperties {
    public static final FoodProperties ESSENCE = new FoodProperties.Builder().nutrition(4).saturationModifier(0.5f)
            .effect(() -> new MobEffectInstance(MobEffects.JUMP, 200, 1), 1.0f).build();
}
