package com.md4c.demoapi.controller;

import com.md4c.demoapi.domain.entity.Currency;
import com.md4c.demoapi.domain.repository.CurrencyRepository;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = {"Currency"})
public class CurrencyController {

    private final CurrencyRepository currencyRepository;

    @Autowired
    public CurrencyController(CurrencyRepository currencyRepository) {
        this.currencyRepository = currencyRepository;
    }

    @GetMapping("/currencies")
    public Iterable<Currency> getCurrencies() {
        return currencyRepository.findAll();
    }

    @PostMapping("/currencies")
    public void addCurrencies(@RequestBody Currency currency) {
        currencyRepository.save(currency);
    }

    @PutMapping("/currencies")
    void updateCurrency(@RequestBody Currency currency) {
        currencyRepository.save(currency);
    }

    @DeleteMapping("/currencies/{id}")
    void deleteCurrency(@PathVariable Long id) {
        currencyRepository.deleteById(id);
    }
}