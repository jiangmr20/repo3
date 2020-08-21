**创建本地git仓库**

**1、创建本地文件夹，朕姑且命名为** **test_Git**



**2、右键空白处，单击****Git Bash Here****（Ps：不要进入到空文件夹“Test_Git”，直接在它的父级目录中右键空白处）**





**3、在bash界面，使用git命令“git svn clone”将SVN项目转成Git项目：**

git svn clone svn路径 --no-metadata --username SVN账号 转换后Git项目的名字



·no-metadata阻止git导出SVN包含的一些无用信息。

·--username后面为svn账号



示例：

git svn clone svn://103.123.922.111/Common/trunk/project/java/ent                                                                                                                                                                                               erpriseProducts --no-metadata --username aaa test_Git



回车执行后，表示将svn://03.123.922.111/Common/trunk/trunk/qmp这个项目拉取下来，并转成本地的Git项目“Test_Git”。

PS: 代码从SVN下载并将历史记录转成git记录需要一点时间，而你此时需要一杯coffee。



**4、A few minutes later, 朕终于获得了一个Git本地仓库，漂亮：**



**5、朕要看看git本地的仓库日志, 噢，最后的修改人是阿江啊：**

git log



**6、为了方便以后留下自己的大名，朕建议你全局设置下你的name和email:**

git config user.name 你的目标用户名;

git config user.email 你的目标邮箱名;





**3** / **创建远程gitlab仓库**

**1、本章节主要针对拥有小组长权限的用户使用

**2、进入 ux_dev 群组中，点击 New project 按钮，进入创建界面，注意要设置为 Private的仓库属性：** 

**3、Duang， 恭喜你创建了一个远程仓库，由于项目还是空的，我们需要关联本地仓库与远程仓库，并将本地代码推送到远程仓库中**



**4、进入到本地的 test_Git项目右键空白处，单击Git Bash HereGit，进入命令行模式，在Test_Git项目下，执行添加远程仓库绑定的命令：**

git remote add <远程仓库简称> <url> 

示例：git remote add origin https://xxx.com/ux_dev/test_Git.git



表示为本地仓库test_Git添加一个远程仓库关联，取名为origin



**5、将本地仓库的代码推送至远程库**

​	git push <远程仓库简称> <本地分支名>:<远程分支名>



Ps：上面的git svn clone命令默认是将原SVN项目的代码和历史提交记录都转到了Test_Git的master分支上。所以这里我们就将本地仓库的master分支推送到远程仓库的master分支：

git push origin master:master



**6、oj8k, 我们的本地代码顺利推送上远程仓库的master分支了：**



**7、进入到 https://gitlab.tech.21cn.com/ux_dev/test_Git， nice兄弟儿，已经更新了：**





**8、过程中，可能经常要求输入gitlab密码， 你能忍吗？ 反正我忍不了，那就把SSH搞一下吧，会的大神可以关掉指南了，点击“右上角头像”——“settings”：**



**9、点击左侧  SSH Keys ，你会看到了设置面板：**





**10、然后可以在git-bash窗口下，命令生成 ssh keys:** 

ssh-keygen -t rsa -C   "[mowd@corp.21cn.com](mowd@corp.21cn.com)"





**11、然后在你的电脑——用户——用户名——.ssh下会产生 id_rsa.pub ：**





**12、复制你的key到刚才的ssh keys设置框里， 点击 “Add key”:**



**13、然后，就没有然后了。**



**4** / **更多Tips**

1. **传说最好用的git客户端sourceTree:**

https://www.sourcetreeapp.com/

1. **更多git命令参考：**

https://git-scm.com/docs

