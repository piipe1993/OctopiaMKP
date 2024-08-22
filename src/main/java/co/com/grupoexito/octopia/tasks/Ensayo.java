package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.abilities.ConexionDynamo;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.model.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static co.com.grupoexito.octopia.utils.Constantes.*;

public class Ensayo {

    public static void main(String[] args) {


        System.out.println(obtenerValorPartitionKey(100037927));
        System.out.println("----------------------------------");
        System.out.println(obtenerValorPartitionKey(990065717));
        System.out.println(obtenerValorIndiceGlobal("idProduct","AAAAA41883"));

    }



    public static String obtenerValorPartitionKey (int partitionKeyValue) {

        Item item = ConexionDynamo.getTable().getItem(PARTITION_KEY, partitionKeyValue);

        return item.toJSONPretty();
    }


    public static String obtenerValorConSortKey (int partitionKeyValue, String sortKeyValue) {

        Item item = ConexionDynamo.getTable().getItem(PARTITION_KEY, partitionKeyValue,
                SORT_KEY, sortKeyValue);

        return item.toJSONPretty();
    }


    public static List<java.util.Map<String, AttributeValue>> obtenerValorIndiceGlobal(String key, String value) {

        HashMap<String, Condition> scanFilter = new HashMap<>();

        Condition condition = new Condition().withComparisonOperator(ComparisonOperator.EQ.toString())
                .withAttributeValueList(new AttributeValue().withS(value));

        scanFilter.put(key, condition);
        ScanRequest scanRequest = new ScanRequest(NOMBRE_TABLA_DYNAMO).withScanFilter(scanFilter);
        ScanResult scanResult = ConexionDynamo.getDynamoDB().scan(scanRequest);
        return scanResult.getItems();
    }

}
