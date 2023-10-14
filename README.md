# UU考勤安卓客户端项目文档

## 项目功能介绍

> 本项目是一个跨平台考勤系统，主要提供课前请假、教师审批、考勤申诉、督导点名、定位签到、指定督导等功能，分为学生端/督导端，和教师端。学生/督导端实现课表查看、课前请假、考勤申诉、定位签到、督导操作等功能，采用安卓原生技术，以Kotlin为主要开发语言进行开发。
>
> 教师端仓库地址：https://github.com/ROBINRUGAN/uu-attendance
>
> 后端仓库地址：https://github.com/flying-pig-z/uuAttendance

## 工作流程图

[![img](https://user-images.githubusercontent.com/117554874/266471478-7116ec22-125f-4689-8ab5-fb33f2a9fb28.png)](https://user-images.githubusercontent.com/117554874/266471478-7116ec22-125f-4689-8ab5-fb33f2a9fb28.png)

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

## 目录结构介绍

```
uuAttendance/  
├────.gitignore  
├────build.gradle  
├────libs/  
├────proguard-rules.pro  
├────src/  
│    ├────androidTest/  
│    │    └────java/  
│    │    │    └────com/  
│    │    │    │    └────uu/  
│    │    │    │    │    └────attendance/  
│    │    │    │    │    │    └────ExampleInstrumentedTest.kt                           //测试类
│    ├────main/  
│    │    ├────AndroidManifest.xml  
│    │    ├────java/  
│    │    │    └────com/  
│    │    │    │    └────uu/  
│    │    │    │    │    └────attendance/  
│    │    │    │    │    │    ├────base/                                                //抽象基类
│    │    │    │    │    │    │    ├────dto/                                            //数据类
│    │    │    │    │    │    │    └────ui/                                             //界面相关
│    │    │    │    │    │    ├────model/  
│    │    │    │    │    │    │    ├────Constants.kt                                    //常量  
│    │    │    │    │    │    │    └────network/                                        //网络请求相关  
│    │    │    │    │    │    │    │    ├────api/                                       //请求接口封装  
│    │    │    │    │    │    │    │    ├────dto/                                       //数据类  
│    │    │    │    │    │    │    │    └────service/                                   //请求服务  
│    │    │    │    │    │    ├────MyApplication.kt  
│    │    │    │    │    │    ├────ui/                                                  //界面相关  
│    │    │    │    │    │    │    ├────common/                                         //通用组件  
│    │    │    │    │    │    │    │    └────view/  
│    │    │    │    │    │    │    │    │    └────RoundImageView.kt                     //自实现圆形图片  
│    │    │    │    │    │    │    ├────coursetable/                                    //课程表tab部分  
│    │    │    │    │    │    │    │    ├────activity/  
│    │    │    │    │    │    │    │    │    └────NewLeaveApplicationActivity.kt        //请假申请  
│    │    │    │    │    │    │    │    ├────adapter/  
│    │    │    │    │    │    │    │    │    └────CourseTableAdapter.kt                 //课程表适配器
│    │    │    │    │    │    │    │    ├────fragment/                                  //课程表界面
│    │    │    │    │    │    │    │    │    ├────CourseTableFragment.kt  
│    │    │    │    │    │    │    │    │    └────CourseTableItemFragment.kt  
│    │    │    │    │    │    │    │    └────view/                                      //课程表自定义view
│    │    │    │    │    │    │    │    │    └────CourseDetailPopup.kt
│    │    │    │    │    │    │    ├────login/登录部分  
│    │    │    │    │    │    │    │    └────activity/  
│    │    │    │    │    │    │    │    │    └────LoginActivity.kt                      //登录界面
│    │    │    │    │    │    │    ├────main/主界面部分  
│    │    │    │    │    │    │    │    ├────activity/    
│    │    │    │    │    │    │    │    │    └────MainActivity.kt                       //主界面
│    │    │    │    │    │    │    │    └────viewmodel/  
│    │    │    │    │    │    │    │    │    └────MainViewModel.kt                      //主界面公用数据存储  
│    │    │    │    │    │    │    ├────me/                                             //我的tab部分  
│    │    │    │    │    │    │    │    ├────activity/  
│    │    │    │    │    │    │    │    │    ├────AttendanceAppealActivity.kt           //考勤申诉查看  
│    │    │    │    │    │    │    │    │    ├────ChangePwdActivity.kt                  //修改密码  
│    │    │    │    │    │    │    │    │    ├────LeaveApplicationActivity.kt           //请假申请查看  
│    │    │    │    │    │    │    │    │    └────RulesActivity.kt                      //考勤规则  
│    │    │    │    │    │    │    │    ├────adapter/  
│    │    │    │    │    │    │    │    │    ├────ApplicationListAdapter.kt             //请假申请列表适配器
│    │    │    │    │    │    │    │    │    └────AttendanceAppealAdapter.kt            //考勤申诉列表适配器
│    │    │    │    │    │    │    │    ├────fragment/  
│    │    │    │    │    │    │    │    │    └────MeFragment.kt                         //我的界面
│    │    │    │    │    │    │    │    └────view/  
│    │    │    │    │    │    │    │    │    └────ItemFunctionEntryView.kt              //功能项view  
│    │    │    │    │    │    │    ├────signin/                                         //签到tab部分  
│    │    │    │    │    │    │    │    ├────fragment/   
│    │    │    │    │    │    │    │    │    └────SigninFragment.kt                     //签到界面
│    │    │    │    │    │    │    │    ├────view/   
│    │    │    │    │    │    │    │    │    └────MapContainerLayout.kt                 //地图容器
│    │    │    │    │    │    │    │    └────viewmodel/  
│    │    │    │    │    │    │    │    │    └────SigninViewModel.kt                    //签到界面数据存储
│    │    │    │    │    │    │    └────supervise/                                      //督导tab部分  
│    │    │    │    │    │    │    │    ├────activity/  
│    │    │    │    │    │    │    │    │    └────SuperviseDetailActivity.kt            //督导详情  
│    │    │    │    │    │    │    │    ├────adapter/  
│    │    │    │    │    │    │    │    │    ├────SuperviseCardAdapter.kt               //督导卡片适配器
│    │    │    │    │    │    │    │    │    ├────SuperviseListAdapter.kt               //督导列表适配器
│    │    │    │    │    │    │    │    │    ├────SuperviseStudentDetailAdapter.kt      //督导学生详情适配器
│    │    │    │    │    │    │    │    │    └────ViewPagerSuperviseDetailAdapter.kt    //督导详情viewpager适配器
│    │    │    │    │    │    │    │    ├────fragment/  
│    │    │    │    │    │    │    │    │    ├────SuperviseCardFragment.kt              //督导卡片界面
│    │    │    │    │    │    │    │    │    ├────SuperviseFragment.kt                  //督导界面
│    │    │    │    │    │    │    │    │    └────SuperviseListFragment.kt              //督导列表界面
│    │    │    │    │    │    │    │    ├────view/  
│    │    │    │    │    │    │    │    │    └────cardswipelayout                       //卡片交互实现  
│    │    │    │    │    │    │    │    │    │    ├────CardConfig.kt                    //卡片配置
│    │    │    │    │    │    │    │    │    │    ├────CardItemTouchHelperCallback.kt   //卡片交互回调
│    │    │    │    │    │    │    │    │    │    ├────CardLayoutManager.kt             //卡片布局管理器
│    │    │    │    │    │    │    │    │    │    └────OnSwipeListener.kt               //卡片交互监听
│    │    │    │    │    │    │    │    └────viewmodel/  
│    │    │    │    │    │    │    │    │    └────SuperviseViewModel.kt                 //督导界面数据存储
│    │    │    │    │    │    └────util/工具类  
│    │    │    │    │    │    │    ├────ConnectionUtil.kt                               //网络连接工具类
│    │    │    │    │    │    │    ├────ConvertUtil.kt                                  //转换工具类
│    │    │    │    │    │    │    ├────CoroutineUtil.kt                                //协程工具类
│    │    │    │    │    │    │    ├────CrashUtil.kt                                    //崩溃工具类
│    │    │    │    │    │    │    ├────KeyboardUtil.kt                                 //键盘工具类
│    │    │    │    │    │    │    ├────KVUtil.kt                                       //键值对工具类
│    │    │    │    │    │    │    ├────LatLngUtil.kt                                   //经纬度工具类
│    │    │    │    │    │    │    ├────LogUtil.kt                                      //日志工具类
│    │    │    │    │    │    │    └────UriPathHelper.kt                                //uri工具类
│    │    └────res/                                                                     //布局与资源  
│    │    │    ├────drawable/                                                           //图片资源
│    │    │    ├────drawable-mdpi/                                                   
│    │    │    ├────drawable-xhdpi/   
│    │    │    ├────drawable-xxhdpi/  
│    │    │    ├────drawable-xxxhdpi/  
│    │    │    ├────layout/                                                             //布局文件
│    │    │    ├────menu/                                                               //菜单布局配置文件
│    │    │    ├────mipmap-hdpi/                                                        //图标资源
│    │    │    ├────mipmap-mdpi/   
│    │    │    ├────mipmap-xhdpi/  
│    │    │    ├────mipmap-xxhdpi/  
│    │    │    ├────mipmap-xxxhdpi/  
│    │    │    ├────values/   
│    │    │    │    ├────attr.xml                                                       //属性配置文件
│    │    │    │    ├────colors.xml                                                     //颜色配置文件 
│    │    │    │    ├────strings.xml                                                    //字符串配置文件
│    │    │    │    └────themes.xml                                                     //主题配置文件
│    │    │    └────xml/  
│    │    │    │    ├────backup_rules.xml                                               //备份规则配置文件
│    │    │    │    └────data_extraction_rules.xml                                      //数据提取规则配置文件
│    └────test/  
│    │    └────java/  
│    │    │    └────com/  
│    │    │    │    └────uu/  
│    │    │    │    │    └────attendance/  
│    │    │    │    │    │    └────ExampleUnitTest.kt                                   //测试类
└────tree.py
```
