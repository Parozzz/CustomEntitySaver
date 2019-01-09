package me.parozzz.customentity;

import me.parozzz.customentity.types.CreatureType;
import net.minecraft.server.v1_13_R2.EntityPig;
import net.minecraft.server.v1_13_R2.EntityTypes;
import net.minecraft.server.v1_13_R2.World;

public final class ExampleCustomEntity extends EntityPig
{
    private static CustomEntityType<ExampleCustomEntity> entityTypes;
    public static void register()
    {
        entityTypes = CustomEntitySaver.registerEntity("example_custom_pug", CreatureType.PIG, ExampleCustomEntity.class, ExampleCustomEntity::new, true);
    }

    public ExampleCustomEntity(World world)
    {
        super(world);
    }

    public EntityTypes getEntityType()
    {
        return entityTypes.getNMSEntityTypes();
    }
}
