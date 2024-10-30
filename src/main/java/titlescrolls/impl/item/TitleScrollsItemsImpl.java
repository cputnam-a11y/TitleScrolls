package titlescrolls.impl.item;

import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Rarity;
import net.minecraft.util.Unit;
import titlescrolls.api.item.TitleScrollItem;
import titlescrolls.impl.item.component.ComponentTypesImpl;


import static titlescrolls.impl.TitleScrolls.id;

public class TitleScrollsItemsImpl {
    public static final TitleScrollItemImpl BASE_TITLE_SCROLL = register("base_title_scroll", new TitleScrollItemImpl(new Item.Settings()));
    public static final TitleScrollItemImpl UNCOMMON_TITLE_SCROLL = register("uncommon_title_scroll", new TitleScrollItemImpl(new Item.Settings().rarity(Rarity.UNCOMMON)));
    public static final TitleScrollItemImpl RARE_TITLE_SCROLL = register("rare_title_scroll", new TitleScrollItemImpl(new Item.Settings().rarity(Rarity.RARE)));
    public static final TitleScrollItemImpl EPIC_TITLE_SCROLL = register("epic_title_scroll", new TitleScrollItemImpl(new Item.Settings().rarity(Rarity.EPIC)));
    public static final TitleScrollItemImpl LEGENDARY_TITLE_SCROLL = register("legendary_title_scroll", new TitleScrollItemImpl(new Item.Settings().component(ComponentTypesImpl.LEGENDARY_RARITY, Unit.INSTANCE)));

    public static <T extends Item> T register(String id, T item) {
        return Registry.register(Registries.ITEM, id(id), item);
    }

    public static void init() {
    }
}
