package net.bingyan.treediary.helper;


import java.lang.Object;

/**
 * Created by ilovey on 5/16/15.
 */
public class ResponseService{
    private Integer code;
    private String status;
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
