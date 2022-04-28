package com.example.pats_community.model;

import java.util.List;

/**
 * 获取识别结果响应实体
 * baike_info无法被实例化错误
 */
public class GetDiscernResultResponse {


    /*private long log_id;
    private int result_num;*/
    private List<ResultBean> result;
/*
    public long getLog_id() {
        return log_id;
    }

    public void setLog_id(long log_id) {
        this.log_id = log_id;
    }

    public int getResult_num() {
        return result_num;
    }

    public void setResult_num(int result_num) {
        this.result_num = result_num;
    }*/

    public List<ResultBean> getResult() {
        return result;
    }

    public void setResult(List<ResultBean> result) {
        this.result = result;
    }

    public static class ResultBean {

        private double score;
        private String root;
        private BaikeInfoBean baike_info;
        private String keyword;

        public void setScore(double score) {
            this.score = score;
        }
        public void setRoot(String root) {
            this.root = root;
        }
        public void setBaike_info(BaikeInfoBean baike_info) {
            this.baike_info = baike_info;
        }
        public void setKeyword(String keyword) {
            this.keyword = keyword;
        }

        public String getRoot() {
            return root;
        }

        public double getScore() {
            return score;
        }

        public BaikeInfoBean getBaike_info() {
            return baike_info;
        }

        public String getKeyword() {
            return keyword;
        }

        public static class BaikeInfoBean {


            private String baike_url;
            private String image_url;
            private String description;

            public String getBaike_url() {
                return baike_url;
            }

            public void setBaike_url(String baike_url) {
                this.baike_url = baike_url;
            }

            public String getImage_url() {
                return image_url;
            }

            public void setImage_url(String image_url) {
                this.image_url = image_url;
            }

            public String getDescription() {
                return description;
            }

            public void setDescription(String description) {
                this.description = description;
            }
        }
    }
}

