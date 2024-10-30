package titlescrolls.api.item.tag;

import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

public class TitleScrollsItemTags {
    public static final TagKey<Item> TITLE_SCROLLS = TagKey.of(RegistryKeys.ITEM, Identifier.of("trinkets", "misc/title"));
}
