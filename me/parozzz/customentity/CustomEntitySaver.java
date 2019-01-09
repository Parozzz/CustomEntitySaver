package me.parozzz.customentity;

import com.mojang.datafixers.DataFixUtils;
import com.mojang.datafixers.types.Type;
import me.parozzz.customentity.types.CreatureType;
import me.parozzz.customentity.types.INMSType;
import net.minecraft.server.v1_13_R2.*;
import org.apache.commons.lang3.Validate;
import org.bukkit.block.Biome;

import javax.annotation.Nullable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.logging.Logger;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CustomEntitySaver
{

    private static final Field POSITION_MAP_FIELD = getField(EntityPositionTypes.class, "a");

    private static Field getField(Class<?> clazz, String name)
    {
        try {
            return clazz.getDeclaredField(name);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static Object validateField(Field field, Object instance)
    {
        try {
            return POSITION_MAP_FIELD.get(instance);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Makes the mob spawn randomly around the world just like vanilla mobs.
     * <p>
     * Unlike the other method, this allows you to choose the 'category' of your mob; Creature, Monster, Ambient or Water Creature - even if it in reality was none of those.
     * <p>
     * If you're using a custom entity class, remember to <b>registerCustomEntity</b> it before using this! Otherwise it'll not be rendered by the client.
     * <p>
     *
     * @param data - The spawn data (chance, amount, spawn weight..)
     * @return If the entity SpawnData has been added with success
     */
    public static void addRandomSpawn(final SpawnData data, final Biome... biomes)
    {
        for (var biomeBase : Stream.of(biomes).map(Biome::name).map(String::toLowerCase).map(MinecraftKey::a).map(IRegistry.BIOME::get).toArray(BiomeBase[]::new)) {
            var metaList = biomeBase.getMobs(data.getCreatureType().getMobMeta().getNMSCreatureType());
            if (metaList != null) {
                metaList.add(data);
            }
        }
    }

    public static <T extends Entity> CustomEntityType<T> registerEntity(String name, INMSType type, Class<T> customClass, Function<World, T> spawnFunction)
    {
        return registerEntity(name, type, customClass, spawnFunction, false);
    }

    @SuppressWarnings("unchecked")
    @Nullable
    public static <T extends Entity> CustomEntityType<T> registerEntity(String name, INMSType type, Class<T> customClass, Function<World, T> spawnFunction, boolean overrideSpawn)
    {
        //Creating a minecraft key with the name
        var customEntityKey = MinecraftKey.a(name);
        Validate.notNull(customEntityKey, "Using an invalid name for registering a custom entity. Name: ", name);

        if (IRegistry.ENTITY_TYPE.c(customEntityKey)) {
            Logger.getLogger(CustomEntitySaver.class.getName()).warning("An entity named " + name + " already exists.");
            return null;
        }

        //Getting the data converter type for the default entity and adding that to the custom mob.
        var typeMap = (Map<Object, Type<?>>) DataConverterRegistry.a().getSchema(DataFixUtils.makeKey(1628)).findChoiceType(DataConverterTypes.n).types();
        typeMap.put(customEntityKey.toString(), typeMap.get(type.getMinecraftKey().toString()));

        var customEntityNMSEntityType = EntityTypes.a(name, EntityTypes.a.a(customClass, spawnFunction));

        //Is an insentient entity? Also copy the EntityPositionTypes value.
        if (customClass.isAssignableFrom(EntityInsentient.class)) {
            var positionMap = (Map<EntityTypes<?>, Object>) validateField(POSITION_MAP_FIELD, null);
            if (positionMap != null) {
                var entityInformation = positionMap.get(type.getNMSEntityType());
                positionMap.put(customEntityNMSEntityType, entityInformation);
            }
        }

        //Do you want to overidde spawn and is a creature?
        if (type instanceof CreatureType && overrideSpawn) {
            //The get nms EnumCreatureType, and override and biome spawn list in which the default mob is contained and replacing it.
            var nmsCreatureType = ((CreatureType) type).getMobMeta().getNMSCreatureType();
            StreamSupport.stream(IRegistry.BIOME.spliterator(), false)
                    .map(base -> base.getMobs(nmsCreatureType))
                    .filter(Objects::nonNull)
                    .flatMap(List::stream)
                    .filter(meta -> meta.b == type.getNMSEntityType())
                    .forEach(meta -> meta.b = (EntityTypes<? extends EntityInsentient>) customEntityNMSEntityType);
        }


        //This is just a wrapper which contains the class and nms EntityTypes.
        return new CustomEntityType<>(customClass, customEntityNMSEntityType);
    }

    public static class SpawnData extends BiomeBase.BiomeMeta
    {
        private final CreatureType creatureType;

        public SpawnData(CreatureType<?, ? extends EntityInsentient> creatureType, int spawnWeight, int minSpawns, int maxSpawns)
        {
            super(creatureType.getNMSEntityType(), spawnWeight, minSpawns, maxSpawns);

            this.creatureType = creatureType;
        }

        public CreatureType getCreatureType()
        {
            return creatureType;
        }

        public EntityTypes getNMSEntityType()
        {
            return b;
        }

        public int getSpawnWeight()
        {
            return a;
        }

        public int getMinSpawns()
        {
            return c;
        }

        public int getMaxSpawns()
        {
            return d;
        }
    }

}
