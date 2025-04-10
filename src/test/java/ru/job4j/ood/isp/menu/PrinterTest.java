package ru.job4j.ood.isp.menu;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PrinterTest {

    private static final ActionDelegate STUB_ACTION = System.out::println;

    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
    }

    @Test
    public void whenAddThenReturnSame() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Купить продукты", "Купить молоко", STUB_ACTION);
        MenuPrinter menuPrinter = new Printer();
        menuPrinter.print(menu);
        assertEquals("1.Сходить в магазин"
            + System.lineSeparator()
            + "----1.1.Купить продукты"
            + System.lineSeparator()
            + "--------1.1.1.Купить хлеб"
            + System.lineSeparator()
            + "--------1.1.2.Купить молоко"
            + System.lineSeparator()
            + "2.Покормить собаку", outputStreamCaptor.toString()
            .trim());
    }

    @Test
    public void whenAddThenReturnSame2() {
        Menu menu = new SimpleMenu();
        menu.add(Menu.ROOT, "Сходить в магазин", STUB_ACTION);
        menu.add(Menu.ROOT, "Покормить собаку", STUB_ACTION);
        menu.add("Сходить в магазин", "Купить продукты", STUB_ACTION);
        menu.add("Купить продукты", "Купить хлеб", STUB_ACTION);
        menu.add("Покормить собаку", "Дать еды", STUB_ACTION);
        menu.add("Покормить собаку", "Дать воды", STUB_ACTION);
        MenuPrinter menuPrinter = new Printer();
        menuPrinter.print(menu);
        assertEquals("1.Сходить в магазин"
            + System.lineSeparator()
            + "----1.1.Купить продукты"
            + System.lineSeparator()
            + "--------1.1.1.Купить хлеб"
            + System.lineSeparator()
            + "2.Покормить собаку"
            + System.lineSeparator()
            + "----2.1.Дать еды"
            + System.lineSeparator()
            + "----2.2.Дать воды", outputStreamCaptor.toString()
            .trim());
    }
}