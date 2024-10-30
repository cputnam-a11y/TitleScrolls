package titlescrolls.impl;

import net.minecraft.component.ComponentChanges;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Identifier;
import titlescrolls.api.item.component.*;

import java.util.List;

public class DefaultTitles {
    public static final ComponentChanges DRAGON_COMPONENT_CHANGES = ComponentChanges
            .builder()
            .add(
                    ComponentTypes.TITLE_TEXT,
                    TitleTextComponent.of(
                            Text
                                    .translatable("title.titlescrolls.dragon_slayer")
                                    .formatted(Formatting.LIGHT_PURPLE)
                    )
            )
            .add(
                    ComponentTypes.RENDER_EFFECT,
                    RenderEffectComponent.of(
                            Identifier.of("titlescrolls:ender")
                    )
            )
            .add(
                    ComponentTypes.RIBBON_COLOR,
                    RibbonColorComponent.ofFormatting(
                            Formatting.LIGHT_PURPLE
                    )
            )
            .add(
                    ComponentTypes.SCROLL_LORE,
                    ScrollLoreComponent.of(
                            List.of(
                                    Text
                                            .translatable("text.titlescrolls.dragon_slayer.lore")
                                            .formatted(Formatting.GRAY, Formatting.ITALIC)
                            )
                    )
            )
            .add(
                    DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE,
                    true
            )
            .add(
                    DataComponentTypes.CUSTOM_NAME,
                    Text
                        .translatable("title.titlescrolls.dragon_slayer")
            )
            .build();
    public static final ComponentChanges WITHER_COMPONENT_CHANGES = ComponentChanges
            .builder()
            .add(
                    ComponentTypes.TITLE_TEXT,
                    TitleTextComponent.of(
                            Text
                                    .translatable("title.titlescrolls.ashen")
                                    .formatted(Formatting.GRAY)
                    )
            )
            .add(
                    ComponentTypes.RENDER_EFFECT,
                    RenderEffectComponent.of(
                            Identifier.of("titlescrolls:ashen")
                    )
            )
            .add(
                    ComponentTypes.RIBBON_COLOR,
                    RibbonColorComponent.ofFormatting(
                            Formatting.GRAY
                    )
            )
            .add(
                    ComponentTypes.SCROLL_LORE,
                    ScrollLoreComponent.of(
                            List.of(
                                    Text
                                            .translatable("text.titlescrolls.ashen.lore")
                                            .formatted(Formatting.GRAY, Formatting.ITALIC)
                            )
                    )
            )
            .add(
                DataComponentTypes.ENCHANTMENT_GLINT_OVERRIDE,
                true
            )
            .add(
                DataComponentTypes.CUSTOM_NAME,
                Text
                    .translatable("title.titlescrolls.ashen")
            )
            .build();
}
