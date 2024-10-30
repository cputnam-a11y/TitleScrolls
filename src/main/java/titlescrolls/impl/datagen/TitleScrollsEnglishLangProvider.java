package titlescrolls.impl.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;
import titlescrolls.impl.item.TitleScrollsItemsImpl;

import java.util.concurrent.CompletableFuture;

public class TitleScrollsEnglishLangProvider extends FabricLanguageProvider {
    protected TitleScrollsEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput,"en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder translationBuilder) {
        translationBuilder.add(TitleScrollsItemsImpl.BASE_TITLE_SCROLL, "Title Scroll");
        translationBuilder.add(TitleScrollsItemsImpl.UNCOMMON_TITLE_SCROLL, "Uncommon Title Scroll");
        translationBuilder.add(TitleScrollsItemsImpl.RARE_TITLE_SCROLL, "Rare Title Scroll");
        translationBuilder.add(TitleScrollsItemsImpl.EPIC_TITLE_SCROLL, "Epic Title Scroll");
        translationBuilder.add(TitleScrollsItemsImpl.LEGENDARY_TITLE_SCROLL, "Legendary Title Scroll");
        translationBuilder.add(message("rename"), "  Rename to set title");
        translationBuilder.add(lore("ashen"), "  Obtained from slaying the Wither.");
        translationBuilder.add(lore("dragon_slayer"), "  Obtained from slaying the Ender Dragon.");
        translationBuilder.add(title("Empowered"), "Empowered");
        translationBuilder.add(title("ashen"), "Ashen");
        translationBuilder.add(title("dragon_slayer"), "Dragon Slayer");
        translationBuilder.add("trinkets.slot.misc.title", "Title");
    }
    public static String title(String key) {
        return "title.titlescrolls." + key;
    }
    public static String lore(String key) {
        return "text.titlescrolls." + key + ".lore";
    }
    public static String message(String key) {
        return "message.titlescrolls." + key;
    }
}
