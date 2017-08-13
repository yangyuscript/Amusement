#   使用MVP+Retrofit+Rxjava+RxAndroid搭建一款看段子看美图的app
=================================================================
##  [原始框架demo源码请看我另一个github项目](https://github.com/yangyuscript/MVP.Retrofit.Rxjava.git)
##  [框架搭建教程](http://blog.csdn.net/yangyuscript/article/details/76878538)
---------
### 1.截图
    ![](https://github.com/yangyuscript/Amusement/raw/master/app/screenshot/1.jpg)
    ![](https://github.com/yangyuscript/Amusement/raw/master/app/screenshot/2.jpg)

### 2.功能特点
####    2.1段子数据来源于网络接口http://napi.uc.cn/3/classes/topic/lists/%E6%AE%B5%E5%AD%90?_app_id=hottopic&_size=10&_fetch=1&_fetch_incrs=1&_max_pos=1502574304587&_fetch_total=1&_select=like_start%2Cdislike_start%2Ctitle%2Ctag%2Cmedia_data%2Clist_info%2Ccontent%2Cavatar%2Cuser_name%2Cis_hot%2Chot_comment%2Ccomment_total%2Coriginal%2Ctv_duration
####    2.2图片使用瀑布流的形式展现主要是RecyclerView和CardView结合显示，图片数据来源于网络接口https://image.baidu.com/search/acjson?tn=resultjson_com&ipn=rj&ct=201326592&is=&fp=result&queryWord=%E7%BE%8E%E5%A5%B3&cl=2&lm=-1&ie=utf-8&oe=utf-8&adpicid=&st=-1&z=&ic=0&word=%E7%BE%8E%E5%A5%B3&s=&se=&tab=&width=&height=&face=0&istype=2&qc=&nc=1&fr=&cg=girl&rn=30&gsm=78&1502355291876=&pn=120/<br>
####    2.3底部导航使用的Android自带的Bottom Navigation Activity结合Fragment实现 [教程地址](http://blog.csdn.net/yangyuscript/article/details/76606116)

### 3.声明
欢迎大家issue，如果引用请注明github地址