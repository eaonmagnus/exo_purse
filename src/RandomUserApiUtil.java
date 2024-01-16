import io.restassured.RestAssured;
import io.restassured.response.Response;

public class RandomUserApiUtil {

    private static final String BASE_URL = "https://randomuser.me/api";
    private static final String NATIONALITY = "fr";

    public static User getRandomUser() {
        RestAssured.baseURI = BASE_URL;

        Response response = RestAssured.given()
                .param("nat", NATIONALITY)
                .when()
                .get();

        // Vérifier le code de réponse (200 OK)
        if (response.getStatusCode() == 200) {
            // Récupérer le nom, le prénom et le genre depuis la réponse JSON
            String firstName = response.jsonPath().getString("results[0].name.first");
            String lastName = response.jsonPath().getString("results[0].name.last");
            String gender = response.jsonPath().getString("results[0].gender");

            // Retourner un objet User
            return new User(firstName, lastName, gender);
        } else {
            throw new RuntimeException("Échec de la requête API avec le code de réponse : " + response.getStatusCode());
        }
    }
}
