package titlescrolls.api;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

public interface TitleEffectRenderer extends TrinketRenderer {
    void renderTitleEffect(ItemStack stack, SlotReference slotReference, EntityModel<? extends LivingEntity> contextModel,
                MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, LivingEntity entity,
                float limbAngle, float limbDistance, float tickDelta, float animationProgress, float headYaw,
                float headPitch);
}
