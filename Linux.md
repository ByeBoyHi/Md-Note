# Linux

## 一、联网

- nmcli c up ens33:激活当前的网络链接
- 修改配置文件： vim /etc/sysconfig/network-scripts/ifcfg-ens33 
  - ONBOOT=yes。
  - esc退出，然后 `:wq` 保存并退出文本编辑器。这时候，上面设置的nmcli就是永久性的了。
- 链接网址进行测试：`curl http://www.baidu.com`



## 二、在Linux下安装包

### 1. 安装Twisted

- 下载Twisted：`wget https://twistedmatrix.com/Releases/Twisted/17.1/Twisted-17.1.0.tar.bz2` ，下载的目录是你执行该命令的目录。
- 解压Twisted：`tar -xvf Twisted-17.1.0.tar.bz2`
- 进入Twisted-17.1.0目录：`cd Twisted-17.1.0`
- 开始安装（如果出现错误，则可使用离线安装依赖包的方式，执行rpm -Uvh *.rpm --nodeps --force）进行离线安装依赖包：`python3 setup.py install`

### 2. 安装Scrapy（依赖Twisted）