package titlescrolls.api.item.component;

import com.mojang.serialization.Codec;
import net.minecraft.text.TextColor;
import net.minecraft.util.Formatting;
import titlescrolls.impl.item.component.RibbonColorComponentImpl;

public interface RibbonColorComponent {
    Codec<RibbonColorComponent> CODEC = TextColor.CODEC.xmap(RibbonColorComponentImpl::new, RibbonColorComponent::color);

    TextColor color();

    static RibbonColorComponent of(TextColor color) {
        return new RibbonColorComponentImpl(color);
    }
    static RibbonColorComponent ofRGB(int RGBColor) {
        return new RibbonColorComponentImpl(TextColor.fromRgb(RGBColor));
    }
    static RibbonColorComponent ofFormatting(Formatting formatting) {
        return new RibbonColorComponentImpl(TextColor.fromFormatting(formatting));
    }
}
