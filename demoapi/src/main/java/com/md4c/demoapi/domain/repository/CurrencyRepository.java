package com.md4c.demoapi.domain.repository;

import com.md4c.demoapi.domain.entity.Currency;
import org.springframework.data.repository.CrudRepository;

public interface CurrencyRepository extends CrudRepository<Currency, Long> {
}