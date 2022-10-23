import external.db.ProductRepository;
import external.email.EmailService;
import external.tracking.GstTracker;
import octo.GSTCalculator;
import octo.Product;
import octo.WareHouse;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;

public class WareHouseTest {

    // Note: dependency has to bee added to gradle.build for using Mockito
    private WareHouse wh = new WareHouse();

    GSTCalculator calculatorSpy = Mockito.spy(GSTCalculator.class);
    ProductRepository productRepositorySpy = Mockito.spy(ProductRepository.class);

    EmailService emailServiceSpy = Mockito.spy(EmailService.class);

    List<Product> products = List.of(new Product("Product1", 1),
            new Product("Product2", 2),
            new Product("Product3", 3),
            new Product("Product4", 4),
            new Product("Product5", 5));

    @Test
    void calculatorIsCalledFiveTimes() {
        wh.processProducts("Salome", products, calculatorSpy, productRepositorySpy, emailServiceSpy);
        Mockito.verify(calculatorSpy, times(5)).calculatePriceWithGST(any(Product.class));
    }

    @Test
    void productRepositoryIsCalledWithRightParameters() {
        wh.processProducts("Salome", products, calculatorSpy, productRepositorySpy, emailServiceSpy);
        for (Product product : this.products) {
            Mockito.verify(productRepositorySpy).save(product, product.getPrice());
        }
    }

    @Test
    void emailServiceIsCalledWithRightParameters() {
        wh.processProducts("Salome", products, calculatorSpy, productRepositorySpy, emailServiceSpy);
        Mockito.verify(emailServiceSpy).sendEmail("Salome");
    }

}
