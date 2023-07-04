package it.unicam.cs.ids.loyaltyplatform.entity.platformservices;
import jakarta.persistence.*;


@Entity
@Table(name = "catalog")
public class Catalog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JoinColumn(nullable = false)
    @ManyToOne
    private Product product;
    @Column(nullable = false)
    private Integer points;


    public Catalog(Product product,Integer points,Integer quantity){
        this.product=product;
        this.points=points;

    }


    public Catalog() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }
}