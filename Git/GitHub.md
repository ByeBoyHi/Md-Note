# Git

## 一、基础概念

### 1. Git的三种状态和三个区域

![](F:\桌面\Git\三个状态.png)

### 2. 分支

实现协同合作

![](F:\桌面\Git\分支.png)



## 二、常用命令

- 初始化：git init
- 查看状态：git status
- 添加文件到暂存区：git add <文件名(要有后缀名)>  --> 放入暂存区
- 把暂存区的文件放回来：git restore --staged <文件>...
- 将暂存区放入仓库：git commit -m '备注内容'  --> 把暂存区的所有文件都提交到git仓库
- 查看被修改的文件的前后对比：git diff <文件名(后缀名)>   -->进入前后对比的界面（q退出当前界面）
- 查看每一次提交的详细信息：git log    --> 有commit、author等内容
- 回退或进入某一次提交：**git checkout <该次提交的commit前几位(4位以上)即可>**
  - 可以直接 git checkout master  --> 来到分支master
  - 在进行状态转换的时候，git文件里面的内容也会变成该状态的内容
  - 可以通过 **git checkout <文件名>** 回到最新一次 commit 的时候文件的状态，会让自己的错误修改复原。（被删除后的文件也可以通过这个操作也复原找回来——只要曾经提交过这个文件）
- 如果某个被删除的文件在git项目中彻底不想要了，可以：
  - git rm <文件名>  彻底删除  --> 执行此命令后，再次进行commit提交，认可本次删除

- **创建分支并切换到该分支节点：**
  - **git checkout -b <分支名字>   ---> 新建分支 (-b  branch)**
  - **git branch <分支名字>   ---> 当分支存在的时候会提示已经存在**
  - 在某个分支上的操作，不会对其他分支进行影响。

- **合并分支：git merge <分支名字>     --> 会和你当前所在节点进行合并**
  - 比如现在有两个分支：master 和 test
  - 你在master分支上用：git merge test  会让test合并到master上
  - 你在test分支上用：git merge master  会让master合并到test上
  - 当已经合并后，进行此操作，会让两个分支跑到一个节点上
  - 虽然一个节点上共存两个分支，但是你在某一分支上进行操作时，对于同一节点的另一个分支是不影响的。
- 查看分支有哪些：git branch
- 删除分支：git branch -d <分支名字>  （当没有写参数-d时，会新建一个分支）

- **当两个分支里面有同一个文件被修改，`修改的内容无论是否在同一个位置`，在进行合并的时候，都会合并失败，提示修正冲突后提交修正结果再合并**
  - 对于冲突的文件，git会有命令行提示
  - 冲突文件里面的内容也有会提示
  - 进行手动修正冲突后，再进行提交，会自动合并成功



## 三、标签

- 添加标签：git tag <标签名字>
  - 这时候可以通过标签切换：git checkout <标签名字>
- 删除表情：git tag -d <标签名字>   （参数 -d 就是delete）
- 查看目前有哪些标签：git tag



## 四、储藏

- 当进行更改后，我们突然需要回到过去的某一步进行操作，当前的更改需要暂时的储藏：**git stash**   然后我们会回退到上一步 

- 当我们需要把储藏的修改拿出来的时候：**git stash pop**
- 当储藏区里面有多个储藏数据的时候：**git stash apply stash@{数字}**   也就是要取出第几个储藏的数据，n个数据则是从0 到 n-1
- 丢弃储藏区中的某一个的时候：**git stash drop stash@{数字}**
- 清空储藏区所有东西：**git stash clear**