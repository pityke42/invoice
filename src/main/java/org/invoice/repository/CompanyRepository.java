package org.invoice.repository;

import org.invoice.repository.entity.Company;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface CompanyRepository extends CrudRepository<Company, UUID> {
}
