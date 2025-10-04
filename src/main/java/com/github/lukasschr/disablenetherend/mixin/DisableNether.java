package com.github.lukasschr.disablenetherend.mixin;

import com.github.lukasschr.disablenetherend.DisableNetherEndEntrypoint;
import net.minecraft.block.BlockState;
import net.minecraft.block.NetherPortalBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(NetherPortalBlock.class)
public class DisableNether {
    @Inject(method = "onEntityCollision", at = @At("HEAD"), cancellable = true)
    private void onEntityCollisionMixin(
            BlockState state,
            World world,
            BlockPos pos,
            Entity entity,
            EntityCollisionHandler handler,
            CallbackInfo ci
    ) {
        if (world.getServer().getGameRules().getBoolean(DisableNetherEndEntrypoint.DISABLE_NETHER)) {
            ci.cancel();
        }
    }
}
