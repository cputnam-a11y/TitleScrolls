package titlescrolls.impl.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class TitleScrollsDataGenerator implements DataGeneratorEntrypoint {
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
		FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();
		pack.addProvider(TitleScrollsEnglishLangProvider::new);
		pack.addProvider(TitleScrollsItemTagProvider::new);
		pack.addProvider(TitleScrollsRecipeProvider::new);
	}
}
