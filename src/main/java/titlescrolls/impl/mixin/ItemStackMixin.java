package titlescrolls.impl.mixin;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import com.llamalad7.mixinextras.sugar.Local;
import net.minecraft.component.ComponentHolder;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Formatting;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import titlescrolls.impl.item.component.ComponentTypesImpl;

@Mixin(ItemStack.class)
public abstract class ItemStackMixin implements ComponentHolder {
    @ModifyExpressionValue(
            method = "getTooltip",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/util/Rarity;getFormatting()Lnet/minecraft/util/Formatting;"
            )
    )
    private Formatting modifyRarityFormatting(Formatting original) {
        if (this.contains(ComponentTypesImpl.LEGENDARY_RARITY))
            return Formatting.DARK_RED;
        return original;
    }
}
