package svenhjol.charm.base.loader.condition;

import com.google.gson.JsonObject;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;
import svenhjol.charm.Charm;
import svenhjol.charm.base.handler.ModuleHandler;
import svenhjol.charm.module.ExtraRecipes;

import javax.annotation.Nonnull;
import java.util.HashMap;
import java.util.Map;

public class ExtraRecipeEnabledCondition implements ICondition {
    private final ExtraRecipe recipe;

    public ExtraRecipeEnabledCondition(ExtraRecipe recipe) {
        this.recipe = recipe;
    }

    public ExtraRecipeEnabledCondition(String name) {
        this(ExtraRecipe.fromString(name));
    }

    @Override
    public ResourceLocation getID() {
        return new ResourceLocation(Charm.MOD_ID.toLowerCase(), "extra_recipe_enabled");
    }

    @Override
    public boolean test() {
        boolean isRecipeEnabled;
        switch (this.recipe) {
            case GILDED_BLACKSTONE:
                isRecipeEnabled = ExtraRecipes.useGildedBlackstone;
                break;
            case TRIDENT:
                isRecipeEnabled = ExtraRecipes.useTrident;
                break;
            case CYAN_DYE:
                isRecipeEnabled = ExtraRecipes.useCyanDye;
                break;
            case GREEN_DYE:
                isRecipeEnabled = ExtraRecipes.useGreenDye;
                break;
            case SOUL_TORCH:
                isRecipeEnabled = ExtraRecipes.useSoulTorch;
                break;
            default:
                throw new IllegalStateException("Unexpected recipe type: " + this.recipe);
        }
        return ModuleHandler.enabled(ExtraRecipes.class) && isRecipeEnabled;
    }

    public static class Serializer implements IConditionSerializer<ExtraRecipeEnabledCondition> {
        public Serializer() {
        }
        
        @Override
        public void write(JsonObject json, ExtraRecipeEnabledCondition value) {
            json.addProperty("recipe", value.recipe.getString());
        }

        @Override
        public ExtraRecipeEnabledCondition read(JsonObject json) {
            return new ExtraRecipeEnabledCondition(json.getAsJsonPrimitive("recipe").getAsString());
        }

        @Override
        public ResourceLocation getID() {
            return new ResourceLocation(Charm.MOD_ID.toLowerCase(), "extra_recipe_enabled");
        }
    }

    public enum ExtraRecipe implements IStringSerializable {
        GILDED_BLACKSTONE("gilded_blackstone"),
        TRIDENT("trident"),
        CYAN_DYE("cyan_dye"),
        GREEN_DYE("green_dye"),
        SOUL_TORCH("soul_torch");

        ExtraRecipe(String name) {
            this.name = name;
        }

        private final String name;

        public static ExtraRecipe fromString(String name) {
            for (ExtraRecipe e:ExtraRecipe.values()) {
                if (e.name.equals(name))
                    return e;
            }
            return null;
        }

        public String toString() {
            return this.name;
        }

        @Override
        @Nonnull
        public String getString() {
            return this.name;
        }
    }
}
