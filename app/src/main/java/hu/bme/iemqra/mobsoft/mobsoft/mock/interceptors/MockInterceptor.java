package hu.bme.iemqra.mobsoft.mobsoft.mock.interceptors;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

import android.net.Uri;
import android.util.Log;

import java.io.IOException;

import hu.bme.iemqra.mobsoft.mobsoft.network.NetworkConfig;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

import static hu.bme.iemqra.mobsoft.mobsoft.mock.interceptors.MockHelper.makeResponse;

public class MockInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {
        return process(chain.request());
    }

    public Response process(Request request) {

        Uri uri = Uri.parse(request.url().toString());

        Log.d("Test Http Client", "URL call: " + uri.toString());
        Headers headers = request.headers();


        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "food")) {
            return FoodMock.process(request);
        }

        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "login")) {
            return UserMock.process(request);
        }

        if (uri.getPath().startsWith(NetworkConfig.ENDPOINT_PREFIX + "allergenes")) {
            return AllergeneMock.process(request);
        }

        return makeResponse(request, headers, 404, "Unknown");

    }

}
