package co.com.grupoexito.octopia.models.productos;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

    private long gtin;

    @JsonProperty("sellerProductReference")
    private String sellerProductReference;

    private String title;
    private String description;

    @JsonProperty("sellerPictureUrls")
    private List<PictureUrl> sellerPictureUrls;

    @JsonProperty("categoryCode")
    private String categoryCode;

    private String brand;
    private String language;

    @JsonProperty("gtinReference")
    private String gtinReference;

    private List<Attribute> attributes;


    public long getGtin() {
        return gtin;
    }

    public void setGtin(long gtin) {
        this.gtin = gtin;
    }

    public String getSellerProductReference() {
        return sellerProductReference;
    }

    public void setSellerProductReference(String sellerProductReference) {
        this.sellerProductReference = sellerProductReference;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<PictureUrl> getSellerPictureUrls() {
        return sellerPictureUrls;
    }

    public void setSellerPictureUrls(List<PictureUrl> sellerPictureUrls) {
        this.sellerPictureUrls = sellerPictureUrls;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getGtinReference() {
        return gtinReference;
    }

    public void setGtinReference(String gtinReference) {
        this.gtinReference = gtinReference;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }
}
