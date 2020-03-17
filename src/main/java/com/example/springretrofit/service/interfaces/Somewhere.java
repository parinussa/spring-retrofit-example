package com.example.springretrofit.service.interfaces;

import com.example.springretrofit.service.somewhere.SomewhereData;
import com.example.springretrofit.service.somewhere.SomewhereRequest;
import com.example.springretrofit.service.somewhere.SomewhereResponse;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface Somewhere {
    @POST("Oelm0WXM1luMpwV2dRBy")
    Call<SomewhereResponse> createSomething(@Body SomewhereRequest<SomewhereData> data);
}
