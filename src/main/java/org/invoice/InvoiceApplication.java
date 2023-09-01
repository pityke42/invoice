package org.invoice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.logging.Logger;

@SpringBootApplication

public class InvoiceApplication  {
    private static Logger log = Logger.getLogger("invoiceApplication");
    public static void main(String[] args) {
        SpringApplication.run(InvoiceApplication.class, args);
        log.info("application started");

    }


}