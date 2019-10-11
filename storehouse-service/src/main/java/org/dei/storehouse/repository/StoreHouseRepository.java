package org.dei.storehouse.repository;

import org.dei.storehouse.domain.StoreHouse;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreHouseRepository extends CrudRepository<StoreHouse, Long> {
}
