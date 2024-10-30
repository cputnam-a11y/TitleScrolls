package titlescrolls.api.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;

import java.util.Optional;

public interface TitleScrollItem {
    Text getTitle(ItemStack titleScrollStack);

    int getRibbonColor(ItemStack titleScrollStack);

    static Optional<Item> asItem(TitleScrollItem scrollItem) {
        return scrollItem instanceof Item item
                ? Optional.of(item)
                : Optional.empty();
    }
}
