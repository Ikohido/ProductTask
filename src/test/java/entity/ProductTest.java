package entity;

import com.task.entity.Product;
import org.junit.Assert;
import org.junit.Test;

public class ProductTest {
    /**
     * Тест проверяет, что метод addProduct() корректно добавляет состав в продукты.
     * Given: Создание продуктов
     * When: Добавляем продукты друг в друга и проверяем, корректно ли они добавляются.
     * Then: Некорректно добавляем продукты друг в друга и проверяем, действительно ли они не добавляются.
     */

    @Test
    public void addProductTest(){
        // Given
        Product p1 = new Product("Тесто");
        Product p2 = new Product("Мука");
        Product p3 = new Product("Яйца");
        Product p4 = new Product("Вода");
        Product p5 = new Product("Пшеница");
        // When
        Assert.assertTrue(p1.addProduct(p2));
        Assert.assertTrue(p1.addProduct(p3));
        Assert.assertTrue(p1.addProduct(p4));
        Assert.assertTrue(p2.addProduct(p5));
        // Then
        Assert.assertFalse(p5.addProduct(p1));
        Assert.assertFalse(p1.addProduct(p4));
        Assert.assertFalse(p4.addProduct(p4));
        Assert.assertFalse(p1.addProduct(p5));
        Assert.assertFalse(p5.addProduct(p1));
    }
}
