package app.repository;

import app.model.buyermodel.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyerRepository extends JpaRepository<Buyer,Integer> {

    //ex.2.b
    @Query(value = "select region from buyer group by region", nativeQuery = true)
    List findAllRegion();

    //ex.3.a
    @Query(value = "select surname,discount from buyer b where b.region = :region", nativeQuery = true)
    List findAllSurnameAndDiscount(String region);

    //ex5.b
    @Query(value = "select buyer.surname,buyer.region, buy.timepurchase " +
            "from buy, shop, buyer " +
            "where " +
            "buy.seller = shop.id " +
            "and buy.buyer = buyer.id " +
            "and buyer.region != shop.region " +
            "and date_part('month', buy.timepurchase) > :month " +
            "order by buyer.surname", nativeQuery = true)
    List findBuyerWithSurnameRegionDate(int month);
}
