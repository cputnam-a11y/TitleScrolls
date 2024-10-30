package titlescrolls.impl;

import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import titlescrolls.api.TitleEffect;
import titlescrolls.api.TitleEffects;

public class DefaultTitleEffects {
    static {
        TitleEffects.INSTANCE.registerEffect(Identifier.of(TitleScrolls.MOD_ID, "none"), TitleEffect.NONE);
        TitleEffects.INSTANCE.registerEffect(Identifier.of(TitleScrolls.MOD_ID, "ender"),
                ((stack, slot, matrixStack, vertexConsumer, light, model, player, headYaw, headPitch) ->
                        player.getWorld().addParticle(ParticleTypes.PORTAL, player.getParticleX(0.5D),
                                player.getRandomBodyY() - 0.25D, player.getParticleZ(0.5D),
                                (player.getRandom().nextDouble() - 0.5D) * 2.0D,
                                -player.getRandom().nextDouble(),
                                (player.getRandom().nextDouble() - 0.5D) * 2.0D)
                )
        );
        TitleEffects.INSTANCE.registerEffect(Identifier.of(TitleScrolls.MOD_ID, "ashen"),
                ((stack, slot, matrixStack, vertexConsumer, light, model, player, headYaw, headPitch) ->
                        player.getWorld().addParticle(ParticleTypes.ASH, player.getParticleX(0.5D),
                                player.getRandomBodyY() - 0.25D, player.getParticleZ(0.5D),
                                (player.getRandom().nextDouble() - 0.5D) * 2.0D,
                                -player.getRandom().nextDouble(),
                                (player.getRandom().nextDouble() - 0.5D) * 2.0D)
                )
        );
        //no-op because the player render mixin does it
        TitleEffects.INSTANCE.registerEffect(Identifier.of(TitleScrolls.MOD_ID, "phosphor"), TitleEffect.NONE);
    }
    public static void init() {

    }
}
