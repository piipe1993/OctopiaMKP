package co.com.grupoexito.octopia.models.productos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Attribute {

    @JsonProperty("propertyReference")
    private int propertyReference;

    private List<String> values;

    public int getPropertyReference() {
        return propertyReference;
    }

    public void setPropertyReference(int propertyReference) {
        this.propertyReference = propertyReference;
    }

    public List<String> getValues() {
        return values;
    }

    public void setValues(List<String> values) {
        this.values = values;
    }
}
