package app.repository;

import app.model.bookmodel.Book;
import app.model.bookmodel.BookNameCost;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Collection;
import java.util.List;

public interface BookRepository extends JpaRepository<Book,Integer> {

    //ex.2.a
    @Query(value = "select name,cost from book group by (name,cost)", nativeQuery = true)
    List findAllBookNameCost();

    //ex 3.c
    @Query(value = "select name,cost " +
            "from book b " +
            "where strpos(b.name, :name) > 0 " +
            "and b.cost > :cost " +
            "order by b.cost desc", nativeQuery = true)
    List findAllBookNameAndCostWithFilter(String name,double cost);

}