package com.turbo.volleyokhttp.bean;

import com.turbo.base.net.BaseBean;

/**
 * Created by FanCheYu on 2015/9/25 0025.
 */
public class UserInfo {

    private String id;
    private String type;
    private String peerid;
    private String token;
    //    "id": "48603",
//            "type": "1",
//            "peerid": "55ff9da660b2ead562cbcb54",
//            "token": "5aa7dada68d6d77cd729929bbe515d29",
    private String session_token;
    //            "session_token": "vkixb2gttoxc23skda00fk1lg",
    private String username;
    //            "username": "18251126623",
    private String passwd;
    //            "passwd": "869bd0d8d121081496f3824727780925",
    private String nickname;
    //            "nickname": "182****662",
    private String login_type;
    //            "login_type": "1",
    private String mobile;
    //            "mobile": "18251126623",
    private String addtime;
    //            "addtime": "2015-09-21 14:03:18",
    private String initial;
    //            "initial": "",
    private String avatar;
    //            "avatar": "/mm_avatar_default.png",
    private String email;
    //            "email": "",
    private String is_ceo;
    //            "is_ceo": "0",
    private String is_allow_edit;
    //            "is_allow_edit": "0",
    private String status;
    //            "status": "1",
    private String gender;
    //            "gender": "male",
    private String province;
    //            "province": "10",
    private String city;
    //            "city": "127",
    private String university;
    //            "university": "836",
    private String address;
    //            "address": "",
    private String major;
    //            "major": "",
    private String birthday;
    //            "birthday": null,
    private String university_begin_date;
    //            "university_begin_date": null,
    private String university_end_date;
    //            "university_end_date": null,
    private String tweet_background;
    //            "tweet_background": null,
    private String coin;
    //            "coin": "0",
    private String device;
    //            "device": null,
    private String device_id;
    //            "device_id": "",
    private String mobile_location;
    //            "mobile_location": "江苏 苏州市",
    private String channel;
    //            "channel": "mmapp",
    private String exp;
    //            "exp": "0",
    private String level;
    //            "level": "0",
    private String sign;
    //            "sign": "",
    private String location_x;
    //            "location_x": "31.2598960000000",
    private String location_y;
    //            "location_y": "120.7407050000000",
    private String location_time;
    //            "location_time": "1442815401",
    private String location_status;
    //            "location_status": "1",
    private String accost;
    //            "accost": "0",
    private String modifed;
    //            "modifed": "15-09-25 16:03:03",
    private String points;
    //            "points": null,
    private String mm_device;
    //            "mm_device": "android",
    private String mm_device_id;
    //            "mm_device_id": "346790870",
    private String mc_android_app_ver;
    //            "mc_android_app_ver": "",
    private String mc_ios_app_ver;
    //            "mc_ios_app_ver": "",
    private String mm_android_app_ver;
    //            "mm_android_app_ver": "",
    private String mm_ios_app_ver;
    //            "mm_ios_app_ver": "",
    private String UUID;
    //            "UUID": "355456061536079",
    private String is_bind;
    //            "is_bind": 0,
    private String gold_coin;
    //            "gold_coin": 3,
    private String sliver_coin;
    //            "sliver_coin": 0,
    private String university_name;
    //            "university_name": "苏州大学本部",
    private String ticket;
    //            "ticket": "22b6303b1efa4a2e95620d27c7995cee",
    private String java_status;
    //            "java_status": 1,

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPeerid() {
        return peerid;
    }

    public void setPeerid(String peerid) {
        this.peerid = peerid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSession_token() {
        return session_token;
    }

    public void setSession_token(String session_token) {
        this.session_token = session_token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getLogin_type() {
        return login_type;
    }

    public void setLogin_type(String login_type) {
        this.login_type = login_type;
    }

    public String getAddtime() {
        return addtime;
    }

    public void setAddtime(String addtime) {
        this.addtime = addtime;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIs_ceo() {
        return is_ceo;
    }

    public void setIs_ceo(String is_ceo) {
        this.is_ceo = is_ceo;
    }

    public String getIs_allow_edit() {
        return is_allow_edit;
    }

    public void setIs_allow_edit(String is_allow_edit) {
        this.is_allow_edit = is_allow_edit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getUniversity_begin_date() {
        return university_begin_date;
    }

    public void setUniversity_begin_date(String university_begin_date) {
        this.university_begin_date = university_begin_date;
    }

    public String getUniversity_end_date() {
        return university_end_date;
    }

    public void setUniversity_end_date(String university_end_date) {
        this.university_end_date = university_end_date;
    }

    public String getTweet_background() {
        return tweet_background;
    }

    public void setTweet_background(String tweet_background) {
        this.tweet_background = tweet_background;
    }

    public String getCoin() {
        return coin;
    }

    public void setCoin(String coin) {
        this.coin = coin;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDevice_id() {
        return device_id;
    }

    public void setDevice_id(String device_id) {
        this.device_id = device_id;
    }

    public String getMobile_location() {
        return mobile_location;
    }

    public void setMobile_location(String mobile_location) {
        this.mobile_location = mobile_location;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public String getExp() {
        return exp;
    }

    public void setExp(String exp) {
        this.exp = exp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public String getLocation_x() {
        return location_x;
    }

    public void setLocation_x(String location_x) {
        this.location_x = location_x;
    }

    public String getLocation_y() {
        return location_y;
    }

    public void setLocation_y(String location_y) {
        this.location_y = location_y;
    }

    public String getLocation_time() {
        return location_time;
    }

    public void setLocation_time(String location_time) {
        this.location_time = location_time;
    }

    public String getLocation_status() {
        return location_status;
    }

    public void setLocation_status(String location_status) {
        this.location_status = location_status;
    }

    public String getAccost() {
        return accost;
    }

    public void setAccost(String accost) {
        this.accost = accost;
    }

    public String getModifed() {
        return modifed;
    }

    public void setModifed(String modifed) {
        this.modifed = modifed;
    }

    public String getPoints() {
        return points;
    }

    public void setPoints(String points) {
        this.points = points;
    }

    public String getMm_device() {
        return mm_device;
    }

    public void setMm_device(String mm_device) {
        this.mm_device = mm_device;
    }

    public String getMm_device_id() {
        return mm_device_id;
    }

    public void setMm_device_id(String mm_device_id) {
        this.mm_device_id = mm_device_id;
    }

    public String getMc_android_app_ver() {
        return mc_android_app_ver;
    }

    public void setMc_android_app_ver(String mc_android_app_ver) {
        this.mc_android_app_ver = mc_android_app_ver;
    }

    public String getMc_ios_app_ver() {
        return mc_ios_app_ver;
    }

    public void setMc_ios_app_ver(String mc_ios_app_ver) {
        this.mc_ios_app_ver = mc_ios_app_ver;
    }

    public String getMm_android_app_ver() {
        return mm_android_app_ver;
    }

    public void setMm_android_app_ver(String mm_android_app_ver) {
        this.mm_android_app_ver = mm_android_app_ver;
    }

    public String getMm_ios_app_ver() {
        return mm_ios_app_ver;
    }

    public void setMm_ios_app_ver(String mm_ios_app_ver) {
        this.mm_ios_app_ver = mm_ios_app_ver;
    }

    public String getUUID() {
        return UUID;
    }

    public void setUUID(String UUID) {
        this.UUID = UUID;
    }

    public String getIs_bind() {
        return is_bind;
    }

    public void setIs_bind(String is_bind) {
        this.is_bind = is_bind;
    }

    public String getGold_coin() {
        return gold_coin;
    }

    public void setGold_coin(String gold_coin) {
        this.gold_coin = gold_coin;
    }

    public String getSliver_coin() {
        return sliver_coin;
    }

    public void setSliver_coin(String sliver_coin) {
        this.sliver_coin = sliver_coin;
    }

    public String getUniversity_name() {
        return university_name;
    }

    public void setUniversity_name(String university_name) {
        this.university_name = university_name;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public String getJava_status() {
        return java_status;
    }

    public void setJava_status(String java_status) {
        this.java_status = java_status;
    }

    public String getMall_url() {
        return mall_url;
    }

    public void setMall_url(String mall_url) {
        this.mall_url = mall_url;
    }

    public String getMall_index() {
        return mall_index;
    }

    public void setMall_index(String mall_index) {
        this.mall_index = mall_index;
    }

    private String mall_url;
    //            "mall_url": "http://mall.xlingmao.com/index.php/Home/Mydata/index",
    private String mall_index;
//            "mall_index": "http://mall.xlingmao.com"


    @Override
    public String toString() {
        return "UserInfoRes{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", peerid='" + peerid + '\'' +
                ", token='" + token + '\'' +
                ", session_token='" + session_token + '\'' +
                ", username='" + username + '\'' +
                ", passwd='" + passwd + '\'' +
                ", nickname='" + nickname + '\'' +
                ", login_type='" + login_type + '\'' +
                ", mobile='" + mobile + '\'' +
                ", addtime='" + addtime + '\'' +
                ", initial='" + initial + '\'' +
                ", avatar='" + avatar + '\'' +
                ", email='" + email + '\'' +
                ", is_ceo='" + is_ceo + '\'' +
                ", is_allow_edit='" + is_allow_edit + '\'' +
                ", status='" + status + '\'' +
                ", gender='" + gender + '\'' +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", university='" + university + '\'' +
                ", address='" + address + '\'' +
                ", major='" + major + '\'' +
                ", birthday='" + birthday + '\'' +
                ", university_begin_date='" + university_begin_date + '\'' +
                ", university_end_date='" + university_end_date + '\'' +
                ", tweet_background='" + tweet_background + '\'' +
                ", coin='" + coin + '\'' +
                ", device='" + device + '\'' +
                ", device_id='" + device_id + '\'' +
                ", mobile_location='" + mobile_location + '\'' +
                ", channel='" + channel + '\'' +
                ", exp='" + exp + '\'' +
                ", level='" + level + '\'' +
                ", sign='" + sign + '\'' +
                ", location_x='" + location_x + '\'' +
                ", location_y='" + location_y + '\'' +
                ", location_time='" + location_time + '\'' +
                ", location_status='" + location_status + '\'' +
                ", accost='" + accost + '\'' +
                ", modifed='" + modifed + '\'' +
                ", points='" + points + '\'' +
                ", mm_device='" + mm_device + '\'' +
                ", mm_device_id='" + mm_device_id + '\'' +
                ", mc_android_app_ver='" + mc_android_app_ver + '\'' +
                ", mc_ios_app_ver='" + mc_ios_app_ver + '\'' +
                ", mm_android_app_ver='" + mm_android_app_ver + '\'' +
                ", mm_ios_app_ver='" + mm_ios_app_ver + '\'' +
                ", UUID='" + UUID + '\'' +
                ", is_bind='" + is_bind + '\'' +
                ", gold_coin='" + gold_coin + '\'' +
                ", sliver_coin='" + sliver_coin + '\'' +
                ", university_name='" + university_name + '\'' +
                ", ticket='" + ticket + '\'' +
                ", java_status='" + java_status + '\'' +
                ", mall_url='" + mall_url + '\'' +
                ", mall_index='" + mall_index + '\'' +
                '}';
    }
}
