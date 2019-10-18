package assessment.sofi;


import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

public class Assignment2 {

    private static final String URI = "https://jsonmock.hackerrank.com/api/movies/search/";

    /**
     * Get all matching movie titles
     *
     * @param title - movie title
     * @return - Array of movie title
     * @throws Exception - when there is an error
     */
    public ArrayList<String> getMoviesTitles(String title) throws Exception {
        ArrayList<String> titles = new ArrayList<>();

        // construct the url with params and make http call
        ArrayList<StringBuilder> responses = getHttpResponsesList(title);

        for (StringBuilder response : responses) {
            JSONObject jsonObject = new JSONObject(response.toString());
            JSONArray jsonDataArray = new JSONArray(jsonObject.getString("data"));
            for (int i = 0; i < jsonDataArray.length(); i++) {
                titles.add(jsonDataArray.getJSONObject(i).getString("Title"));
            }
        }

        System.out.println("Total Titles  " + titles.size());
        for (String s : titles) {
            System.out.println(s);
        }
        return titles;
    }

    /**
     * get All matching movies for a given title
     *
     * @param title - movie title
     * @return - Array of all responses
     * @throws Exception - when there is an error
     */
    protected ArrayList getHttpResponsesList(String title) throws Exception {
        // request parameters
        String urlParameters = "?Title=" + title + "&page=";

        // Make first call to get matching movies
        StringBuilder response = getHttpResponse(urlParameters);  // First Call
        JSONObject jsonObject = new JSONObject(response.toString());

        //Get total_page in the response
        int total_pages = jsonObject.getInt("total_pages");
        System.out.println("total pages " + total_pages);

        // this stores all http response
        ArrayList<StringBuilder> allResp = new ArrayList<>(total_pages);
        allResp.add(response);

        // if total pages are more than 1, add page and get all movies on those pages.
        if (total_pages > 1) {
            for (int nextPage = 2; nextPage <= total_pages; nextPage++) {
                allResp.add(getHttpResponse(urlParameters + nextPage));
            }
        }

//        System.out.println(allResp);
        return allResp;
    }

    /**
     * make GET HTTP Call and collect response as String
     *
     * @param param - request url parameters
     * @return StringBuilder - GET HTTP response
     * @throws Exception - Where there is an error
     */
    protected StringBuilder getHttpResponse(String param) throws Exception {
        StringBuilder response = new StringBuilder();
        HttpURLConnection connection = null;
        try {
            String url = URI + param;
            System.out.println("url  " + url);
            java.net.URL obj = new URL(url);
            connection = (HttpURLConnection) obj.openConnection();

            int status = connection.getResponseCode();
//            System.out.println("Response Code - " + status);

            if (status == 200) {
                response = readResponseStream(connection);

            }
        } finally {
            if (connection != null)
                connection.disconnect();
        }
//        System.out.println(response);
        return response;
    }

    /**
     * read response stream
     *
     * @param connection - HttpURLConnection
     * @return StringBuilder - connection response stream
     * @throws IOException
     */
    private StringBuilder readResponseStream(HttpURLConnection connection) throws IOException {
        StringBuilder response = new StringBuilder();

        BufferedReader in = new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String inputLine;


        while ((inputLine = in.readLine()) != null) {
            response.append(inputLine);
        }
        in.close();

        return response;
    }
}
