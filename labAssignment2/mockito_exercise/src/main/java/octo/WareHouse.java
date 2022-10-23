package octo;

import external.db.ProductRepository;
import external.email.EmailService;

import java.util.List;

public class WareHouse {

    public void processProducts(String user, List<Product> products, GSTCalculator calculator, ProductRepository productRepository, EmailService emailService) {
        for (Product product : products) {
            int price = calculator.calculatePriceWithGST(product);
            productRepository.save(product, price);
        }
        emailService.sendEmail(user);
    }
}

