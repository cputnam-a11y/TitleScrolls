package titlescrolls.impl.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import titlescrolls.impl.item.TitleScrollsItemsImpl;
import titlescrolls.api.item.tag.TitleScrollsItemTags;

import java.util.concurrent.CompletableFuture;

public class TitleScrollsItemTagProvider extends FabricTagProvider.ItemTagProvider {
    public TitleScrollsItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> completableFuture) {
        super(output, completableFuture, null);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getOrCreateTagBuilder(TitleScrollsItemTags.TITLE_SCROLLS)
                .add(
                        TitleScrollsItemsImpl.BASE_TITLE_SCROLL,
                        TitleScrollsItemsImpl.EPIC_TITLE_SCROLL,
                        TitleScrollsItemsImpl.UNCOMMON_TITLE_SCROLL,
                        TitleScrollsItemsImpl.RARE_TITLE_SCROLL
                );
    }
}
