package app.repository;

import app.model.buymodel.Buy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BuyRepository extends JpaRepository<Buy,Integer> {

    //2.c
    @Query(value = "select date_part('month',timepurchase) m from buy group by m", nativeQuery = true)
    List findMonthBuy();

    //4
    @Query(value = "select buyer.surname,shop.name " +
            "from buy,buyer,shop " +
            "where buyer.id = buy.buyer " +
            "and shop.id = buy.seller ",
            nativeQuery = true)
    List getSurnameNameShop();

    //4
    @Query(value = "select buy.timepurchase,buyer.surname,buyer.discount,book.name, buy.quantity " +
            "from buy, buyer,book\n" +
            "where buy.buyer = buyer.id " +
            "and buy.book = book.id ", nativeQuery = true)
    List getBuyWithDateSurnameDiscountNameBookQuantity();

    //ex5.a
    @Query(value = "select buy.id,buyer.surname,buy.timepurchase from buy, buyer\n" +
            "where buy.buyer = buyer.id and buy.price >= :cost", nativeQuery = true)
    List getBuyWithIdBuyerDate(double cost);


    //ex5.d
    @Query(value = "select book.name,book.warehouse, buy.quantity, buy.price " +
            "from buy, shop, book " +
            "where " +
            "buy.seller = shop.id " +
            "and buy.book = book.id " +
            "and book.warehouse = shop.region " +
            "and buy.quantity > :quantity " +
            "order by buy.price", nativeQuery = true)
    List getBuyWithBookWarehouseQuantityPrice(int quantity);

}
