package co.com.grupoexito.octopia.models.VtexInfoProducto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class AlternateId {
    @JsonProperty("Ean")
    private String Ean;

    @JsonProperty("RefId")
    private String RefId;



}
