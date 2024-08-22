package co.com.grupoexito.octopia.models.VtexInfoProducto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SkuSeller {
    @JsonProperty("SellerId")
    private String SellerId;

    @JsonProperty("StockKeepingUnitId")
    private int StockKeepingUnitId;

    @JsonProperty("SellerStockKeepingUnitId")
    private String SellerStockKeepingUnitId;

    @JsonProperty("FreightCommissionPercentage")
    private double FreightCommissionPercentage;

    @JsonProperty("ProductCommissionPercentage")
    private double ProductCommissionPercentage;

    @JsonProperty("IsActive")
    private boolean IsActive;
}
