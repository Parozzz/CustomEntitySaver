package me.parozzz.customentity;

import net.minecraft.server.v1_13_R2.Entity;
import net.minecraft.server.v1_13_R2.EntityTypes;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_13_R2.CraftWorld;

public class CustomEntityType<T extends Entity>
{
    private final Class<T> entityClass;
    private final EntityTypes<T> nmsEntityTypes;

    public CustomEntityType(Class<T> entityClass, EntityTypes<T> nmsEntityTypes)
    {
        this.entityClass = entityClass;
        this.nmsEntityTypes = nmsEntityTypes;
    }

    public Class<T> getEntityClass()
    {
        return entityClass;
    }

    public EntityTypes<T> getNMSEntityTypes()
    {
        return nmsEntityTypes;
    }

    public T spawn(org.bukkit.World world)
    {
        var nmsWorld = ((CraftWorld)world).getHandle();
        return nmsEntityTypes.a(nmsWorld);
    }

    public T spawn(Location loc)
    {
        var nmsEntity = spawn(loc.getWorld());
        nmsEntity.setPosition(loc.getX(), loc.getY(), loc.getZ());
        return nmsEntity;
    }

}
