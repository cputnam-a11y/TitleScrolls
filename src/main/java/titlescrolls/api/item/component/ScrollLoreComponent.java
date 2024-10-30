package titlescrolls.api.item.component;

import com.mojang.serialization.Codec;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import titlescrolls.impl.item.component.ScrollLoreComponentImpl;

import java.util.List;

public interface ScrollLoreComponent {
    Codec<ScrollLoreComponent> CODEC = TextCodecs.CODEC.listOf().xmap(ScrollLoreComponentImpl::new, ScrollLoreComponent::lore);

    List<Text> lore();

    static ScrollLoreComponent of(List<Text> lore) {
        return new ScrollLoreComponentImpl(lore);
    }
}
