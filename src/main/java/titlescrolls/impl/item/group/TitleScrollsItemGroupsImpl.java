package titlescrolls.impl.item.group;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import titlescrolls.impl.DefaultTitles;
import titlescrolls.impl.item.TitleScrollsItemsImpl;

public class TitleScrollsItemGroupsImpl {
    static {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.INGREDIENTS).register((entries) -> {
            entries.add(TitleScrollsItemsImpl.BASE_TITLE_SCROLL);
            entries.add(TitleScrollsItemsImpl.UNCOMMON_TITLE_SCROLL);
            entries.add(TitleScrollsItemsImpl.RARE_TITLE_SCROLL);
            ItemStack dragonTitleScroll = new ItemStack(TitleScrollsItemsImpl.EPIC_TITLE_SCROLL);
            dragonTitleScroll.applyChanges(DefaultTitles.DRAGON_COMPONENT_CHANGES);
            entries.add(dragonTitleScroll);
            ItemStack witherTitleScroll = new ItemStack(TitleScrollsItemsImpl.RARE_TITLE_SCROLL);
            witherTitleScroll.applyChanges(DefaultTitles.WITHER_COMPONENT_CHANGES);
            entries.add(witherTitleScroll);
            entries.add(TitleScrollsItemsImpl.EPIC_TITLE_SCROLL);
            entries.add(TitleScrollsItemsImpl.LEGENDARY_TITLE_SCROLL);
        });
    }
    public static void init() {}
}
