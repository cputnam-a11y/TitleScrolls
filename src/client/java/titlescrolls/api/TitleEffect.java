package titlescrolls.api;

import dev.emi.trinkets.api.SlotReference;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;

@FunctionalInterface
public interface TitleEffect {
    /**
     * a no-op id effect
     */
    TitleEffect NONE = (stack, slot, matrixStack, vertexConsumer, light, model, player, headYaw, headPitch) -> {
    };

    /**
     * render an effect when a certain id is worn
     *
     * @param stack          the stack of the id scroll
     * @param slot           the slot the id is in
     * @param matrixStack    the matrixstack used to render
     * @param vertexConsumer the vertexconsumer used to render
     * @param light          the light level to render with
     * @param model          the player model
     * @param player         the player
     * @param headYaw        the player's head yaw
     * @param headPitch      the player's head pitch
     */
    void render(ItemStack stack, SlotReference slot, MatrixStack matrixStack, VertexConsumerProvider vertexConsumer, int light,
                EntityModel<? extends LivingEntity> model, LivingEntity player,
                float headYaw, float headPitch);
}
