package titlescrolls.impl;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.Identifier;
import titlescrolls.api.TitleEffect;
import titlescrolls.api.TitleEffects;

import java.util.HashMap;
import java.util.Map;

public class TitleEffectsImpl implements TitleEffects {

    private final Map<Identifier, TitleEffect> effects = new HashMap<>();

    @Override
    public void registerEffect(Identifier id, TitleEffect effect) {
        effects.put(id, effect);
    }

    @Override
    public TitleEffect getEffect(Identifier id) {
        return effects.getOrDefault(id, TitleEffect.NONE);
    }
}
