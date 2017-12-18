package com.feidu.duoduodou;

import java.util.List;

/**
 * Created by wangjian on 2017/12/18.
 */

public class BannerBean {

    /**
     * APICode : 0
     * ErrorCode : 0
     * ErrorMessage : 成功
     * Data : [{"ID":"6","Title":"新手闯关","Type":"8","ImgUrl":"ADImg/201704/06052640647.png","Url":"a"},{"ID":"5","Title":"每日任务","Type":"9","ImgUrl":"ADImg/201704/06052616258.png","Url":"a"},{"ID":"1","Title":"哆哆2.0正式上线","Type":"2","ImgUrl":"ADImg/201704/06051128154.png","Url":"1"}]
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
        /**
         * ID : 6
         * Title : 新手闯关
         * Type : 8
         * ImgUrl : ADImg/201704/06052640647.png
         * Url : a
         */

        private String ID;
        private String Title;
        private String Type;
        private String ImgUrl;
        private String Url;

        public String getID() {
            return ID;
        }

        public void setID(String ID) {
            this.ID = ID;
        }

        public String getTitle() {
            return Title;
        }

        public void setTitle(String Title) {
            this.Title = Title;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public String getImgUrl() {
            return ImgUrl;
        }

        public void setImgUrl(String ImgUrl) {
            this.ImgUrl = ImgUrl;
        }

        public String getUrl() {
            return Url;
        }

        public void setUrl(String Url) {
            this.Url = Url;
        }
    }
}
