package pl.chojnacki.grzegorz.testing.order;

import org.junit.jupiter.api.*;
import pl.chojnacki.grzegorz.testing.Meal;
import pl.chojnacki.grzegorz.testing.order.Order;
import pl.chojnacki.grzegorz.testing.order.OrderBackup;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OrderBackupTest {

    private static OrderBackup orderBackup;

    @BeforeAll
    static void setup() throws FileNotFoundException {
        orderBackup = new OrderBackup();
        orderBackup.createFile();
    }

    @BeforeEach
    void appendAtTheStartOfTheLine() throws IOException {
        orderBackup.getWriter().append("New order: ");
    }

    @AfterEach
    void appendAtTheEndOfLine() throws IOException {
        orderBackup.getWriter().append(" backed up.");
    }

    @Tag("Fries")
    @Test
    void backupOrderWithOneMeal() throws IOException {
        //given
        Meal meal = new Meal(15,"Fries");
        pl.chojnacki.grzegorz.testing.order.Order order = new Order();
        order.addMealToOrder(meal);

        //when
        orderBackup.backupOrder(order);

        //then
        System.out.println("Order: " + order.toString() + "backed up");
    }

    @AfterAll
    static void tearDown() throws IOException {
        orderBackup.closeFile();
    }
}
