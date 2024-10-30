package titlescrolls.api.item.component;

import net.minecraft.component.ComponentType;
import net.minecraft.util.Unit;
import titlescrolls.impl.item.component.ComponentTypesImpl;

public class ComponentTypes {
    public static final ComponentType<RenderEffectComponent> RENDER_EFFECT = ComponentTypesImpl.RENDER_EFFECT;
    public static final ComponentType<TitleTextComponent> TITLE_TEXT = ComponentTypesImpl.TITLE_TEXT;
    public static final ComponentType<ScrollLoreComponent> SCROLL_LORE = ComponentTypesImpl.SCROLL_LORE;
    public static final ComponentType<RibbonColorComponent> RIBBON_COLOR = ComponentTypesImpl.RIBBON_COLOR;
    public static final ComponentType<Unit> LEGENDARY_RARITY = ComponentTypesImpl.LEGENDARY_RARITY;
}
