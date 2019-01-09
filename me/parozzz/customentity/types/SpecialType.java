/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.parozzz.customentity.types;

import net.minecraft.server.v1_13_R2.*;

/**
 * @author Paros
 */
public enum SpecialType implements INMSType
{
    ITEM(EntityItem.class, EntityTypes.ITEM),
    EXPERIENCE_ORB(EntityExperienceOrb.class, EntityTypes.EXPERIENCE_ORB),
    AREA_EFFECT_CLOUD(EntityAreaEffectCloud.class, EntityTypes.AREA_EFFECT_CLOUD),
    EGG(EntityEgg.class, EntityTypes.EGG),
    LEASH_KNOT(EntityLeash.class, EntityTypes.LEASH_KNOT),
    PAINTING(EntityPainting.class, EntityTypes.PAINTING),
    ARROW(EntityArrow.class, EntityTypes.ARROW),
    SNOWBALL(EntitySnowball.class, EntityTypes.SNOWBALL),
    FIREBALL(EntityFireball.class, EntityTypes.FIREBALL),
    SMALL_FIREBALL(EntitySmallFireball.class, EntityTypes.SMALL_FIREBALL),
    ENDER_PEARL(EntityEnderPearl.class, EntityTypes.ENDER_PEARL),
    EYE_OF_ENDER(EntityEnderSignal.class, EntityTypes.EYE_OF_ENDER),
    POTION(EntityPotion.class, EntityTypes.POTION),
    EXPERIENCE_BOTTLE(EntityThrownExpBottle.class, EntityTypes.EXPERIENCE_BOTTLE),
    ITEM_FRAME(EntityItemFrame.class, EntityTypes.ITEM_FRAME),
    WITHER_SKULL(EntityWitherSkull.class, EntityTypes.WITHER_SKULL),
    TNT(EntityTNTPrimed.class, EntityTypes.TNT),
    FALLING_BLOCK(EntityFallingBlock.class, EntityTypes.FALLING_BLOCK),
    FIREWORK_ROCKET(EntityFireworks.class, EntityTypes.FIREWORK_ROCKET),
    SPECTRAL_ARROW(EntitySpectralArrow.class, EntityTypes.SPECTRAL_ARROW),
    SHULKER_BULLET(EntityShulkerBullet.class, EntityTypes.SHULKER_BULLET),
    DRAGON_FIREBALL(EntityDragonFireball.class, EntityTypes.DRAGON_FIREBALL),
    ARMOR_STAND(EntityArmorStand.class, EntityTypes.ARMOR_STAND),
    EVOKER_FANGS(EntityEvokerFangs.class, EntityTypes.EVOKER_FANGS),
    COMMAND_BLOCK_MINECART(EntityMinecartCommandBlock.class, EntityTypes.COMMAND_BLOCK_MINECART),
    BOAT(EntityBoat.class, EntityTypes.BOAT),
    MINECART(EntityMinecartRideable.class, EntityTypes.MINECART),
    CHEST_MINECART(EntityMinecartChest.class, EntityTypes.CHEST_MINECART),
    FURNACE_MINECART(EntityMinecartFurnace.class, EntityTypes.FURNACE_MINECART),
    TNT_MINECART(EntityMinecartTNT.class, EntityTypes.TNT_MINECART),
    HOPPER_MINECART(EntityMinecartHopper.class, EntityTypes.HOPPER_MINECART),
    SPAWNER_MINECART(EntityMinecartMobSpawner.class, EntityTypes.SPAWNER_MINECART),
    LLAMA_SPIT(EntityLlamaSpit.class, EntityTypes.LLAMA_SPIT),
    END_CRYSTAL(EntityEnderCrystal.class, EntityTypes.END_CRYSTAL);

    private final Class<? extends Entity> nmsClass;
    private final EntityTypes nmsEntityType;
    SpecialType(Class<? extends Entity> nmsClass, EntityTypes nmsEntityType)
    {
        this.nmsClass = nmsClass;
        this.nmsEntityType = nmsEntityType;
    }

    @Override
    public Class<? extends Entity> getNMSClass()
    {
        return nmsClass;
    }

    @Override
    public EntityTypes getNMSEntityType()
    {
        return nmsEntityType;
    }

    @Override
    public String getTypeName()
    {
        return name().toLowerCase();
    }
}
