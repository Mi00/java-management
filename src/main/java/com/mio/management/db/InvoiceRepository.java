package com.mio.management.db;

import com.mio.management.models.Invoice;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends MongoRepository<Invoice,String>, QuerydslPredicateExecutor<Invoice> {

    Optional<Invoice> findById(String id);

    List<Invoice> findByNumber(String number);

    List<Invoice> findByIsPaidIsTrue();

    List<Invoice> findByIsPaidIsFalse();

    @Query(value = "{'buyer.name':?0}")
    List<Invoice> findByBuyerName(String name);
}
