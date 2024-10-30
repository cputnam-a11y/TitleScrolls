package titlescrolls.impl.mixin;

import net.minecraft.component.ComponentChanges;
import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.function.SetComponentsLootFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;

@Mixin(SetComponentsLootFunction.class)
public interface SetComponentsLootFunctionInvoker {
    @Invoker("<init>")
    static SetComponentsLootFunction invokeInit(List<LootCondition> conditions, ComponentChanges changes) {
        throw new AssertionError("Implmented by Mixin");
    }
}
