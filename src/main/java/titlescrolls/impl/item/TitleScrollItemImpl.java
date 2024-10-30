package titlescrolls.impl.item;

import dev.emi.trinkets.api.SlotReference;
import dev.emi.trinkets.api.TrinketItem;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.MathHelper;
import titlescrolls.api.item.TitleScrollItem;
import titlescrolls.api.item.component.RibbonColorComponent;
import titlescrolls.api.item.component.TitleTextComponent;
import titlescrolls.impl.item.component.ComponentTypesImpl;

import java.util.List;
import java.util.Optional;

public class TitleScrollItemImpl extends TrinketItem implements TitleScrollItem {

    public TitleScrollItemImpl(Settings settings) {
        super(settings);
    }

    @Override
    public Text getTitle(ItemStack titleScrollStack) {
        return Optional.ofNullable(titleScrollStack.get(ComponentTypesImpl.TITLE_TEXT))
                .map(TitleTextComponent::text)
                .or(() -> Optional.ofNullable(titleScrollStack.get(DataComponentTypes.CUSTOM_NAME)))
                .orElse(Text.literal("Blank Scroll"));
    }

    @Override
    public int getRibbonColor(ItemStack titleScrollStack) {
        return Optional.ofNullable(titleScrollStack.get(ComponentTypesImpl.RIBBON_COLOR))
                .map(RibbonColorComponent::color)
                .map(color -> color.getRgb() | 0xFF000000).orElseGet(
                        () -> MathHelper.hsvToRgb(Math.abs(getTitle(titleScrollStack).getString().hashCode()) % 360 / 360f, 1f, 1f) | 0xFF000000
                );
    }

    @Override
    public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.empty().append(getTitle(stack)).formatted(Formatting.BOLD));
        if (!stack.contains(ComponentTypesImpl.TITLE_TEXT) && !stack.contains(DataComponentTypes.CUSTOM_NAME)) {
            tooltip.add(Text.translatable("message.titlescrolls.rename"));
        }
        if (stack.contains(ComponentTypesImpl.SCROLL_LORE)) {
            tooltip.addAll(stack.get(ComponentTypesImpl.SCROLL_LORE).lore());
        }
        super.appendTooltip(stack, context, tooltip, type);
    }

    @Override
    public boolean canEquip(ItemStack stack, SlotReference slot, LivingEntity entity) {
        return stack.contains(ComponentTypesImpl.TITLE_TEXT) || stack.contains(DataComponentTypes.CUSTOM_NAME);
    }
}
