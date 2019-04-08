## 使用工具和框架（更新中）

工具(框架)|目的
---|---
Maven|添加管理Jar包方便，加快编译速率等
Netty|便于客户端和服务器的搭建NIO

### Maven工程概念的使用（待定）

### 为什么我使用Netty
先看一段代码
```java 
ServerSocket serverSocket = new ServerSocket(portNumber);//1
Socket clientSocket = serverSocket.accept();             //2
BufferedReader in = new BufferedReader(                     //3
        new InputStreamReader(clientSocket.getInputStream()));
PrintWriter out =
        new PrintWriter(clientSocket.getOutputStream(), true);
String request, response;
while ((request = in.readLine()) != null) {                 //4
    if ("Done".equals(request)) {                         //5
        break;
    }
}
response = processRequest(request);                        //6
out.println(response);                                    //7
}                                               
```
这是JAVA课上学的标准的服务器socket使用  
#### 问题
显然，这段代码限制每次只能处理一个连接。为了实现多个并行的客户端我们需要分配一个新的 Thread 给每个新的客户端 Socket(当然需要更多的代码)。但考虑使用这种方法来支持大量的同步，长连接。在任何时间点多线程可能处于休眠状态，等待输入或输出数据。这很容易使得资源的大量浪费，对性能产生负面影响。当然，有一种替代方案。
#### 使用Netty 
使用 Java API 构建的 NIO 建立你的应用程序的复杂度，而且这样做正确和安全是无法保证的。实现可靠和可扩展的 event-processing（事件处理器）来处理和调度数据并保证尽可能有效地，这是一个繁琐和容易出错的任务，最好留给专家 - Netty。

#### 异步和事件驱动


