package co.com.sofka.ui;

import net.serenitybdd.screenplay.targets.Target;
import net.thucydides.core.annotations.findby.By;

public class HomePage {
    public static final Target INVENTORY_LIST = Target
            .the("Inventory list")
            .located(By.xpath("//div[@id='inventory_container']//div[@class='inventory_item']//button[contains(text(), 'ADD TO CART')]"));
    public static final Target SHOPPING_CART = Target
            .the("Shopping cart").located(By.id("shopping_cart_container"));
}
