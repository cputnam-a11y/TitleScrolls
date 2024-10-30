package titlescrolls.api.item.component;

import com.mojang.serialization.Codec;
import net.minecraft.util.Identifier;
import titlescrolls.impl.item.component.RenderEffectComponentImpl;

public interface RenderEffectComponent {
    Codec<RenderEffectComponent> CODEC = Identifier.CODEC.xmap(RenderEffectComponentImpl::new, RenderEffectComponent::effect);

    Identifier effect();

    static RenderEffectComponent of(Identifier effect) {
        return new RenderEffectComponentImpl(effect);
    }
}
