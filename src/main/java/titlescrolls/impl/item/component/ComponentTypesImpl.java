package titlescrolls.impl.item.component;

import com.mojang.serialization.Codec;
import net.minecraft.component.ComponentType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Unit;
import titlescrolls.api.item.component.RenderEffectComponent;
import titlescrolls.api.item.component.RibbonColorComponent;
import titlescrolls.api.item.component.ScrollLoreComponent;
import titlescrolls.api.item.component.TitleTextComponent;

import java.util.function.UnaryOperator;

import static titlescrolls.impl.TitleScrolls.id;

public class ComponentTypesImpl {
    public static final ComponentType<RenderEffectComponent> RENDER_EFFECT = register("effect", builder -> builder.codec(RenderEffectComponent.CODEC));
    public static final ComponentType<TitleTextComponent> TITLE_TEXT = register("text", builder -> builder.codec(TitleTextComponent.CODEC));
    public static final ComponentType<ScrollLoreComponent> SCROLL_LORE = register("lore", builder -> builder.codec(ScrollLoreComponent.CODEC));
    public static final ComponentType<RibbonColorComponent> RIBBON_COLOR = register("color", builder -> builder.codec(RibbonColorComponent.CODEC));
    public static final ComponentType<Unit> LEGENDARY_RARITY = register("legendary_rarity", builder -> builder.codec(Codec.unit(Unit.INSTANCE)));

    public static void init() {

    }

    private static <T> ComponentType<T> register(String id, UnaryOperator<ComponentType.Builder<T>> builderOperator) {
        return Registry.register(Registries.DATA_COMPONENT_TYPE, id(id), builderOperator.apply(ComponentType.builder()).build());
    }
}
