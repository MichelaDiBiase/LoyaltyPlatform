package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "catalog")
public class Catalog {
    @Id
    @Column(nullable = false,unique = true)
    private Integer id;
    @Column(nullable = false)
    private Integer idProduct;
    @Column(nullable = false)
    private Integer points;
    @Column(nullable = false)
    private Integer quantity;


    public Catalog(int idProduct,Integer points,Integer quantity){
        this.idProduct=idProduct;
        this.points=points;
        this.quantity=quantity;

    }


    public Catalog() {

    }


    public Integer getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(Integer idProduct) {
        this.idProduct = idProduct;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}