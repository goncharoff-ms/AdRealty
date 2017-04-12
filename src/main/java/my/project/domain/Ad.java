package my.project.domain;


import org.hibernate.type.BooleanType;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

/**
 * POJO класс для объялвний
 */
@Entity
@Table(name = "ad")
public class Ad {

    /**
     * пустой конструктор
     */
    public Ad() {

    }


    /**
     * ID объявления
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;


    /**
     * Дата подачи объявления
     */
    @Column(name = "date_create")
    private Date date;


    /**
     * @param date дата подачи объявления
     * @param name имя объявления
     * @param user_id id владельца объявления
     * @param info доп. информация
     * @param price цена
     * @param numberShow кол-во показов
     * @param haveImage наличие изображения
     * @param realty тип недивижимости
     * @param typeAd тип объявления
     * @param sity город
     * @param street улица
     * @param houseNumber номер дома
     * @param sqare площадь
     */
    public Ad(Date date, String name, Long user_id, String info, Integer price, Integer numberShow, Integer haveImage, String realty, String typeAd, String sity, String street, String houseNumber, Integer sqare) {
        this.date = date;
        this.name = name;
        this.user_id = user_id;
        this.info = info;
        this.price = price;
        this.numberShow = numberShow;
        this.haveImage = haveImage;
        this.realty = realty;
        this.typeAd = typeAd;
        this.sity = sity;
        this.street = street;
        this.houseNumber = houseNumber;
        this.sqare = sqare;
    }

    /**
     * имя объявления
     */
    @Column(name = "name")
    private String name;

    /**
     * id владельца объявления
     */
    @Column(name = "user_id")
    private Long user_id;

    /**
     * доп.информация
     */
    @Column(name = "info")
    private String info;

    /**
     * цена
     */
    @Column(name = "price")
    private Integer price;

    /**
     * кол-во показов
     */
    @Column(name = "number_show")
    private Integer numberShow;

    /**
     * наличие фото
     */
    @Column(name = "is_have_image")
    private Integer haveImage;

    /**
     * тип недвижимости
     */
    @Column(name = "realty")
    private String realty;

    /**
     * тип объявления
     */
    @Column(name = "type_Ad")
    private String typeAd;

    /**
     * город
     */
    @Column(name = "sity")
    private String sity;

    /**
     * улица
     */
    @Column(name = "street")
    private String street;

    /**
     * номер дома
     */
    @Column(name = "house_number")
    private String houseNumber;

    /**
     * площадь
     */
    @Column(name = "sqare")
    private Integer sqare;

    // setter`s and getter`s

    public String getRealty() {
        return realty;
    }

    public void setRealty(String realty) {
        this.realty = realty;
    }

    public String getTypeAd() {
        return typeAd;
    }

    public void setTypeAd(String typeAd) {
        this.typeAd = typeAd;
    }

    public String getSity() {
        return sity;
    }

    public void setSity(String sity) {
        this.sity = sity;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public Integer getSqare() {
        return sqare;
    }

    public void setSqare(Integer sqare) {
        this.sqare = sqare;
    }

    public int getHaveImage() {
        return haveImage;
    }

    public void setHaveImage(Integer haveImage) {
        this.haveImage = haveImage;
    }

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


    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
