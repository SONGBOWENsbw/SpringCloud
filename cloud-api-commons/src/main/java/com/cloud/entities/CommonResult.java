package com.cloud.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: songbowen
 * @Description:
 * @Date: Create in 18:00 2020/4/21
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {

    private Integer code;
    private String message;
    private T       data;

    public CommonResult(Integer code, String message){
        this(code,message,null);
    }

}
