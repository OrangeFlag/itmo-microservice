package org.dei.storehouse.repository;

import org.dei.storehouse.model.StoreHouse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StoreHouseRepository extends JpaRepository<StoreHouse, Long> {
}
