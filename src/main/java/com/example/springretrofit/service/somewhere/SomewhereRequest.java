package com.example.springretrofit.service.somewhere;

import lombok.Data;

@Data
public class SomewhereRequest<T> {
    private T data;

    public SomewhereRequest(T data) {
        this.data = data;
    }
}
