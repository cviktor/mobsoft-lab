package hu.bme.iemqra.mobsoft.mobsoft.mock.interceptors;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

import android.net.Uri;

import java.util.ArrayList;
import java.util.List;

import hu.bme.iemqra.mobsoft.mobsoft.network.NetworkConfig;
import hu.bme.iemqra.mobsoft.mobsoft.network.model.Food;
import hu.bme.iemqra.mobsoft.mobsoft.repository.MemoryRepository;
import hu.bme.iemqra.mobsoft.mobsoft.utils.GsonHelper;
import okhttp3.Headers;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.iemqra.mobsoft.mobsoft.mock.interceptors.MockHelper.makeResponse;

public class FoodMock {
    public static Response process(Request request) {
        Uri uri = Uri.parse(request.url().toString());

        String responseString;
        int responseCode;
        Headers headers = request.headers();

        MemoryRepository memoryRepository = new MemoryRepository();

        List<Food> food = new ArrayList<>();
        Food f1 = new Food();
        f1.setDetails("Valami details");
        f1.setId(1);
        f1.setName("Húsleves");
        food.add(f1);

        Food f2 = new Food();
        f2.setDetails("Valami details");
        f2.setId(1);
        f2.setName("Húsleves");
        food.add(f2);

        if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "food") && request.method().equals("POST")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(f1);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "food") && request.method().equals("GET")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(food);
            responseCode = 200;
        } else if (uri.getPath().equals(NetworkConfig.ENDPOINT_PREFIX + "food/1") && request.method().equals("GET")) {
            memoryRepository.open(null);
            responseString = GsonHelper.getGson().toJson(f1);
            responseCode = 200;
        } else {
            responseString = "ERROR";
            responseCode = 503;
        }

        return makeResponse(request, headers, responseCode, responseString);
    }
}
