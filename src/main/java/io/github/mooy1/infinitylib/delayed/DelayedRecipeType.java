package io.github.mooy1.infinitylib.delayed;

import io.github.mooy1.infinitylib.PluginUtils;
import me.mrCookieSlime.Slimefun.Lists.RecipeType;
import me.mrCookieSlime.Slimefun.api.SlimefunItemStack;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;
import java.util.function.BiConsumer;

public final class DelayedRecipeType extends RecipeType {

    private final DelayedConsumer<ItemStack[], ItemStack> delayed;
    
    public DelayedRecipeType(SlimefunItemStack item) {
        this(item, new DelayedConsumer<>());
    }

    private DelayedRecipeType(SlimefunItemStack item, DelayedConsumer<ItemStack[], ItemStack> consumer) {
        super(PluginUtils.getKey(item.getItemId().toLowerCase(Locale.ROOT)), item, consumer);
        this.delayed = consumer;
    }
    
    public void acceptEach(BiConsumer<ItemStack[], ItemStack> consumer) {
        this.delayed.acceptEach(consumer);
    }
    
}