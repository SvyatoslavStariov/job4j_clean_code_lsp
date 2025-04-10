package ru.job4j.ood.isp.menu;

public interface MenuAction {

    boolean execute(Input input, Menu menu, MenuPrinter menuPrinter);

    String name();
}
