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

package c4.cleardespawn.core;

import c4.cleardespawn.ClearDespawn;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.ConfigManager;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Config(modid = ClearDespawn.MODID)
public class ConfigHandler {

    @Config.Name("Time for Flashing")
    @Config.Comment("The number of seconds the item has left before despawn to start flashing")
    public static int timeFlash = 20;

    @Config.Name("Urgent Flashing")
    @Config.Comment("Set to true to have the item flash faster as it gets closer to despawning")
    public static boolean urgentFlash = true;

    @Mod.EventBusSubscriber(modid = ClearDespawn.MODID)
    private static class ConfigEventHandler {

        @SubscribeEvent
        public static void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent evt) {
            if (evt.getModID().equals(ClearDespawn.MODID)) {
                ConfigManager.sync(ClearDespawn.MODID, Config.Type.INSTANCE);
            }
        }
    }
}
