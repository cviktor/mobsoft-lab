package hu.bme.iemqra.mobsoft.mobsoft.network;

/**
 * Created by mobsoft on 2017. 04. 24..
 */

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.AllergenesApi;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.FoodsApi;
import hu.bme.iemqra.mobsoft.mobsoft.network.api.UserApi;
import hu.bme.iemqra.mobsoft.mobsoft.utils.GsonHelper;
import okhttp3.OkHttpClient;
import retrofit2.GsonConverterFactory;
import retrofit2.Retrofit;

@Module
public class NetworkModule {

    @Provides
    @Singleton
    public OkHttpClient.Builder provideOkHttpClientBuilder() {
        return new OkHttpClient().newBuilder();
    }


    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(OkHttpClient.Builder builder) {
        return builder.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(OkHttpClient client) {
        return new Retrofit.Builder().baseUrl(NetworkConfig.SERVICE_ENDPOINT).client(client)
                .addConverterFactory(GsonConverterFactory.create(GsonHelper.getGson())).build();
    }
//
//    @Provides
//    @Singleton
//    public AllergenesApi provideAllergenesApi(Retrofit retrofit) {
//        return retrofit.create(AllergenesApi.class);
//    }
//
//    @Provides
//    @Singleton
//    public FoodsApi provideFoodsApi(Retrofit retrofit) {
//        return retrofit.create(FoodsApi.class);
//    }
//
//    @Provides
//    @Singleton
//    public UserApi provideUserApi(Retrofit retrofit) {
//        return retrofit.create(UserApi.class);
//    }


}
