package titlescrolls.impl;

import net.fabricmc.api.ModInitializer;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import titlescrolls.api.item.TitleScrollsItems;
import titlescrolls.api.item.component.ComponentTypes;
import titlescrolls.impl.item.TitleScrollsItemsImpl;
import titlescrolls.impl.item.component.ComponentTypesImpl;
import titlescrolls.impl.item.group.TitleScrollsItemGroupsImpl;
import titlescrolls.impl.loot.TitleScrollsLootModifier;

public class TitleScrolls implements ModInitializer {
    public static final String MOD_ID = "titlescrolls";
    public static final boolean DEBUG = true;
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ComponentTypesImpl.init();
        TitleScrollsItemsImpl.init();
        TitleScrollsItemGroupsImpl.init();
        LootTableEvents.MODIFY.register(new TitleScrollsLootModifier());
    }

    public static Identifier id(String path) {
        return Identifier.of(MOD_ID, path);
    }
}