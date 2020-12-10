package com.earbuds.pricecomparisonscraper.repository;

import com.earbuds.pricecomparisonscraper.model.AmazonData;
import org.springframework.data.repository.CrudRepository;

public interface AmazonRepository extends CrudRepository<AmazonData, Integer> {
}
