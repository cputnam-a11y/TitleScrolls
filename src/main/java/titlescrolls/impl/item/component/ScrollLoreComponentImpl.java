package titlescrolls.impl.item.component;

import net.minecraft.text.Text;
import titlescrolls.api.item.component.ScrollLoreComponent;

import java.util.List;

public record ScrollLoreComponentImpl(List<Text> lore) implements ScrollLoreComponent {
}
