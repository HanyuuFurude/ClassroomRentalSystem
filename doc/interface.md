### 接口（3个）

* post

    * 相关方：网络、客户端
    * 功能：将客户端预约教室的请求发送到服务端
    * 调用位置：RequestMessage类下的成员函数post()
    * 使用方法：
        1.  客户端填写生成一个新的requestMessage对象并填写role和order信息
        2.  执行post()函数

    *   返回值：StatusCode，客户端由返回值类型显示“预约成功”或者报错
* get

    * 相关方：网络、服务端
    * 功能：接受客户端由post()发出的请求、提取出请求信息并查询预约，将结果以StatusCode的形式返回给客户端并记录到日志
    * 调用位置：AcknowledgeMessage类下的成员函数get()
    * 使用方法：
        1.  服务端生成一个新的AcknowledgeMessage对象并调用get()成员函数
        2.  get成员函数会生成一个线程进行阻塞式等待
        3.  当捕获到来自客户端的请求后，将requestMessage对象的信息拷贝到自己的成员中，调用数据库接口并得到StatusCode，返回给客户端，填写本对象的statusCode值
    * 返回值：本对象，用于日志记录
* login

    * 相关方：网络、客户端
    * 功能：用户登录
    * 调用位置：UserInfo类下的成员函数login()
    * 使用方法：
        1.  客户端生成一个新的UserInfo对象并填写用户名和密码的哈希值
        2.  执行login()函数
    * 返回值：Session和StatusCode元组，获得返回值后，根据StatusCode执行操作并保存Session，在重新登陆之前，使用此Session来发送请求
* acceptLogin

    * 相关方：网络、服务端
    * 功能：服务端接受用户登录
    * 调用位置：ServerUserInfo类下的成员函数acceptLogin()
    * 使用方法：
        1.  服务端生成一个新的ServerUserInfo对象并调用acceptLogin()成员函数
        2.  acceptLogin成员函数会生成一个线程进行阻塞式等待
        3.  当捕获到来自客户端的请求后，将UserInfo对象的信息拷贝到自己的成员中，调用数据库接口并得到StatusCode，若通过验证，生成Session信息，将StatusCode和Sessioni信息下发给客户端。
    * 返回值：本对象，用于挂到会话队列中等待下次申请
* logout

    * 相关方：客户端
    * 功能：服务端退出登录
    * 调用位置：UserInfo类下的logout()函数
    * 使用方法：
        1.  用户点击退出登录或者接收到超时StatusCode时，触发此函数
        2.  清除客户端的UserInfo信息（全部置为None）
    * 返回值：无（不通知服务器）
* update
    * 相关方：客户端、服务端
    * 功能：定期从服务端拉取教室占用信息并更新到ui系统上
    * 调用位置：
        * ClassInfo类下的成员函数update()
    * 使用方法：
        * 客户端生成一个ClassInfo对象、填充session并挂载到一个定期触发的线程中
        * update方法返回一个infoList和statusCode
        * 根据infoList信息绘制占用ui
    * 返回值：infoList和statusCode