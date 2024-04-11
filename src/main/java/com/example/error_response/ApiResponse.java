package com.example.error_response;

import com.example.error_response.exception.ErrorCode;
import com.example.error_response.setting.Metadata;
import com.example.error_response.setting.Status;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

import java.util.List;

@Getter
public class ApiResponse<T> {

    private Status status;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Metadata metadata;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> results;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object data;


    public ApiResponse(List<T> results){
        this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.metadata = new Metadata(results.size());
        this.results = results;
    }

    public ApiResponse(T result){
        this.status = new Status(ErrorCode.OK.getCode(), ErrorCode.OK.getMessage());
        this.metadata = new Metadata(1);
        this.results = List.of(result);
    }

    public ApiResponse(int code, String message, Object data) {
        this.status = new Status(code, message);
        this.data = data;
    }
}
