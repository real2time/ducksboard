package com.bring.ducksboard;

import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthenticationException;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ByteArrayEntity;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.charset.Charset;

public class DucksboardDao {
    
    private static final Logger LOG = LoggerFactory.getLogger(DucksboardDao.class);

    private static final String DUCKSBOARD_URL = "https://push.ducksboard.com/v/";
    private HttpClient httpClient;
    private final String apiKey;

    public DucksboardDao(HttpClient httpClient, String apiKey) {
        this.httpClient = httpClient;
        this.apiKey = apiKey;
    }

    public void push(DucksboardId id, DucksboardRequest request) {
        try {
            String json = request.toJson().toString();
            LOG.debug("Sending request for " + id.getId() + ": " + json);
            
            HttpPost post = new HttpPost(DUCKSBOARD_URL + id.getId());
    
            post.setEntity(new ByteArrayEntity(json.getBytes(Charset.forName("UTF-8"))));

            post.setHeader("Content-type", "application/json");
            post.setHeader(new BasicScheme().authenticate(new UsernamePasswordCredentials(apiKey, "x"), post));
    
            HttpResponse response = httpClient.execute(post);
    
            String jsonResponse = EntityUtils.toString(response.getEntity());
    
            LOG.info("Finished request to " + id.getId() + " got response (" + response.getStatusLine().getStatusCode() + "): " + jsonResponse + "; Request: " + request.toJson() + "");
        }
        catch (IOException e) {
            LOG.warn("Got exception while sending request to " + id.getId(), e);
        }
        catch (AuthenticationException e) {
            LOG.warn("Authentication exception while sending request to " + id.getId(), e);
        }
    }
}
