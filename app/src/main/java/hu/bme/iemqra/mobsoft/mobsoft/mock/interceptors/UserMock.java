package hu.bme.iemqra.mobsoft.mobsoft.mock.interceptors;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

import android.net.Uri;

import hu.bme.iemqra.mobsoft.mobsoft.network.NetworkConfig;
import hu.bme.iemqra.mobsoft.mobsoft.repository.MemoryRepository;
import hu.bme.iemqra.mobsoft.mobsoft.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.iemqra.mobsoft.mobsoft.mock.interceptors.MockHelper.makeResponse;

public class UserMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();


        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "login") && request.method().equals("POST")) {
            MemoryRepository memoryRepository = new MemoryRepository();
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(memoryRepository.getUser());
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
