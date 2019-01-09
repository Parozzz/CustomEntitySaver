/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.parozzz.customentity.types;

import net.minecraft.server.v1_13_R2.Entity;
import net.minecraft.server.v1_13_R2.EntityTypes;
import net.minecraft.server.v1_13_R2.MinecraftKey;

/**
 * @author Paros
 */
public interface INMSType
{
    Class<? extends Entity> getNMSClass();

    EntityTypes getNMSEntityType();

    String getTypeName();

    default MinecraftKey getMinecraftKey()
    {
        return MinecraftKey.a(getTypeName());
    }
}
