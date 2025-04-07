package net.salamanderyyyy.testArien.entity.custom;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.salamanderyyyy.testArien.TestMod;
import net.salamanderyyyy.testArien.entity.ModEntities;
import net.salamanderyyyy.testArien.item.ModItems;
import net.salamanderyyyy.testArien.sound.ModSounds;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ArienEntity extends Animal {

    public final AnimationState idleAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public ArienEntity(EntityType<? extends Animal> entityType, Level level) {
        super(entityType, level);
    }


    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0,new FloatGoal(this));
        this.goalSelector.addGoal(1,new PanicGoal(this, 1.0));
        this.goalSelector.addGoal(2,new BreedGoal(this, 1.0));
        this.goalSelector.addGoal(3,new TemptGoal(this, 1.25, Ingredient.of(Items.DIORITE), false));
        this.goalSelector.addGoal(4,new WaterAvoidingRandomStrollGoal(this, 1.0));
        this.goalSelector.addGoal(5,new LookAtPlayerGoal(this, Player.class, 6.0f));
        this.goalSelector.addGoal(6,new RandomLookAroundGoal(this));


    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 20d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24D);
    }

    @Override
    public boolean isFood(ItemStack stack) {
        return stack.is(Items.AXOLOTL_BUCKET);
    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel level, AgeableMob otherParent) {
        return ModEntities.ARIEN.get().create(level);
    }

    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.tickCount);
        }
        else{
            --idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
    }

    @Override
    protected @Nullable SoundEvent getAmbientSound() {
        return ModSounds.ARIEN_AMBIENT.get();
    }

    @Override
    protected @Nullable SoundEvent getHurtSound(DamageSource damageSource) {
        return ModSounds.ARIEN_HURT.get();
    }

    @Override
    protected @Nullable SoundEvent getDeathSound() {
        return ModSounds.ARIEN_DEATH.get();
    }

    @Override
    public void spawnChildFromBreeding(ServerLevel level, Animal otherParent) {
        super.spawnChildFromBreeding(level, otherParent);

        level.playSound(null, this.blockPosition(),
                ModSounds.ARIEN_BREED.get(), this.getSoundSource(),
                1.0F, 1.0F);
    }

    @Override
    public void awardKillScore(@NotNull Entity killed, int score, @NotNull DamageSource damageSource) {
        super.awardKillScore(killed, score, damageSource);

        if (this.isBaby()) return;


        this.level().addFreshEntity(new ExperienceOrb(this.level(), this.getX(), this.getY(), this.getZ(), 5 + this.random.nextInt(4)));


        ItemStack drop = new ItemStack(ModItems.ESSENCE.get(), 1 + this.random.nextInt(2));
        this.level().addFreshEntity(new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), drop));
    }


}
