package ru.job4j.ood.isp.menu;

import ru.job4j.ood.isp.menu.action.CreateElement;
import ru.job4j.ood.isp.menu.action.ExitAction;
import ru.job4j.ood.isp.menu.action.FindByNameElementMenu;
import ru.job4j.ood.isp.menu.action.FindAllElementMenu;

import java.util.List;

/**
 * 6. Создайте простенький класс TodoApp. Этот класс будет представлять собой консольное приложение, которое позволяет:
 * Добавить элемент в корень меню;
 * Добавить элемент к родительскому элементу;
 * Вызвать действие, привязанное к пункту меню (действие можно сделать константой,
 * например, ActionDelete DEFAULT_ACTION = () -> System.out.println("Some action") и указывать при добавлении элемента в меню);
 * Вывести меню в консоль.
 */
public class TodoApp {

    public static final ActionDelegate DEFAULT_ACTION = () -> System.out.println("Some action");

    public static void main(String[] args) {
        Menu menu = new SimpleMenu();
        MenuPrinter menuPrinter = new Printer();
        List<MenuAction> actions = List.of(
            new CreateElement(),
            new FindByNameElementMenu(),
            new FindAllElementMenu(),
            new ExitAction()
        );
        Input input = new ValidateInput(new ConsoleInput());
        init(input, actions, menu, menuPrinter);
    }

    private static void showMenu(List<MenuAction> actions) {
        System.out.println("Menu:");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    private static void init(Input input, List<MenuAction> actions, Menu menu, MenuPrinter menuPrinter) {
        boolean run = true;
        while (run) {
            showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                System.out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            MenuAction action = actions.get(select);
            run = action.execute(input, menu, menuPrinter);
        }
    }
}
