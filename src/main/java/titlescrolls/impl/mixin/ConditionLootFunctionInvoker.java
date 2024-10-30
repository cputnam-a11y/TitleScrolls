package titlescrolls.impl.mixin;

import net.minecraft.loot.condition.LootCondition;
import net.minecraft.loot.function.ConditionalLootFunction;
import net.minecraft.loot.function.LootFunction;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

import java.util.List;
import java.util.function.Function;

@Mixin(ConditionalLootFunction.class)
public interface ConditionLootFunctionInvoker {
    @Invoker
    static ConditionalLootFunction.Builder<?> invokeBuilder(Function<List<LootCondition>, LootFunction> joiner) {
        throw new AssertionError("Implmented by Mixin");
    }

}
