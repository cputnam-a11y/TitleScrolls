package titlescrolls.impl;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import titlescrolls.api.TitleEffectRenderer;
import titlescrolls.api.TitleEffects;
import titlescrolls.api.item.component.ComponentTypes;

public class TitleEffectRendererImpl implements TitleEffectRenderer {
    @Override
    public void renderTitleEffect(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        if (stack.contains(ComponentTypes.RENDER_EFFECT)) {
            Identifier effect = stack.get(ComponentTypes.RENDER_EFFECT).effect();
            TitleEffects
                    .INSTANCE
                    .getEffect(effect)
                    .render(stack, slotReference, matrices,
                            vertexConsumers, light, contextModel,
                            entity, headYaw, headPitch);
        }
    }

    @Override
    public void render(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity, float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw, float headPitch) {
        this.renderTitleEffect(stack, slotReference, contextModel, matrices, vertexConsumers, light, entity, limbAngle, limbDistance, tickDelta, animationProgress, headYaw, headPitch);
    }
}
