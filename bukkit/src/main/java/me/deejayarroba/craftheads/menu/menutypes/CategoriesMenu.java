package me.deejayarroba.craftheads.menu.menutypes;

import dev.ursinn.utils.bukkit.builder.ItemBuilderBukkit;
import dev.ursinn.utils.bukkit.skull.SkullBukkit;
import me.deejayarroba.craftheads.menu.Menu;
import me.deejayarroba.craftheads.menu.MenuItem;
import me.deejayarroba.craftheads.menu.MenuManager;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.json.simple.JSONObject;

import java.util.ArrayList;

public class CategoriesMenu extends Menu {

    public CategoriesMenu() {
        name = mainInstance.getLanguage().getLanguageConfig().getString("menu.categories", "Categories");
        menuItems = new ArrayList<>();

        run();
    }

    private void run() {
        // Loop through all the categories
        for (Object o : mainInstance.getHeadCategories()) {
            final JSONObject category = (JSONObject) o;

            menuItems.add(new MenuItem(
                    new ItemBuilderBukkit(SkullBukkit.getCustomSkull((String) category.get("URL")))
                            .setName(ChatColor.GOLD + (String) category.get("Name"))
                            .build(),
                    (Player p) -> {
                        for (CategoryMenu categoryMenu : MenuManager.getCategoryMenus()) {
                            if (category.equals(categoryMenu.getCategory())) {
                                p.openInventory(categoryMenu.getInventory());
                            }
                        }
                    }));
        }

        placeItems();
    }
}
