package org.invoice.repository;

import org.invoice.repository.entity.Address;
import org.invoice.repository.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AddressRepository extends CrudRepository<Address, UUID> {
}
