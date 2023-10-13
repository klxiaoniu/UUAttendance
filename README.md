# UU考勤安卓客户端项目文档

## 项目功能介绍

- UU考勤，通过数据上云处理，结合手机的便携性、易用性，实现即时定点签到、课表课程查看、请销假管理、点名督导等功能。

## 技术栈与项目亮点

- 使用安卓原生技术开发，稳定性强、效率高、适配范围广，隐私权限要求少；
- 创新卡片滑动交互方式实现督导操作；
- 依托高德地图定位技术实现用户定位、地图查看功能；
- 采用MVVM技术架构实现用户界面和业务逻辑分离；
- 借助WebSocket长连接技术提升信息触达率，确保点名时信息的即时传递；
- 依托Glide实现图片形态信息传输；
- 依托Retrofit2以及二层封装，大幅简化了网络操作；
- 依托MMKV实现高性能和安全性的数据存储；
- 通过BaseActivity、BaseFragment等封装，增加代码复用率。
