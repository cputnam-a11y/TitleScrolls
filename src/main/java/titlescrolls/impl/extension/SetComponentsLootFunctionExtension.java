package titlescrolls.impl.extension;

import net.minecraft.component.ComponentChanges;
import net.minecraft.component.ComponentType;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.SetComponentsLootFunction;
import titlescrolls.impl.mixin.ConditionLootFunctionInvoker;
import titlescrolls.impl.mixin.SetComponentsLootFunctionInvoker;

public class SetComponentsLootFunctionExtension {
    public static <T> ConditionalLootFunction.Builder<?> builder(ComponentChanges changes) {
        return ConditionLootFunctionInvoker.invokeBuilder((conditions) -> SetComponentsLootFunctionInvoker.invokeInit(conditions, changes));
    }
}
