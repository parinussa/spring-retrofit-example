package com.example.springretrofit.service.somewhere;

import com.example.springretrofit.service.interfaces.Somewhere;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import org.springframework.stereotype.Service;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Service
public class SomewhereService {
    private Retrofit retrofit;
    private Somewhere somewhere;

    private static final String BASE_URL = "https://hookb.in/";

    public SomewhereService() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

        retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
        somewhere = retrofit.create(Somewhere.class);
    }

    public SomewhereResponse create(SomewhereData data) throws Exception {
        SomewhereRequest<SomewhereData> somewhereRequest = new SomewhereRequest(data);
        Response<SomewhereResponse> somewhereResponse = somewhere.createSomething(somewhereRequest).execute();

        if (!somewhereResponse.isSuccessful()) {
            throw new Exception("Request failed");
        }

        return somewhereResponse.body();
    }
}
