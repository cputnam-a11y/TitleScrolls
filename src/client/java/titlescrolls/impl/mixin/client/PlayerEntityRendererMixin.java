package titlescrolls.impl.mixin.client;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.sugar.Share;
import com.llamalad7.mixinextras.sugar.ref.LocalBooleanRef;
import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketsApi;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.LightningEntityRenderer;
import net.minecraft.client.render.entity.LivingEntityRenderer;
import net.minecraft.client.render.entity.PlayerEntityRenderer;
import net.minecraft.client.render.entity.model.PlayerEntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Pair;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import titlescrolls.api.item.TitleScrollItem;
import titlescrolls.impl.TitleScrollsClient;

import java.util.List;

@Mixin(PlayerEntityRenderer.class)
public abstract class PlayerEntityRendererMixin extends LivingEntityRenderer<AbstractClientPlayerEntity, PlayerEntityModel<AbstractClientPlayerEntity>> {
    public PlayerEntityRendererMixin(EntityRendererFactory.Context ctx, PlayerEntityModel<AbstractClientPlayerEntity> model, float shadowRadius) {
        super(ctx, model, shadowRadius);
    }

    @Inject(
            method = "renderLabelIfPresent(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/text/Text;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IF)V",
            at = @At("HEAD")
    )
    private void initializeVars(AbstractClientPlayerEntity abstractClientPlayerEntity, Text text, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i, float f, CallbackInfo ci, @Share("hasScoreboard") LocalBooleanRef hasScoreboard) {
        hasScoreboard.set(false);
    }

    @Inject(
            method = "renderLabelIfPresent(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/text/Text;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/scoreboard/Scoreboard;getScore(Lnet/minecraft/scoreboard/ScoreHolder;Lnet/minecraft/scoreboard/ScoreboardObjective;)Lnet/minecraft/scoreboard/ReadableScoreboardScore;"
            )
    )
    private void injectScoreboard(AbstractClientPlayerEntity player, Text text, MatrixStack matrixStack, VertexConsumerProvider vertices, int i, float f, CallbackInfo ci, @Share("hasScoreboard") LocalBooleanRef hasScoreboard) {
        hasScoreboard.set(true);
    }

    @WrapOperation(
            method = "renderLabelIfPresent(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/text/Text;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/util/math/MatrixStack;translate(FFF)V"
            )
    )
    private void wrapTranslate(MatrixStack instance, float x, float y, float z, Operation<Void> original, @Share("hasScoreboard") LocalBooleanRef hasScoreboard) {
        if (hasScoreboard.get())
            original.call(instance, x, y + 0.07f, z);
        else
            original.call(instance, x, y, z);
    }

    @Inject(
            method = "renderLabelIfPresent(Lnet/minecraft/client/network/AbstractClientPlayerEntity;Lnet/minecraft/text/Text;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IF)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/render/entity/LivingEntityRenderer;renderLabelIfPresent(Lnet/minecraft/entity/Entity;Lnet/minecraft/text/Text;Lnet/minecraft/client/util/math/MatrixStack;Lnet/minecraft/client/render/VertexConsumerProvider;IF)V",
                    ordinal = 1
            )
    )
    private void injectTitleRenderer(AbstractClientPlayerEntity player, Text text, MatrixStack matrixStack, VertexConsumerProvider vertices, int i, float f, CallbackInfo ci) {
        List<Pair<SlotReference, ItemStack>> trinkets = TrinketsApi.getTrinketComponent(player).get().getEquipped(stack -> stack.getItem() instanceof TitleScrollItem);
        if (trinkets.isEmpty())
            return;
        ItemStack stack = trinkets.getFirst().getRight();
        Text title = ((TitleScrollItem) stack.getItem()).getTitle(stack);
        matrixStack.push();
        matrixStack.scale(0.75f, 0.75f, 0.75f);
        matrixStack.translate(0f, 0.6f, 0f);
        super.renderLabelIfPresent(player, title, matrixStack, vertices, i, f);
        matrixStack.pop();
        matrixStack.translate(0d, 0.1225d, 0d);
    }
}
