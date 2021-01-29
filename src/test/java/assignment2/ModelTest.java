/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package assignment2;

import assignment2.backend.*;
import assignment2.model.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ModelTest {

    /**
     * Test the getter and setter methods for Card
     */
    @Test
    void cardTest() {
        Card card = new Card("sasha","123");
        assertEquals("sasha", card.getName());
        assertEquals("123", card.getNum());
    }

    /**
     * Test the getter and setter methods for Card
     */
    @Test
    void cashTest() {
        Cash cash = new Cash("20",2);
        assertEquals("20,2", cash.toString());
        assertEquals("20", cash.getPrice());
        assertEquals("20", cash.priceProperty().get());
        assertEquals(2, cash.getQuantity());
        cash.setQuantity(3);
        cash.setPrice("30");
        assertEquals("30", cash.getPrice());
        assertEquals(3, cash.quantityProperty().get());
    }

    /**
     * Test the getter and setter methods for User
     */
    @Test
    void userTest() {
        User user = new User(1, "admin");
        assertEquals( 1 , user.getId());
        assertEquals("admin", user.getType());
    }

    /**
     * Test the validate() method for JSON file reader.
     * test for valid card object
     */
    @Test
    void jsonValidValidateTest() {
        JSON reader = new JSON();
        Card card = new Card("Maxine","34402");
        Card validate = reader.validate(card.getName(),card.getNum());
        assertEquals(card.getName(), validate.getName());
        assertEquals(card.getNum(), validate.getNum());
    }

    /**
     * Test the validate() method for JSON file reader.
     * test for invalid card object
     */
    @Test
    void jsonInvalidValidateTest() {
        JSON reader = new JSON();
        Card card = new Card("Maxine","0");
        Card validate = reader.validate(card.getName(),card.getNum());
        assertNull(validate);
    }
}