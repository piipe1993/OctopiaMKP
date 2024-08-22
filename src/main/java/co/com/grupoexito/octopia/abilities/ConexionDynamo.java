package co.com.grupoexito.octopia.abilities;

import co.com.grupoexito.octopia.exceptions.MensajeExcepciones;
import co.com.grupoexito.octopia.models.Credenciales;
import com.amazonaws.auth.AWSCredentialsProvider;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.Table;


import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import lombok.Getter;

import static co.com.grupoexito.octopia.utils.Constantes.NOMBRE_TABLA_DYNAMO;

public class ConexionDynamo {


    private static Credenciales credenciales;

    static {
        try {
            credenciales = new Credenciales("credenciales.properties");
        } catch (MensajeExcepciones e) {
            throw new RuntimeException(e);

        }
    }


    private static AWSCredentialsProvider credentialsProvider =
            new AWSStaticCredentialsProvider(
                    new BasicAWSCredentials(credenciales.getProperty("AWS.accessKeyID"), credenciales.getProperty("AWS.secretAccessKey")));


    private static AmazonDynamoDB dynamoDB =
            AmazonDynamoDBClientBuilder.standard().withCredentials(credentialsProvider).withRegion("us-east-1")
                    .build();

    private static com.amazonaws.services.dynamodbv2.document.DynamoDB dynamo = new DynamoDB(dynamoDB);


    private static Table table = dynamo.getTable(NOMBRE_TABLA_DYNAMO);

    public static Table getTable() {
        return table;
    }

    public static AmazonDynamoDB getDynamoDB() {
        return dynamoDB;
    }


    public static DynamoDB getDynamo() {
        return dynamo;
    }
}
