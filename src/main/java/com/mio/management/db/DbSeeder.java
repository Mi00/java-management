package com.mio.management.db;

import com.github.javafaker.Faker;
import com.mio.management.models.Buyer;
import com.mio.management.models.Invoice;
import com.mio.management.models.InvoiceProduct;
import com.mio.management.models.Seller;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.TimeUnit;

@Component
public class DbSeeder implements CommandLineRunner {
    private InvoiceRepository invoiceRepository;

    public DbSeeder(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public void run(String... strings) throws Exception{
        //clear DB
        this.invoiceRepository.deleteAll();

        for(int i = 0; i < 10; i++){
            Faker faker = new Faker();
            Invoice invoice = new Invoice(
                    faker.commerce().price(),
                    faker.date().past(25, TimeUnit.DAYS),
                    new Seller(
                            faker.company().name(),
                            faker.address().streetAddress(),
                            faker.finance().iban(),
                            faker.finance().creditCard()
                    ),
                    new Buyer(
                            faker.company().name(),
                            faker.finance().iban(),
                            faker.address().streetAddress()
                    ),
                    faker.number().randomDouble(4, 100, 5000),
                    faker.number().randomDouble(4, 100, 5000),
                    faker.number().randomDouble(4, 100, 5000),
                    faker.bool().bool(),
                    Arrays.asList(
                            new InvoiceProduct(
                                    faker.commerce().productName(),
                                    null,
                                    0,
                                    faker.number().randomDouble(3, 10, 500),
                                    faker.number().randomDouble(3, 10, 500),
                                    faker.number().randomDouble(3, 10, 200)
                            )
                    )
            );
            this.invoiceRepository.save(invoice);
        }
    }
}
