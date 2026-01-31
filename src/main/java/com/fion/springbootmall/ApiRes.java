package com.fion.springbootmall;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
@AllArgsConstructor
public class ApiRes<T> {

    private String status;
    private T data;

    public static <T> ApiRes<T> success(T data) {
        return new ApiRes<>("success", data);
    }

    public static <T> ApiRes<T> error(T data) {
        return new ApiRes<>("error", data);
    }

}
