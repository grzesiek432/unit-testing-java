package pl.chojnacki.grzegorz.testing.cart;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.chojnacki.grzegorz.testing.Meal;
import pl.chojnacki.grzegorz.testing.cart.Cart;
import pl.chojnacki.grzegorz.testing.order.Order;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Test cases for Cart")
public class CartTest {


    //@Disabled
    @Test
    @DisplayName("Cart is able to process 1000 order in 100ms ")
    void simulateLargeOrder() {

        //given
        Cart cart = new Cart();

        //when
        //then
        assertTimeout(Duration.ofMillis(100), cart::simulateLargeOrder);
    }

    @Test
    void cartShouldNotBeEmptyAfterAddingOrderToCart()
    {
        //given
        Order order = new Order();
        Cart cart = new Cart();

        //when
        cart.addOrderToCart(order);

        //then
        assertThat(cart.getOrders(),anyOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))

        ));

        assertThat(cart.getOrders(), allOf(
                notNullValue(),
                hasSize(1),
                is(not(empty())),
                is(not(emptyCollectionOf(Order.class)))

        ));

        assertAll("This is a group of assertions for cart",
                () -> assertThat(cart.getOrders(),notNullValue()),
                () -> assertThat(cart.getOrders(),hasSize(1)),
                () -> assertThat(cart.getOrders(),is(not(empty()))),
                () -> assertThat(cart.getOrders(),is(not(emptyCollectionOf(Order.class)))),
                () -> {
                    List<Meal> mealList = cart.getOrders().get(0).getMeals();
                    assertThat(mealList, empty());

                });
    }
}
