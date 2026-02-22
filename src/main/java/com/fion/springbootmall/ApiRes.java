package com.fion.springbootmall;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiRes<T> {

    private String status;
    private String message = "";
    private T data;

    public static <T> ApiRes<T> success(T data) {
        return new ApiRes<>("success", data);
    }

    public static <T> ApiRes<T> fail(String message) {
        return new ApiRes<>("fail", message);
    }

    public static <T> ApiRes<T> error(String message) {
        return new ApiRes<>("error", message);
    }

    public ApiRes(String status, String message) {
        this.message = message;
        this.status = status;
    }

    public ApiRes(String status, T data) {
        this.status = status;
        this.data = data;
    }
}

