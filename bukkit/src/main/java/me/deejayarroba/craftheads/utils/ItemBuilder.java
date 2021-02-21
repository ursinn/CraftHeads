package me.deejayarroba.craftheads.utils;

import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.material.MaterialData;

import javax.annotation.Nonnull;
import java.util.*;

/**
 * @author Ursin Filli
 * @version 1.0
 * @since 1.0
 */
public class ItemBuilder {

    private final ItemStack itemStack;

    /**
     * Constructor.
     *
     * @param itemStack item ({@link ItemStack})
     */
    public @Nonnull
    ItemBuilder(@Nonnull ItemStack itemStack) {
        this.itemStack = Objects.requireNonNull(itemStack);
    }

    /**
     * Constructor.
     *
     * @param type item material
     */
    public @Nonnull
    ItemBuilder(@Nonnull Material type) {
        this.itemStack = new ItemStack(type);
    }

    /**
     * Constructor.
     *
     * @param type   item material
     * @param amount item amount
     */
    public @Nonnull
    ItemBuilder(@Nonnull Material type, int amount) {
        this.itemStack = new ItemStack(type, amount);
    }

    /**
     * Constructor.
     *
     * @param type   item material
     * @param amount item amount
     * @param damage durability / damage
     */
    public @Nonnull
    ItemBuilder(@Nonnull Material type, int amount, short damage) {
        this.itemStack = new ItemStack(type, amount, damage);
    }

    /**
     * @return item name
     */
    public @Nonnull
    String getName() {
        return getItemMeta().getDisplayName();
    }

    /**
     * @param name item name
     */
    public @Nonnull
    ItemBuilder setName(@Nonnull String name) {
        ItemMeta meta = getItemMeta();
        meta.setDisplayName(name);
        setItemMeta(meta);
        return this;
    }

    /**
     * @param lore item lore
     */
    public @Nonnull
    ItemBuilder addLore(@Nonnull List<String> lore) {
        ItemMeta meta = getItemMeta();
        meta.setLore(lore);
        setItemMeta(meta);
        return this;
    }

    public @Nonnull
    ItemBuilder addLore(@Nonnull String... lore) {
        ItemMeta itemMeta = itemStack.getItemMeta();
        List<String> original = itemMeta.getLore();
        if (original == null) {
            original = new ArrayList<>();
        }
        Collections.addAll(original, lore);
        itemMeta.setLore(original);
        itemStack.setItemMeta(itemMeta);
        return this;
    }

    /**
     * @return item lore
     */
    public @Nonnull
    List<String> getLore() {
        return getItemMeta().getLore();
    }

    /**
     * @param itemFlags item Flags
     */
    public @Nonnull
    ItemBuilder addItemFlags(@Nonnull ItemFlag... itemFlags) {
        ItemMeta meta = getItemMeta();
        meta.addItemFlags(itemFlags);
        setItemMeta(meta);
        return this;
    }

    /**
     * @return item Flags
     */
    public @Nonnull
    Set<ItemFlag> getItemFlags() {
        return getItemMeta().getItemFlags();
    }

    /**
     * @return item material
     */
    public @Nonnull
    Material getMaterial() {
        return itemStack.getType();
    }

    /**
     * @param type item material
     */
    public @Nonnull
    ItemBuilder setMaterial(@Nonnull Material type) {
        itemStack.setType(type);
        return this;
    }

    /**
     * @return item amount
     */
    public int getAmount() {
        return itemStack.getAmount();
    }

    /**
     * @param amount item amount
     */
    public @Nonnull
    ItemBuilder setAmount(int amount) {
        itemStack.setAmount(amount);
        return this;
    }

    /**
     * @return durability / damage
     */
    public short getDurability() {
        return itemStack.getDurability();
    }

    /**
     * @param damage durability / damage
     */
    public @Nonnull
    ItemBuilder setDurability(short damage) {
        itemStack.setDurability(damage);
        return this;
    }

    /**
     * @return item material data
     */
    public @Nonnull
    MaterialData getData() {
        return itemStack.getData();
    }

    /**
     * @param data item material data
     */
    public @Nonnull
    ItemBuilder setData(@Nonnull MaterialData data) {
        itemStack.setData(data);
        return this;
    }

    /**
     * @param enchantment enchantment ({@link Enchantment})
     * @param level       enchantment level
     */
    public @Nonnull
    ItemBuilder addEnchantment(@Nonnull Enchantment enchantment, int level) {
        itemStack.addEnchantment(enchantment, level);
        return this;
    }

    /**
     * @param enchantments enchantments
     */
    public @Nonnull
    ItemBuilder addEnchantments(@Nonnull Map<Enchantment, Integer> enchantments) {
        itemStack.addEnchantments(enchantments);
        return this;
    }

    /**
     * @param enchantment enchantment ({@link Enchantment})
     * @param level       enchantment level
     */
    public @Nonnull
    ItemBuilder addUnsafeEnchantment(@Nonnull Enchantment enchantment, int level) {
        itemStack.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    /**
     * @param enchantments enchantments
     */
    public @Nonnull
    ItemBuilder addUnsafeEnchantments(@Nonnull Map<Enchantment, Integer> enchantments) {
        itemStack.addUnsafeEnchantments(enchantments);
        return this;
    }

    /**
     * @return enchantments
     */
    public @Nonnull
    Map<Enchantment, Integer> getEnchantments() {
        return itemStack.getEnchantments();
    }

    /**
     * @return item meta
     */
    public @Nonnull
    ItemMeta getItemMeta() {
        return itemStack.getItemMeta();
    }

    /**
     * @param meta item meta
     */
    public @Nonnull
    ItemBuilder setItemMeta(@Nonnull ItemMeta meta) {
        itemStack.setItemMeta(meta);
        return this;
    }

    /**
     * @return item ({@link ItemStack})
     */
    public @Nonnull
    ItemStack build() {
        return itemStack;
    }
}
