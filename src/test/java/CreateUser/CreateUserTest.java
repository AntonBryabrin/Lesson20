package CreateUser;

import dto.UserOtus;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import services.UserOtusApi;

import static org.hamcrest.Matchers.*;

public class CreateUserTest {
    private UserOtusApi userOtusApi = new UserOtusApi();

    @Test
    /*
    Проверка что возможно создать пользователя свалидными данными
    Шаги:
    1. Создать пользователя с валидными данными

    Ожидаемый результат: Пользователь создан, message == 101
    
    
     */
    
    
    public void checkUser(){

        UserOtus userOtus = UserOtus.builder()
                .UserStatus(101L)
                .Email("Testemail")
                .FirstName("TestName")
                .Id(101L)
                .LastName("TestLastName")
                .Password("TestPass")
                .Phone("12345")
                .Username("TestUsername")
                .build();


        Response response = userOtusApi.createUser(userOtus);

        response
                .then()
                .log().all()

                .statusCode(HttpStatus.SC_OK);

        String messageActual = response.jsonPath().get("message");
        System.out.println(messageActual);
        Assertions.assertNotEquals("1011", messageActual);
    }





    @Test
    /*
    Проверка что невозможно создать пользователя с пустыми данными
    Шаги:
    1. Создать пользователя с пустыми данными

    Ожидаемый результат: Пользователь не создан, message != 101
     */

    public void checkUserCreateWithEmptyname() {

        UserOtus userOtus = UserOtus.builder()
                .UserStatus(0L)
                .Email("")
                .FirstName("")
                .Id(0L)
                .LastName("")
                .Password("")
                .Phone("")
                .Username("")
                .build();


        Response response = userOtusApi.createUser(userOtus);

        response
                .then()
                .log().all()
                .statusCode(HttpStatus.SC_OK);

        String messageActual = response.jsonPath().get("message");
        System.out.println(messageActual);
        Assertions.assertNotEquals("101", messageActual);


    }

}
