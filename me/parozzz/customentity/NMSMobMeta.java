package me.parozzz.customentity;

import net.minecraft.server.v1_13_R2.EnumCreatureType;

public enum  NMSMobMeta
{
    MONSTER(EnumCreatureType.MONSTER),
    CREATURE(EnumCreatureType.CREATURE),
    WATER_CREATURE(EnumCreatureType.WATER_CREATURE),
    AMBIENT(EnumCreatureType.AMBIENT);

    private final EnumCreatureType nmsCreatureType;

    NMSMobMeta(final EnumCreatureType nmsCreatureType)
    {
        this.nmsCreatureType = nmsCreatureType;
    }

    public EnumCreatureType getNMSCreatureType()
    {
        return nmsCreatureType;
    }
}
