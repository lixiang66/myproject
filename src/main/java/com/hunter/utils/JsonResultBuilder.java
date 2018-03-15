package com.hunter.utils;

/**
 * Created by lixiang on 2018/3/14.
 */
public class JsonResultBuilder {

        public static ResponseResult success() {
                return new JsonResultBuilder.ResponseResult(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMsg(), null);
        }

        public static ResponseResult success(String message) {
                return new JsonResultBuilder.ResponseResult(ResultCode.SUCCESS.getCode(), message, null);
        }

        public static ResponseResult success(String message, Object data) {
                return new JsonResultBuilder.ResponseResult(ResultCode.SUCCESS.getCode(), message, data);
        }

        public static ResponseResult fail(String message) {
                return new JsonResultBuilder.ResponseResult(ResultCode.FAIL.getCode(), message, null);
        }

        public static ResponseResult fail(String message, Object data) {
                return new JsonResultBuilder.ResponseResult(ResultCode.FAIL.getCode(), message, data);
        }

        public static ResponseResult error(String message) {
                return new JsonResultBuilder.ResponseResult(ResultCode.ERROR.getCode(), message, null);
        }

        public static ResponseResult error(String message, Object data) {
                return new JsonResultBuilder.ResponseResult(ResultCode.ERROR.getCode(), message, data);
        }

        public enum ResultCode {
                SUCCESS(200, "操作成功"),
                FAIL(400, "操作失败"),
                ERROR(500, "操作异常");

                private Integer code;
                private String msg;

                ResultCode(Integer code, String msg) {
                        this.code = code;
                        this.msg = msg;
                }

                public Integer getCode() {
                        return code;
                }

                public void setCode(Integer code) {
                        this.code = code;
                }

                public String getMsg() {
                        return msg;
                }

                public void setMsg(String msg) {
                        this.msg = msg;
                }
        }

        public static class ResponseResult {

                private Integer code;
                private String message;
                private Object data;

                public ResponseResult(Integer code, String message, Object data) {
                        this.code = code;
                        this.message = message;
                        this.data = data;
                }

                public Integer getCode() {
                        return code;
                }

                public void setCode(Integer code) {
                        this.code = code;
                }

                public String getMessage() {
                        return message;
                }

                public void setMessage(String message) {
                        this.message = message;
                }

                public Object getData() {
                        return data;
                }

                public void setData(Object data) {
                        this.data = data;
                }
        }
}
