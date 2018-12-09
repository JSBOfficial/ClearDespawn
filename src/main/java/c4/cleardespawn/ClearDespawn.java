/*
 * Copyright (C) 2018  C4
 *
 * This file is part of Clear Despawn, a mod made for Minecraft.
 *
 * Clear Despawn is free software: you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as published
 * by the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Clear Despawn is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with Clear Despawn.  If not, see <https://www.gnu.org/licenses/>.
 */

package c4.cleardespawn;

import c4.cleardespawn.core.RenderEntityItemExtended;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(   modid = ClearDespawn.MODID,
        name = ClearDespawn.NAME,
        version = "@VERSION@",
        dependencies = "required-after:forge@[14.23.5.2768,)",
        acceptedMinecraftVersions = "[1.12, 1.13)",
        certificateFingerprint = "@FINGERPRINT@",
        clientSideOnly = true)
public class ClearDespawn {

    public static final String MODID = "cleardespawn";
    public static final String NAME = "Clear Despawn";

    @EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
        RenderingRegistry.registerEntityRenderingHandler(EntityItem.class, RenderEntityItemExtended.FACTORY);
    }
}
