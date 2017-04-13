package my.project.domain;

import javax.persistence.*;
import java.sql.Blob;


/**
 * POJO класс для изображений
 */
@Entity
@Table(name="image")
public class Image {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * Имя файла
     */
    @Column(name="name")
    private String name;

    /**
     * Тип содержимого
     */
    @Column(name="contentType")
    private String contentType;

    /**
     * Размер файла
     */
    @Column(name="lenght")
    private Integer length;

    /**
     * Blob содержимое файла
     */
    @Column(name="content")
    @Lob
    private Blob content;

    /**
     * ID объявления
     */
    @Column(name = "ad_id")
    private Long adId;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }

    public Blob getContent() {
        return content;
    }

    public void setContent(Blob content) {
        this.content = content;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }
}