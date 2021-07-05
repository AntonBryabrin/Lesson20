package GetUser;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;



public class GetUser {

    @Test
    /*
    Проверка что при вводе валидного имени будет выведена информация о существующем пользователе
    Шаги:
    1. Запросить пользовалтеля с существующим именем в системе

    Ожидаемый результат: Код 200
     */

    public void getUserTest(){
        RestAssured.
                when()
                .get("https://petstore.swagger.io/v2/user/TestUsername").
                then()
                .log().all()
                .assertThat().statusCode(200);

    }



    @Test
    /*
    Проверка что при попыитке получить несуществующего пользователя - будет выведена ошибкак 404
    Шаги:
    1. Запросить пользовалтеля с несуществующим именем в системе

    Ожидаемый результат: Ошибка 404
     */

    public void getWrongUserTest(){
        RestAssured.
                when()
                .get("https://petstore.swagger.io/v2/user/John").
                then()
                .log().all()
                .assertThat().statusCode(200);

    }



}
