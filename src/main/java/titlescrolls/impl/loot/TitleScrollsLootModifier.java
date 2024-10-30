package titlescrolls.impl.loot;

import net.fabricmc.fabric.api.loot.v3.LootTableEvents;
import net.fabricmc.fabric.api.loot.v3.LootTableSource;
import net.minecraft.component.ComponentChanges;
import net.minecraft.entity.EntityType;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.KilledByPlayerLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryWrapper;
import titlescrolls.impl.DefaultTitles;
import titlescrolls.impl.extension.SetComponentsLootFunctionExtension;
import titlescrolls.impl.item.TitleScrollsItemsImpl;


public class TitleScrollsLootModifier implements LootTableEvents.Modify {

    @Override
    public void modifyLootTable(RegistryKey<LootTable> key, LootTable.Builder tableBuilder, LootTableSource source, RegistryWrapper.WrapperLookup registries) {
        if (key.equals(EntityType.ENDER_DRAGON.getLootTableId())) {
            tableBuilder.pool(
                    createTitlePool(DefaultTitles.DRAGON_COMPONENT_CHANGES)
            );
        }
        if (key.equals(EntityType.WITHER.getLootTableId())) {
            tableBuilder.pool(
                    createTitlePool(DefaultTitles.WITHER_COMPONENT_CHANGES)
            );
        }
    }

    private static LootPool.Builder createTitlePool(ComponentChanges changes) {
        return LootPool.builder()
                .with(ItemEntry.builder(TitleScrollsItemsImpl.RARE_TITLE_SCROLL))
                .apply(
                        SetComponentsLootFunctionExtension.builder(changes)
                )
                .conditionally(KilledByPlayerLootCondition.builder());
    }
}
