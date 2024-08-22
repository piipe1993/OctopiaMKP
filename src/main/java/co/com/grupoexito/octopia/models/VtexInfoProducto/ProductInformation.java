package co.com.grupoexito.octopia.models.VtexInfoProducto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;

@Getter
@Setter
public class ProductInformation {
    @JsonProperty("Id")
    private int Id;

    @JsonProperty("ProductId")
    private int ProductId;

    @JsonProperty("ProductName")
    private String ProductName;

    @JsonProperty("ProductDescription")
    private String ProductDescription;

    @JsonProperty("ProductRefId")
    private String ProductRefId;

    @JsonProperty("TaxCode")
    private String TaxCode;

    @JsonProperty("SkuName")
    private String SkuName;

    @JsonProperty("IsActive")
    private boolean IsActive;

    @JsonProperty("ImageUrl")
    private String ImageUrl;

    @JsonProperty("BrandId")
    private String BrandId;

    @JsonProperty("BrandName")
    private String BrandName;

    @JsonProperty("IsBrandActive")
    private boolean IsBrandActive;

    @JsonProperty("SkuSellers")
    private ArrayList<SkuSeller> SkuSellers = new ArrayList<SkuSeller>();

    @JsonProperty("Images")
    private ArrayList<Image> Images = new ArrayList<Image>();

    @JsonProperty("AlternateIds")
    private AlternateId AlternateIds;

    @JsonProperty("KeyWords")
    private String KeyWords;

    @JsonProperty("ReleaseDate")
    private String ReleaseDate;

    @JsonProperty("ProductIsVisible")
    private boolean ProductIsVisible;

    @JsonProperty("IsProductActive")
    private boolean IsProductActive;

}
