package titlescrolls.impl.mixin.client;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.entity.LivingEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import titlescrolls.impl.TitleScrolls;

@Mixin(LivingEntityRenderer.class)
public class LivingEntityRendererMixin {
    @ModifyReturnValue(method = "hasLabel(Lnet/minecraft/entity/LivingEntity;)Z", at = @At("RETURN"))
    private boolean hasLabel(boolean original, LivingEntity entity) {
        if (TitleScrolls.DEBUG)
            return original || MinecraftClient.getInstance().cameraEntity == entity;
        return original;
    }
}
