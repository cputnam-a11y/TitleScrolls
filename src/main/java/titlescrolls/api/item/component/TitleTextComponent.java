package titlescrolls.api.item.component;

import com.mojang.serialization.Codec;
import net.minecraft.text.Text;
import net.minecraft.text.TextCodecs;
import titlescrolls.impl.item.component.TitleTextComponentImpl;

public interface TitleTextComponent {
    Codec<TitleTextComponent> CODEC = TextCodecs.CODEC.xmap(TitleTextComponentImpl::new, TitleTextComponent::text);

    Text text();
    static TitleTextComponent of(Text text) {
        return new TitleTextComponentImpl(text);
    }
}
