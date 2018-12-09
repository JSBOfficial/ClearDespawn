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

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderEntityItem;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.item.EntityItem;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderEntityItemExtended extends RenderEntityItem {

    public static Factory FACTORY = new Factory();

    public RenderEntityItemExtended(RenderManager renderManagerIn, RenderItem renderItem) {
        super(renderManagerIn, renderItem);
    }

    @Override
    public void doRender(EntityItem entity, double x, double y, double z, float entityYaw, float partialTicks) {
        int remainingTime = entity.lifespan - entity.getAge();

        if (remainingTime <= ConfigHandler.timeFlash * 20) {

            if (ConfigHandler.urgentFlash) {
                int flashFactor = Math.max(2, remainingTime / 20);

                if (remainingTime % (flashFactor) < 0.5f * flashFactor) {
                    return;
                }
            } else if (remainingTime % 20 < 10) {
                return;
            }
        }
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    public static class Factory implements IRenderFactory<EntityItem> {

        @Override
        public Render<? super EntityItem> createRenderFor(RenderManager manager) {
            return new RenderEntityItemExtended(manager, Minecraft.getMinecraft().getRenderItem());
        }
    }
}
