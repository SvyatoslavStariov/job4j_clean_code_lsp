package ru.job4j.ood.isp.menu.action;

import ru.job4j.ood.isp.menu.Input;
import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.MenuAction;
import ru.job4j.ood.isp.menu.MenuPrinter;

public class FindByNameElementMenu implements MenuAction {

    @Override
    public boolean execute(Input input, Menu menu, MenuPrinter menuPrinter) {
        String parentElementName = input.askStr("Введите название элемента меню: ");
        for (Menu.MenuItemInfo menuItemInfo : menu) {
            if (menuItemInfo.getName().equals(parentElementName)) {
                menuPrinter.print(menuItemInfo);
                break;
            }
        }
        return true;
    }

    @Override
    public String name() {
        return "Найти элемент меню по названию.";
    }
}
