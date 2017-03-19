package my.project.domain;


import javax.persistence.*;
import java.nio.ByteBuffer;

@Entity
@Table(name = "ad")
public class Ad {

    public Ad() {

    }

    public Ad(String name, Long user_id, String info, Integer price, Integer numberShow) {
        this.name = name;
        this.user_id = user_id;
        this.info = info;
        this.price = price;
        this.numberShow = numberShow;
    }

    @Id
    @GeneratedValue
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "user_id")
    private Long user_id;

    @Column(name = "info")
    private String info;

    @Column(name = "price")
    private Integer price;

    @Column(name = "number_show")
    private Integer numberShow;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getNumberShow() {
        return numberShow;
    }

    public void setNumberShow(Integer numberShow) {
        this.numberShow = numberShow;
    }



}
