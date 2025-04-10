package ru.job4j.ood.isp.menu;

public class Printer implements MenuPrinter {

    @Override
    public void print(Menu menu) {
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            print(menuItemInfo);
        }
    }

    @Override
    public void print(Menu.MenuItemInfo menuItemInfo) {
        int replace = Integer.parseInt(menuItemInfo.getNumber().replace(".", ""));
        while (replace > 10) {
            replace /= 10;
            System.out.print("----");
        }
        System.out.println(menuItemInfo.getNumber() + menuItemInfo.getName());
    }
}
