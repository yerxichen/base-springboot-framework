package com.sjq.demo.Utils;

import lombok.Data;

@Data
public class AjaxResult<T> {
   

        private int code = 1;
        private T data;
        private String msg = "";
        private String error = "";

        public static AjaxResult ok = new AjaxResult();
        public static AjaxResult fail = new AjaxResult().code(-1);

        public AjaxResult code(int code) {
            this.code = code;
            return this;
        }

        public AjaxResult data(T data) {
            this.data = data;
            return this;
        }

        public AjaxResult msg(String msg) {
            this.msg = msg;
            return this;
        }

        public AjaxResult error(String error) {
            this.error = error;
            return this;
        }
   
    
}
