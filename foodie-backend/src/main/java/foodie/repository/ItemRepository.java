package foodie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import foodie.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {

	@Query("select i from Item i where id in :ids")
	List<Item> findAllWithSpecificIDs(@Param("ids") List<Long> itemIDs);
}
