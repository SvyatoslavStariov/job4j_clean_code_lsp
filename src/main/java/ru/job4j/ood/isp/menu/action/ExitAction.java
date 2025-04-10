package ru.job4j.ood.isp.menu.action;

import ru.job4j.ood.isp.menu.Input;
import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.MenuAction;
import ru.job4j.ood.isp.menu.MenuPrinter;

public class ExitAction implements MenuAction {

    @Override
    public boolean execute(Input input, Menu menu, MenuPrinter menuPrinter) {
        System.out.println("=== Работа программы завершена ===");
        return false;
    }

    @Override
    public String name() {
        return "Выйти из программы";
    }
}
