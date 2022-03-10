

import org.json.JSONException;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.json.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class RestClient {

    public static ArrayList getJsonEmployee(String uri) throws JSONException, IOException {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        headers.setContentType((MediaType.APPLICATION_XML));
        HttpEntity entity = new HttpEntity(headers);


        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, entity, String.class);
        String result = response.getBody();


        String[] a0 =result.split("<b style=\"color: #f28b00\"> ");
        String[] a1=  a0[1].split("USD");

        String[] b0 =result.split("<td class=\"prdTd col-xs-5 prop-td\">Manufacturer</td>");
        String[] b1=  b0[1].split("</td>");
        String[] b2 = b1[0].split("<td class=\"col-xs-6 prop-td\">");

        String[] c0 =result.split("<title>");
        String[] c1=  c0[1].split(" | ");

        ArrayList list = new ArrayList<>();

        list.add(a1[0]);
        list.add(b2[1]);
        list.add(c1[0]);

        return list;

    }
}