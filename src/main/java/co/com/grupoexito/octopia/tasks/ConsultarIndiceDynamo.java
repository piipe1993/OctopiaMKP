package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.abilities.ConexionDynamo;
import com.amazonaws.services.dynamodbv2.model.*;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.grupoexito.octopia.utils.Constantes.NOMBRE_TABLA_DYNAMO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarIndiceDynamo implements Task {

    private String itemGlobal;

    private String valorItemGlobal;

    public ConsultarIndiceDynamo(String itemGlobal, String valorItemGlobal) {
        this.itemGlobal = itemGlobal;
        this.valorItemGlobal = valorItemGlobal;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {

        List<Map<String, AttributeValue>> valorIndiceGlobal;
        HashMap<String, Condition> scanFilter = new HashMap<>();

        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.EQ.toString())
                .withAttributeValueList(new AttributeValue().withS(valorItemGlobal));

        scanFilter.put(itemGlobal, condition);
        ScanRequest scanRequest = new ScanRequest(NOMBRE_TABLA_DYNAMO).withScanFilter(scanFilter);
        ScanResult scanResult = ConexionDynamo.getDynamoDB().scan(scanRequest);
        valorIndiceGlobal = scanResult.getItems();
        System.out.println(valorIndiceGlobal);

    }

    public static ConsultarIndiceDynamo conLosValores (String itemGlobal, String valorItemGlobal) {

        return instrumented(ConsultarIndiceDynamo.class,itemGlobal, valorItemGlobal);
    }
}
