import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class task4 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("===== Currency Converter =====");

        System.out.print("Enter Base Currency (Example: USD): ");
        String base = sc.next().toUpperCase();

        System.out.print("Enter Target Currency (Example: INR): ");
        String target = sc.next().toUpperCase();

        System.out.print("Enter Amount: ");
        double amount = sc.nextDouble();

        try {

            String apiUrl = "https://open.er-api.com/v6/latest/" + base;

            HttpClient client = HttpClient.newHttpClient();

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(apiUrl))
                    .build();

            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());

            String json = response.body();

            String search = "\"" + target + "\":";

            int index = json.indexOf(search);

            if (index == -1) {
                System.out.println("Invalid Target Currency!");
                return;
            }

            int start = index + search.length();
            int end = json.indexOf(",", start);

            if (end == -1)
                end = json.indexOf("}", start);

            double rate = Double.parseDouble(json.substring(start, end));

            double converted = amount * rate;

            System.out.println("\n----- Result -----");
            System.out.println("Exchange Rate : " + rate);
            System.out.println(amount + " " + base + " = " + converted + " " + target);

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        sc.close();
    }
}
