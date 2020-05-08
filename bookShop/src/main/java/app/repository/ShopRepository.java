package app.repository;

import app.model.shopmodel.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop,Integer> {

    //ex.3.b
    //названиях магазинов Сормовского или Советского районов
    //т.е. как я понял если регион сормовский или советский, дальше я вызову метод районов по очереди
    @Query(value = "select name from shop s where s.region = :region", nativeQuery = true)
    List findAllNameShop(String region);

    //ex5.c
    @Query(value = "select name " +
            "from(select shop.name  from shop,buy,buyer " +
            "where shop.region != :region " +
            "and shop.id = buy.seller " +
            "and buyer.id = buy.buyer " +
            "and buyer.discount between :minDiscount and :maxDiscount)tempt " +
            "group by name", nativeQuery = true)
    List getShopNoRegionAndDiscountBetween(String region,double minDiscount, double maxDiscount);

}
