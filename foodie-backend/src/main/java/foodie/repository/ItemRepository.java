package foodie.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import foodie.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{

}
