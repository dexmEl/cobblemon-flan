package com.eclipse.cobblemon.flan.mixin;

import com.cobblemon.mod.common.entity.pokeball.EmptyPokeBallEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.util.hit.HitResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

in(targets = "io.github.flemmli97.flan.event.EntityInteractEvents", remap = false)
public class FlanPokeBallProjectileMixin {

    @Inject(method = "projectileHit", at = @At("HEAD"), cancellable = true, remap = false)
    private static void cobblemonFlan$ignorePokeBalls(ProjectileEntity proj, HitResult res, CallbackInfoReturnable<Boolean> cir) {
        if (proj instanceof EmptyPokeBallEntity) {
            cir.setReturnValue(false);
        }
    }
}
