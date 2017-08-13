package com.lin.amusement.service.entity;

import java.util.List;

/**
 * Created by 18374 on 2017/8/13.
 */

public class Joke {

    private List<DataBean> data;

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * share_start : 34
         * user_name : 伤ㄋ、谁疼
         * dislike_start : 4
         * _created_at : 2017-08-13T14:30:04.000+0800
         * avatar : http://image.uc.cn/s/uae/g/0q/avatar/15.png
         * content : 我来一个灵异的，在八九十年代的农村，那是就要到了收割稻子的时候，有一家老奶奶前段时间突然生病卧床不起，，，就在割稻子的时候身体又好了，我们几个小孩到他家玩，她告诉我们说，他告诉抓他的小鬼，先别急抓他，说他的儿子现在正在收割稻子，忙，等稻子收割完了再来抓他，，，…后来等到稻子收割完了，，，她就去世了
         * _updated_at : 2017-08-13T15:00:25.000+0800
         * _incrs : {"like":3,"dislike":2,"share":1}
         * _pos : 1502606707925
         * tag : 段子
         * _id : c0e0437c2c6762ace0a846654cbee698
         * like_start : 24
         * media_data : []
         */

        private int share_start;
        private String user_name;
        private int dislike_start;
        private String _created_at;
        private String avatar;
        private String content;
        private String _updated_at;
        private IncrsBean _incrs;
        private long _pos;
        private String tag;
        private String _id;
        private int like_start;
        private List<?> media_data;

        public int getShare_start() {
            return share_start;
        }

        public void setShare_start(int share_start) {
            this.share_start = share_start;
        }

        public String getUser_name() {
            return user_name;
        }

        public void setUser_name(String user_name) {
            this.user_name = user_name;
        }

        public int getDislike_start() {
            return dislike_start;
        }

        public void setDislike_start(int dislike_start) {
            this.dislike_start = dislike_start;
        }

        public String get_created_at() {
            return _created_at;
        }

        public void set_created_at(String _created_at) {
            this._created_at = _created_at;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String get_updated_at() {
            return _updated_at;
        }

        public void set_updated_at(String _updated_at) {
            this._updated_at = _updated_at;
        }

        public IncrsBean get_incrs() {
            return _incrs;
        }

        public void set_incrs(IncrsBean _incrs) {
            this._incrs = _incrs;
        }

        public long get_pos() {
            return _pos;
        }

        public void set_pos(long _pos) {
            this._pos = _pos;
        }

        public String getTag() {
            return tag;
        }

        public void setTag(String tag) {
            this.tag = tag;
        }

        public String get_id() {
            return _id;
        }

        public void set_id(String _id) {
            this._id = _id;
        }

        public int getLike_start() {
            return like_start;
        }

        public void setLike_start(int like_start) {
            this.like_start = like_start;
        }

        public List<?> getMedia_data() {
            return media_data;
        }

        public void setMedia_data(List<?> media_data) {
            this.media_data = media_data;
        }

        public static class IncrsBean {
            /**
             * like : 3
             * dislike : 2
             * share : 1
             */

            private int like;
            private int dislike;
            private int share;

            public int getLike() {
                return like;
            }

            public void setLike(int like) {
                this.like = like;
            }

            public int getDislike() {
                return dislike;
            }

            public void setDislike(int dislike) {
                this.dislike = dislike;
            }

            public int getShare() {
                return share;
            }

            public void setShare(int share) {
                this.share = share;
            }
        }
    }
}
