package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.abilities.ConexionDynamo;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import java.util.HashMap;
import java.util.List;


import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import static co.com.grupoexito.octopia.utils.Constantes.*;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarPartitionKeyDynamo implements Task {

    private String partitionKey;

    private int partitionKeyValue;

    public ConsultarPartitionKeyDynamo(String partitionKey, int partitionKeyValue) {
        this.partitionKey = partitionKey;
        this.partitionKeyValue = partitionKeyValue;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        String valorPartitionKey;
        Item item = ConexionDynamo.getTable().getItem(PARTITION_KEY, partitionKeyValue);
        valorPartitionKey = item.toJSONPretty();
        System.out.println(valorPartitionKey);
    }


    public static ConsultarPartitionKeyDynamo conLosValores(String partitionKey, int partitionKeyValue){

        return instrumented(ConsultarPartitionKeyDynamo.class, partitionKey, partitionKeyValue);
    }


}
