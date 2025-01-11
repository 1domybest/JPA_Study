package jpabook.jpashoop.repository;

import jakarta.persistence.EntityManager;
import jpabook.jpashoop.domain.item.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class ItemRepository {
    private final EntityManager em;

    public void save(Item item) {
        if (item.getId() == null) {
            // create
            em.persist(item);
        } else {
            // update
            em.merge(item);
        }
    }

    public Item fincOne(Long id) {
        return em.find(Item.class, id);
    }

    public List<Item> findAll() {
        return em.createQuery("select i from Item i", Item.class)
                .getResultList();
    }
}
