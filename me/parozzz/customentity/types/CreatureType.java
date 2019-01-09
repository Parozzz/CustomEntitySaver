/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.parozzz.customentity.types;

import me.parozzz.customentity.NMSMobMeta;
import net.minecraft.server.v1_13_R2.*;
import org.apache.commons.lang3.Validate;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.World;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;
import org.bukkit.entity.*;

import javax.annotation.Nullable;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

/**
 * @author Paros
 */
@SuppressWarnings("unchecked")
public final class CreatureType<BKT extends Mob, NMS extends EntityInsentient> implements INMSType
{

    // ++++++++++++++++++++++ ILLAGERS ++++++++++++++++++++++
    public static final CreatureType<Evoker, EntityEvoker> EVOKER = get(Evoker.class, EntityEvoker.class, EntityTypes.EVOKER, NMSMobMeta.MONSTER);
    public static final CreatureType<Vindicator, EntityVindicator> VINDICATOR = get(Vindicator.class, EntityVindicator.class, EntityTypes.VINDICATOR, NMSMobMeta.MONSTER);
    public static final CreatureType<Illusioner, EntityIllagerIllusioner> ILLUSIONER = get(Illusioner.class, EntityIllagerIllusioner.class, EntityTypes.ILLUSIONER, NMSMobMeta.MONSTER);
    // ++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++++++ SKELETONS ++++++++++++++++++++++
    public static final CreatureType<Skeleton, EntitySkeleton> SKELETON = get(Skeleton.class, EntitySkeleton.class, EntityTypes.SKELETON, NMSMobMeta.MONSTER);

    public static final CreatureType<Stray, EntitySkeletonStray> STRAY = get(Stray.class, EntitySkeletonStray.class, EntityTypes.STRAY, NMSMobMeta.MONSTER
    );

    public static final CreatureType<WitherSkeleton, EntitySkeletonWither> WITHER_SKELETON = get(WitherSkeleton.class, EntitySkeletonWither.class,
            EntityTypes.WITHER_SKELETON, NMSMobMeta.MONSTER);
    // ++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++++++ SPIDERS ++++++++++++++++++++++
    public static final CreatureType<Spider, EntitySpider> SPIDER = get(Spider.class, EntitySpider.class, EntityTypes.SPIDER, NMSMobMeta.MONSTER
    );

    public static final CreatureType<CaveSpider, EntityCaveSpider> CAVE_SPIDER = get(CaveSpider.class, EntityCaveSpider.class, EntityTypes.CAVE_SPIDER,
            NMSMobMeta.MONSTER
    );
    // ++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++++++ ZOMBIES ++++++++++++++++++++++
    public static final CreatureType<Zombie, EntityZombie> ZOMBIE = get(Zombie.class, EntityZombie.class, EntityTypes.ZOMBIE, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Husk, EntityZombieHusk> HUSK = get(Husk.class, EntityZombieHusk.class, EntityTypes.HUSK, NMSMobMeta.MONSTER
    );

    public static final CreatureType<ZombieVillager, EntityZombieVillager> ZOMBIE_VILLAGER = get(ZombieVillager.class, EntityZombieVillager.class,
            EntityTypes.ZOMBIE_VILLAGER, NMSMobMeta.MONSTER);

    public static final CreatureType<PigZombie, EntityPigZombie> ZOMBIE_PIGMAN = get(PigZombie.class, EntityPigZombie.class, EntityTypes.ZOMBIE_PIGMAN,
            NMSMobMeta.MONSTER);

    public static final CreatureType<Giant, EntityGiantZombie> GIANT = get(Giant.class, EntityGiantZombie.class, EntityTypes.GIANT, NMSMobMeta.MONSTER
    );
    // ++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++++++ SLIMES ++++++++++++++++++++++
    public static final CreatureType<Slime, EntitySlime> SLIME = get(Slime.class, EntitySlime.class, EntityTypes.SLIME, NMSMobMeta.MONSTER
    );

    public static final CreatureType<MagmaCube, EntityMagmaCube> MAGMA_CUBE = get(MagmaCube.class, EntityMagmaCube.class, EntityTypes.MAGMA_CUBE, NMSMobMeta.MONSTER
    );
    // ++++++++++++++++++++++++++++++++++++++++++++

    public static final CreatureType<Ghast, EntityGhast> GHAST = get(Ghast.class, EntityGhast.class, EntityTypes.GHAST, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Enderman, EntityEnderman> ENDERMAN = get(Enderman.class, EntityEnderman.class, EntityTypes.ENDERMAN, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Enderman, EntitySilverfish> SILVERFISH = get(Silverfish.class, EntitySilverfish.class, EntityTypes.SILVERFISH, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Blaze, EntityBlaze> BLAZE = get(Blaze.class, EntityBlaze.class, EntityTypes.BLAZE, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Witch, EntityWitch> WITCH = get(Witch.class, EntityWitch.class, EntityTypes.WITCH, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Endermite, EntityEndermite> ENDERMITE = get(Endermite.class, EntityEndermite.class, EntityTypes.ENDERMITE, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Vex, EntityVex> VEX = get(Vex.class, EntityVex.class, EntityTypes.VEX, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Creeper, EntityCreeper> CREEPER = get(Creeper.class, EntityCreeper.class, EntityTypes.CREEPER, NMSMobMeta.MONSTER
    );

    // ++++++++++++++++++++++ GUARDIANS ++++++++++++++++++++++
    public static final CreatureType<Guardian, EntityGuardian> GUARDIAN = get(Guardian.class, EntityGuardian.class, EntityTypes.GUARDIAN, NMSMobMeta.MONSTER
    );

    public static final CreatureType<ElderGuardian, EntityGuardianElder> ELDER_GUARDIAN = get(ElderGuardian.class, EntityGuardianElder.class, EntityTypes.ELDER_GUARDIAN,
            NMSMobMeta.MONSTER);
    // ++++++++++++++++++++++++++++++++++++++++++++

    public static final CreatureType<Shulker, EntityShulker> SHULKER = get(Shulker.class, EntityShulker.class, EntityTypes.SHULKER, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Bat, EntityBat> BAT = get(Bat.class, EntityBat.class, EntityTypes.BAT, NMSMobMeta.AMBIENT
    );

    public static final CreatureType<Pig, EntityPig> PIG = get(Pig.class, EntityPig.class, EntityTypes.PIG, NMSMobMeta.CREATURE
    );

    public static final CreatureType<Sheep, EntitySheep> SHEEP = get(Sheep.class, EntitySheep.class, EntityTypes.SHEEP, NMSMobMeta.CREATURE
    );

    // ++++++++++++++++++++++ COWS ++++++++++++++++++++++
    public static final CreatureType<Cow, EntityCow> COW = get(Cow.class, EntityCow.class, EntityTypes.COW, NMSMobMeta.CREATURE
    );

    public static final CreatureType<MushroomCow, EntityMushroomCow> MOOSHROOM = get(MushroomCow.class, EntityMushroomCow.class, EntityTypes.MOOSHROOM,
            NMSMobMeta.CREATURE);

    // ++++++++++++++++++++++++++++++++++++++++++++

    public static final CreatureType<Chicken, EntityChicken> CHICKEN = get(Chicken.class, EntityChicken.class, EntityTypes.CHICKEN, NMSMobMeta.CREATURE
    );

    public static final CreatureType<Squid, EntitySquid> SQUID = get(Squid.class, EntitySquid.class, EntityTypes.SQUID, NMSMobMeta.WATER_CREATURE
    );

    public static final CreatureType<Wolf, EntityWolf> WOLF = get(Wolf.class, EntityWolf.class, EntityTypes.WOLF, NMSMobMeta.CREATURE
    );

    public static final CreatureType<Ocelot, EntityOcelot> OCELOT = get(Ocelot.class, EntityOcelot.class, EntityTypes.OCELOT, NMSMobMeta.CREATURE
    );

    // ++++++++++++++++++++++ GOLEMS ++++++++++++++++++++++
    public static final CreatureType<IronGolem, EntityIronGolem> IRON_GOLEM = get(IronGolem.class, EntityIronGolem.class, EntityTypes.IRON_GOLEM, NMSMobMeta.CREATURE
    );

    public static final CreatureType<Snowman, EntitySnowman> SNOW_GOLEM = get(Snowman.class, EntitySnowman.class, EntityTypes.SNOW_GOLEM, NMSMobMeta.CREATURE
    );
    // ++++++++++++++++++++++++++++++++++++++++++++

    // ++++++++++++++++++++++ HORSES ++++++++++++++++++++++
    public static final CreatureType<Horse, EntityHorse> HORSE = get(Horse.class, EntityHorse.class, EntityTypes.HORSE, NMSMobMeta.CREATURE
    );

    public static final CreatureType<SkeletonHorse, EntityHorseSkeleton> SKELETON_HORSE = get(SkeletonHorse.class, EntityHorseSkeleton.class, EntityTypes.SKELETON_HORSE,
            NMSMobMeta.CREATURE);

    public static final CreatureType<ZombieHorse, EntityHorseZombie> ZOMBIE_HORSE = get(ZombieHorse.class, EntityHorseZombie.class, EntityTypes.ZOMBIE_HORSE,
            NMSMobMeta.CREATURE);

    public static final CreatureType<Donkey, EntityHorseDonkey> DONKEY = get(Donkey.class, EntityHorseDonkey.class, EntityTypes.DONKEY, NMSMobMeta.CREATURE
    );

    public static final CreatureType<Mule, EntityHorseMule> MULE = get(Mule.class, EntityHorseMule.class, EntityTypes.MULE, NMSMobMeta.CREATURE
    );

    public static final CreatureType<Llama, EntityLlama> LLAMA = get(Llama.class, EntityLlama.class, EntityTypes.LLAMA, NMSMobMeta.CREATURE
    );
    // ++++++++++++++++++++++++++++++++++++++++++++

    public static final CreatureType<Rabbit, EntityRabbit> RABBIT = get(Rabbit.class, EntityRabbit.class, EntityTypes.RABBIT, NMSMobMeta.CREATURE
    );

    public static final CreatureType<PolarBear, EntityPolarBear> POLAR_BEAR = get(PolarBear.class, EntityPolarBear.class, EntityTypes.POLAR_BEAR, NMSMobMeta.CREATURE
    );

    public static final CreatureType<Parrot, EntityParrot> PARROT = get(Parrot.class, EntityParrot.class, EntityTypes.PARROT, NMSMobMeta.CREATURE
    );

    public static final CreatureType<Villager, EntityVillager> VILLAGER = get(Villager.class, EntityVillager.class, EntityTypes.VILLAGER, NMSMobMeta.CREATURE
    );

    // ++++++++++++++++++++++ BOSSES ++++++++++++++++++++++
    public static final CreatureType<EnderDragon, EntityEnderDragon> ENDER_DRAGON = get(EnderDragon.class, EntityEnderDragon.class, EntityTypes.ENDER_DRAGON,
            NMSMobMeta.MONSTER);

    public static final CreatureType<Wither, EntityWither> WITHER = get(Wither.class, EntityWither.class, EntityTypes.WITHER, NMSMobMeta.MONSTER
    );
    // ++++++++++++++++++++++++++++++++++++++++++++

    //1.13 Mobs
    public static final CreatureType<Dolphin, EntityDolphin> DOLPHIN = get(Dolphin.class, EntityDolphin.class, EntityTypes.DOLPHIN, NMSMobMeta.WATER_CREATURE
    );

    public static final CreatureType<Drowned, EntityDrowned> DROWNED = get(Drowned.class, EntityDrowned.class, EntityTypes.DROWNED, NMSMobMeta.WATER_CREATURE
    );

    // ++++++++++++++++++++++ FISHES ++++++++++++++++++++++
    public static final CreatureType<Cod, EntityCod> COD = get(Cod.class, EntityCod.class, EntityTypes.COD, NMSMobMeta.WATER_CREATURE
    );

    public static final CreatureType<Salmon, EntitySalmon> SALMON = get(Salmon.class, EntitySalmon.class, EntityTypes.SALMON, NMSMobMeta.WATER_CREATURE
    );

    public static final CreatureType<PufferFish, EntityPufferFish> PUFFERFISH = get(PufferFish.class, EntityPufferFish.class, EntityTypes.PUFFERFISH,
            NMSMobMeta.WATER_CREATURE);

    public static final CreatureType<TropicalFish, EntityTropicalFish> TROPICAL_FISH = get(TropicalFish.class, EntityTropicalFish.class, EntityTypes.TROPICAL_FISH,
            NMSMobMeta.WATER_CREATURE);
    // ++++++++++++++++++++++++++++++++++++++++++++

    public static final CreatureType<Phantom, EntityPhantom> PHANTOM = get(Phantom.class, EntityPhantom.class, EntityTypes.PHANTOM, NMSMobMeta.MONSTER
    );

    public static final CreatureType<Turtle, EntityTurtle> TURTLE = get(Turtle.class, EntityTurtle.class, EntityTypes.TURTLE, NMSMobMeta.CREATURE
    );

    private static Map<EntityType, CreatureType> ENTITY_TYPE_MAP;
    private static Map<String, CreatureType> NAME_MAP;

    private static <T extends Mob, H extends EntityInsentient> CreatureType get(Class<T> bukkitClass, Class<H> nmsClass, EntityTypes<H> nmsEntityType, NMSMobMeta mobMeta)
    {
        if(ENTITY_TYPE_MAP == null)
        {
            ENTITY_TYPE_MAP = new EnumMap<>(EntityType.class);
        }

        if(NAME_MAP == null)
        {
            NAME_MAP = new HashMap<>();
        }

        var type = new CreatureType<>(bukkitClass, nmsClass, nmsEntityType, mobMeta);

        var entityType = EntityTypes.clsToTypeMap.get(nmsClass);
        if(entityType == null)
        {
            Logger.getLogger(CreatureType.class.getName()).warning("Something went wrong while creating a CreatureType. No corresponding bukkit EntityType?");
        }
        else
        {
            type.setBukkitEntityType(entityType);

            ENTITY_TYPE_MAP.put(entityType, type);
            NAME_MAP.put(entityType.name().toLowerCase(), type);
        }

        return type;
    }

    public static CreatureType getByEntityType(final EntityType et)
    {
        return ENTITY_TYPE_MAP.get(et);
    }

    @Nullable
    public static CreatureType valueOf(String name)
    {
        return NAME_MAP.get(Validate.notNull(name).toLowerCase());
    }

    @Nullable
    public static CreatureType valueOf(NamespacedKey key)
    {
        return valueOf(key.getKey());
    }

    @Nullable
    public static CreatureType valueOf(MinecraftKey key)
    {
        return valueOf(key.getKey());
    }

    public static List<CreatureType> values()
    {
        return List.copyOf(NAME_MAP.values());
    }

    private final Class<NMS> nmsClass;
    private final EntityTypes<NMS> nmsEntityType;
    private final NMSMobMeta mobMeta;

    private final Class<BKT> bukkitClass;
    @Nullable
    private EntityType bukkitEntityType;

    @Nullable
    private String name;

    private CreatureType(Class<BKT> bukkitClass, Class<NMS> nmsClass, EntityTypes<NMS> nmsEntityType, NMSMobMeta mobMeta)
    {
        this.nmsClass = nmsClass;
        this.nmsEntityType = nmsEntityType;
        this.mobMeta = mobMeta;

        this.bukkitClass = bukkitClass;
    }

    private void setBukkitEntityType(EntityType entityType)
    {
        this.bukkitEntityType = Validate.notNull(entityType);
        this.name = bukkitEntityType.name().toLowerCase();
    }

    public String name()
    {
        return name;
    }

    @Override
    public String getTypeName()
    {
        return name;
    }

    @Override
    public Class<NMS> getNMSClass()
    {
        return nmsClass;
    }

    @Override
    public EntityTypes<NMS> getNMSEntityType()
    {
        return nmsEntityType;
    }

    public Class<BKT> getBukkitClass()
    {
        return bukkitClass;
    }

    public EntityType getBukkitEntityType()
    {
        return bukkitEntityType;
    }

    public NMSMobMeta getMobMeta()
    {
        return mobMeta;
    }

    public NMS spawnNMS(World world, @Nullable Location loc)
    {
        var nmsEntity = spawnNMS(world);
        if(loc != null && nmsEntity != null)
        {
            nmsEntity.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
        }

        return nmsEntity;
    }

    public NMS spawnNMS(World world)
    {
        return nmsEntityType.create(((CraftWorld) world).getHandle());
    }

    public BKT spawnBukkit(World world, @Nullable Location loc)
    {
        var nms = spawnNMS(world, loc);
        return (BKT) nms.getBukkitEntity();
    }
}
