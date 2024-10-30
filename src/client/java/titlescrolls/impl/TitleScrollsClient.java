package titlescrolls.impl;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.client.TrinketRenderer;
import dev.emi.trinkets.api.client.TrinketRendererRegistry;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import titlescrolls.api.TitleEffectRenderer;
import titlescrolls.api.TitleEffects;
import titlescrolls.api.item.TitleScrollItem;
import titlescrolls.api.item.TitleScrollsItems;
import titlescrolls.api.item.component.ComponentTypes;
import titlescrolls.impl.item.TitleScrollsItemsImpl;

public class TitleScrollsClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ColorProviderRegistry.ITEM.register((stack, tintIndex) -> {
                    if (tintIndex == 1) return ((TitleScrollItem) stack.getItem()).getRibbonColor(stack);
                    return 0xFFFFFFFF;
                },
                TitleScrollsItemsImpl.BASE_TITLE_SCROLL,
                TitleScrollsItemsImpl.UNCOMMON_TITLE_SCROLL,
                TitleScrollsItemsImpl.RARE_TITLE_SCROLL,
                TitleScrollsItemsImpl.EPIC_TITLE_SCROLL
        );
        DefaultTitleEffects.init();
        TitleEffectRenderer renderer = new TitleEffectRendererImpl();
        TrinketRendererRegistry.registerRenderer(TitleScrollsItemsImpl.BASE_TITLE_SCROLL, renderer);
        TrinketRendererRegistry.registerRenderer(TitleScrollsItemsImpl.UNCOMMON_TITLE_SCROLL, renderer);
        TrinketRendererRegistry.registerRenderer(TitleScrollsItemsImpl.RARE_TITLE_SCROLL, renderer);
        TrinketRendererRegistry.registerRenderer(TitleScrollsItemsImpl.EPIC_TITLE_SCROLL, renderer);
    }
}