package ru.job4j.ood.isp.menu.action;

import ru.job4j.ood.isp.menu.Input;
import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.MenuAction;
import ru.job4j.ood.isp.menu.MenuPrinter;

public class FindAllElementMenu implements MenuAction {

    @Override
    public boolean execute(Input input, Menu menu, MenuPrinter menuPrinter) {
        System.out.println("=== Показать меню ===");
        menuPrinter.print(menu);
        return true;
    }

    @Override
    public String name() {
        return "Вывести все меню в консоль.";
    }
}
