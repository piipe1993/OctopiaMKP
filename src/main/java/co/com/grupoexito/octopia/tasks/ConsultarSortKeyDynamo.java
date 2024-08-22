package co.com.grupoexito.octopia.tasks;

import co.com.grupoexito.octopia.abilities.ConexionDynamo;
import com.amazonaws.services.dynamodbv2.document.Item;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;

import static co.com.grupoexito.octopia.utils.Constantes.PARTITION_KEY;
import static co.com.grupoexito.octopia.utils.Constantes.SORT_KEY;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ConsultarSortKeyDynamo implements Task {

    private String partitionKey;

    private int partitionKeyValue;
    private String sortKey;

    private String sortKeyValue;


    public ConsultarSortKeyDynamo(String partitionKey, int partitionKeyValue, String sortKey, String sortKeyValue) {
        this.partitionKey = partitionKey;
        this.partitionKeyValue = partitionKeyValue;
        this.sortKey = sortKey;
        this.sortKeyValue = sortKeyValue;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {


        String valorConsulta;
        Item item = ConexionDynamo.getTable().getItem(PARTITION_KEY, partitionKeyValue,
                SORT_KEY, sortKeyValue);

        valorConsulta = item.toJSONPretty();
        System.out.println(valorConsulta);
    }

    public static ConsultarSortKeyDynamo conLosValores(String partitionKey, int partitionKeyValue, String sortKey, String sortKeyValue){
        return instrumented(ConsultarSortKeyDynamo.class,partitionKey, partitionKeyValue, sortKey, sortKeyValue);
    }
}
