package com.feidu.duoduodou.bean;

import java.util.List;

/**
 * Created by wangjian on 2017/12/19.
 */

public class DuihuanLeiBie {

    /**
     * APICode : 0
     * ErrorCode : 0
     * ErrorMessage : 成功
     * Data : [{"ID":"1","Name":"大乐透"},{"ID":"6","Name":"流量"},{"ID":"7","Name":"话费"},{"ID":"8","Name":"油卡"},{"ID":"9","Name":"电影票"}]
     */

    private String APICode;
    private String ErrorCode;
    private String ErrorMessage;
    private List<DataBean> Data;

    public String getAPICode() {
        return APICode;
    }

    public void setAPICode(String APICode) {
        this.APICode = APICode;
    }

    public String getErrorCode() {
        return ErrorCode;
    }

    public void setErrorCode(String ErrorCode) {
        this.ErrorCode = ErrorCode;
    }

    public String getErrorMessage() {
        return ErrorMessage;
    }

    public void setErrorMessage(String ErrorMessage) {
        this.ErrorMessage = ErrorMessage;
    }

    public List<DataBean> getData() {
        return Data;
    }

    public void setData(List<DataBean> Data) {
        this.Data = Data;
    }

    public static class DataBean {
        public DataBean(String ID, String name) {
            this.ID = ID;
            Name = name;
        }
        /**
         * ID : 1
         * Name : 大乐透
         */

        private String ID;
        private String Name;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }
    }
}
