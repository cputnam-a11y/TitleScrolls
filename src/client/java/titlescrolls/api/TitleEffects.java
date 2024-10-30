package titlescrolls.api;

import net.minecraft.util.Identifier;
import titlescrolls.impl.TitleEffectsImpl;

public interface TitleEffects {
    TitleEffects INSTANCE = new TitleEffectsImpl();

    /**
     * register a new id effect
     * @param id the id to register with
     * @param effect the effect to register
     */
    void registerEffect(Identifier id, TitleEffect effect);

    /**
     * get a id effect
     * @param id the id of the effect to get
     * @return the effect with that id, or {@link TitleEffect#NONE}
     */
    TitleEffect getEffect(Identifier id);
}
