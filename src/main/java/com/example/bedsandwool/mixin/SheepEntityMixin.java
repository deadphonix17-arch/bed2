package com.example.bedsandwool.mixin;

import com.example.bedsandwool.BedsAndWoolMod;
import net.minecraft.entity.passive.SheepEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(SheepEntity.class)
public abstract class SheepEntityMixin {

    // mobTick only runs on the server, so no side check is needed.
    @Inject(method = "mobTick", at = @At("TAIL"))
    private void bedsandwool$fastWool(CallbackInfo ci) {
        SheepEntity sheep = (SheepEntity) (Object) this;
        if (sheep.isSheared()
                && !sheep.isBaby()
                && sheep.age % BedsAndWoolMod.WOOL_REGROW_INTERVAL_TICKS == 0) {
            sheep.setSheared(false);
        }
    }
}
