package com.github.lukasschr.disablenetherend;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleFactory;
import net.fabricmc.fabric.api.gamerule.v1.GameRuleRegistry;
import net.minecraft.world.GameRules;

public class DisableNetherEndEntrypoint implements ModInitializer {

    public static final GameRules.Key<GameRules.BooleanRule> DISABLE_END =
            GameRuleRegistry.register("disableEnd", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));

    public static final GameRules.Key<GameRules.BooleanRule> DISABLE_NETHER =
            GameRuleRegistry.register("disableNether", GameRules.Category.PLAYER, GameRuleFactory.createBooleanRule(false));

    @Override
    public void onInitialize() {
    }
}