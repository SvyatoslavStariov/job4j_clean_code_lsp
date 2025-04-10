package ru.job4j.ood.isp.menu.action;

import ru.job4j.ood.isp.menu.Input;
import ru.job4j.ood.isp.menu.Menu;
import ru.job4j.ood.isp.menu.MenuAction;
import ru.job4j.ood.isp.menu.MenuPrinter;

import static ru.job4j.ood.isp.menu.TodoApp.DEFAULT_ACTION;

public class CreateElement implements MenuAction {

    @Override
    public boolean execute(Input input, Menu menu, MenuPrinter menuPrinter) {
        System.out.println("=== Создания элемента меню ====");
        System.out.println("""
            === Если название родительского элемента будет пропущено, то дочерний элемент станет родительским ===="""
        );
        String parentElementName = input.askStr("Введите название родительского элемента: ");
        String childElementName = input.askStr("Введите название дочернего элемента: ");
        boolean isAdded = menu.add(parentElementName, childElementName, DEFAULT_ACTION);
        if (isAdded) {
            System.out.println("Элемент успешно добавлен в меню");
        }
        return isAdded;
    }

    @Override
    public String name() {
        return "Добавить элемент";
    }
}
