package me.deejayarroba.craftheads.menu;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class Category {

	private String name;
	private ItemStack icon;
	private Inventory inventory;
	private List<Head> heads = new ArrayList<Head>();

	public Category(String name, Material material, short damage) {
		this.name = name;
		ItemStack itemStack = new ItemStack(material, 1, damage);
		ItemMeta itemMeta = itemStack.getItemMeta();
		itemMeta.setDisplayName(ChatColor.AQUA + name);
		itemStack.setItemMeta(itemMeta);
		this.icon = itemStack;

		setup();

		int slotCount;
		int itemCount = getHeads().size();
		int rest = itemCount % 9;
		if (rest == 0)
			slotCount = itemCount;
		else
			slotCount = itemCount + (9 - rest);

		inventory = Bukkit.createInventory(null, slotCount, this.name);

		for(Head head : heads) {
			inventory.addItem(head.getItemStack());
		}

	}

	public void setup() {

	}

	public void add(String name, String headName, Material material, short damage) {
		Head head = new Head(name, headName, material, damage);
		heads.add(head);
	}

	public void add(String name, String headName, Material material, short damage, boolean safe) {
		Head head = new Head(name, headName, material, damage, safe);
		heads.add(head);
	}

	public List<Head> getHeads() {
		return heads;
	}

	public Head getHead(String name) {
		for(Head head : heads) {
			if(head.getName().equals(name)) {
				return head;
			}
		}
		return null;
	}

	public ItemStack getIcon() {
		return icon;
	}

	public String getName() {
		return name;
	}

	public Inventory getInventory() {
		return inventory;
	}

}