# 备忘

## 常用快捷键

| 按键            | 作用                                         |
| --------------- | -------------------------------------------- |
| `Ctrl+d`        | 键盘输入结束或退出终端                       |
| `Ctrl+s`        | 暂停当前程序，暂停后按下任意键恢复运行       |
| `Ctrl+z`        | 将当前程序放到后台运行，恢复到前台为命令`fg` |
| `Ctrl+a`        | 将光标移至输入行头，相当于`Home`键           |
| `Ctrl+e`        | 将光标移至输入行末，相当于`End`键            |
| `Ctrl+k`        | 删除从光标所在位置到行末                     |
| `Alt+Backspace` | 向前删除一个单词                             |
| `Shift+PgUp`    | 将终端显示向上滚动                           |
| `Shift+PgDn`    | 将终端显示向下滚动                           |

## Shell 常用通配符：

| 字符                    | 含义                                           |
| ----------------------- | ---------------------------------------------- |
| `*`                     | 匹配 0 或多个字符                              |
| `?`                     | 匹配任意一个字符                               |
| `[list]`                | 匹配 list 中的任意单一字符                     |
| `[^list]`               | 匹配 除 list 中的任意单一字符以外的字符        |
| `[c1-c2]`               | 匹配 c1-c2 中的任意单一字符 如：\[0-9\]\[a-z\] |
| `{string1,string2,...}` | 匹配 string1 或 string2 (或更多)其一字符串     |
| `{c1..c2}`              | 匹配 c1-c2 中全部字符 如{1..10}                |

##  用户及文件权限管理





#### 权限



你可能除了知道最后面那一项是文件名之外，其它项就不太清楚了，那么到底是什么意思呢：

![权限](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108103555.png)

可能你还是不太明白，比如第一项文件类型和权限那一堆东西具体指什么，链接又是什么，何为最后修改时间，下面一一道来：

![权限](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108103600.png)

#### `adduser` 和 `useradd` 的区别是什么

答：`useradd` 只创建用户，不会创建用户密码和工作目录，创建完了需要使用 `passwd <username>` 去设置新用户的密码。`adduser` 在创建用户的同时，会创建工作目录和密码（提示你设置），做这一系列的操作。其实 `useradd`、`userdel` 这类操作更像是一种命令，执行完了就返回。而 `adduser` 更像是一种程序，需要你输入、确定等一系列操作。



## Linux 目录结构及文件基本操作

> `FHS`（英文：`Filesystem Hierarchy Standard` 中文：文件系统层次结构标准），多数 Linux 版本采用这种文件组织形式，FHS 定义了系统中每个区域的用途、所需要的最小构成的文件和目录同时还给出了例外处理与矛盾处理。

[FHS_3.0 标准文档](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108105830.pdf)

![FHS](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108105222.png)

![目录定义为四种交互作用的形态](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108105330.png)

### 查看文件类型

与 Windows 不同的是，如果你新建了一个 shiyanlou.txt 文件，Windows 会自动把它识别为文本文件，而 `file` 命令会识别为一个空文件。这个前面我提到过，在 Linux 中文件的类型不是根据文件后缀来判断的。当你在文件里输入内容后才会显示文件类型。

![查看文件类型](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108112204.png)

## 环境变量与文件查找

### 环境变量的声明赋值

```bash
declare tmp
tmp=shiyanlou
echo $tmp
```

![环境变量的声明赋值](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108113555.png)

### 变量修改

变量的修改有以下几种方式：

| 变量设置方式                   | 说明                                         |
| ------------------------------ | -------------------------------------------- |
| `${变量名#匹配字串}`           | 从头向后开始匹配，删除符合匹配字串的最短数据 |
| `${变量名##匹配字串}`          | 从头向后开始匹配，删除符合匹配字串的最长数据 |
| `${变量名%匹配字串}`           | 从尾向前开始匹配，删除符合匹配字串的最短数据 |
| `${变量名%%匹配字串}`          | 从尾向前开始匹配，删除符合匹配字串的最长数据 |
| `${变量名/旧的字串/新的字串}`  | 将符合旧字串的第一个字串替换为新的字串       |
| `${变量名//旧的字串/新的字串}` | 将符合旧字串的全部字串替换为新的字串         |

比如我们可以修改前面添加到 PATH 的环境变量，将添加的 mybin 目录从环境变量里删除。为了避免操作失误导致命令找不到，我们先将 PATH 赋值给一个新的自定义变量 mypath：

```bash
mypath=$PATH
echo $mypath
mypath=${mypath%/home/shiyanlou/mybin}
# 或使用通配符 * 表示任意多个任意字符
mypath=${mypath%*/mybin}
```

可以看到路径已经不存在了。

![变量修改](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108115530.png)

### 变量删除

可以使用 `unset` 命令删除一个环境变量：

```bash
unset mypath
```

![变量删除](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108115535.png)

### 环境变量立即生效

使用 `source` 命令来让其立即生效，如：

```bash
cd /home/shiyanlou
source .zshrc
```

`source` 命令还有一个别名就是 `.`，上面的命令如果替换成 `.` 的方式就该是：

```bash
. ./.zshrc
```

![环境变量立即生效](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210108115650.png)



### 搜索文件

与搜索相关的命令常用的有 `whereis`，`which`，`find` 和 `locate`。

- `whereis` 简单快速
  
- `whereis` 只能搜索二进制文件（`-b`），man 帮助文件（`-m`）和源代码文件（`-s`）。
  
- `locate` 快而全

  - 使用 `locate` 命令查找文件也不会遍历硬盘，它通过查询 `/var/lib/mlocate/mlocate.db` 数据库来检索信息。

  -  `updatedb` 命令来更新数据库

  - 统计数目可以加上 `-c` 参数，`-i` 参数可以忽略大小写进行查找，`whereis` 的 `-b`、`-m`、`-s` 同样可以使用。

  - 安装

    ```bash
    sudo apt-get update
    sudo apt-get install locate
    sudo updatedb
    ```

- `which` 小而精

  - `which` 本身是 Shell 内建的一个命令，我们通常使用 `which` 来确定是否安装了某个指定的程序，因为它只从 `PATH` 环境变量指定的路径中去搜索命令并且返回第一个搜索到的结果

- `find` 精而细

  - `find` 应该是这几个命令中最强大的了，它不但可以通过文件类型、文件名进行查找而且可以根据文件的属性（如文件的时间戳，文件的权限等）进行搜索。

  - > **注意 find 命令的路径是作为第一个参数的， 基本命令格式为 find [path][option] [action] 。**





### 文件打包与解压缩

#### 概念

在讲 Linux 上的压缩工具之前，有必要先了解一下常见常用的压缩包文件格式。在 Windows 上最常见的不外乎这两种 `*.zip`，`*.7z` 后缀的压缩文件。而在 Linux 上面常见的格式除了以上两种外，还有 `.rar`，`*.gz`，`*.xz`，`*.bz2`，`*.tar`，`*.tar.gz`，`*.tar.xz`，`*.tar.bz2`，简单介绍如下：

| 文件后缀名 | 说明                           |
| ---------- | ------------------------------ |
| `*.zip`    | zip 程序打包压缩的文件         |
| `*.rar`    | rar 程序压缩的文件             |
| `*.7z`     | 7zip 程序压缩的文件            |
| `*.tar`    | tar 程序打包，未压缩的文件     |
| `*.gz`     | gzip 程序（GNU zip）压缩的文件 |
| `*.xz`     | xz 程序压缩的文件              |
| `*.bz2`    | bzip2 程序压缩的文件           |
| `*.tar.gz` | tar 打包，gzip 程序压缩的文件  |
| `*.tar.xz` | tar 打包，xz 程序压缩的文件    |
| `*tar.bz2` | tar 打包，bzip2 程序压缩的文件 |
| `*.tar.7z` | tar 打包，7z 程序压缩的文件    |

####  zip 

- 压缩

  - 使用 zip 打包文件夹，注意输入完整的参数和路径：

  ```bash
  cd /home/shiyanlou
  zip -r -q -o shiyanlou.zip /home/shiyanlou/Desktop
  du -h shiyanlou.zip
  file shiyanlou.zip
  ```

  上面命令将目录 `/home/shiyanlou/Desktop` 打包成一个文件，并查看了打包后文件的大小和类型。第一行命令中，`-r` 参数表示递归打包包含子目录的全部内容，`-q` 参数表示为安静模式，即不向屏幕输出信息，`-o`，表示输出文件，需在其后紧跟打包输出文件名。后面使用 `du` 命令查看打包后文件的大小（后面会具体说明该命令）。

  - 设置压缩级别为 9 和 1（9 最大，1 最小），重新打包：

  ```bash
  zip -r -9 -q -o shiyanlou_9.zip /home/shiyanlou/Desktop -x ~/*.zip
  zip -r -1 -q -o shiyanlou_1.zip /home/shiyanlou/Desktop -x ~/*.zip
  ```

  这里添加了一个参数用于设置压缩级别 `-[1-9]`，1 表示最快压缩但体积大，9 表示体积最小但耗时最久。最后那个 `-x` 是为了排除我们上一次创建的 zip 文件，否则又会被打包进这一次的压缩文件中，**注意：这里只能使用绝对路径，否则不起作用**。

  我们再用 `du` 命令分别查看默认压缩级别、最低、最高压缩级别及未压缩的文件的大小：

  ```bash
  du -h -d 0 *.zip ~ | sort
  ```

  通过 man 手册可知：

  - `-h`， --human-readable（顾名思义，你可以试试不加的情况）
  - `-d`， --max-depth（所查看文件的深度）

  ![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110115850.jpeg)

  这样一目了然，理论上来说默认压缩级别应该是最高的，但是由于文件不大，这里的差异不明显（几乎看不出差别），不过你在环境中操作之后看到的压缩文件大小可能跟图上的有些不同，因为系统在使用过程中，会随时生成一些缓存文件在当前用户的家目录中，这对于我们学习命令使用来说，是无关紧要的，可以忽略这些不同。

  - 创建加密 zip 包

  使用 `-e` 参数可以创建加密压缩包：

  ```bash
  zip -r -e -o shiyanlou_encryption.zip /home/shiyanlou/Desktop
  ```

  **注意：** 关于 `zip` 命令，因为 Windows 系统与 Linux/Unix 在文本文件格式上的一些兼容问题，比如换行符（为不可见字符），在 Windows 为 CR+LF（Carriage-Return+Line-Feed：回车加换行），而在 Linux/Unix 上为 LF（换行），所以如果在不加处理的情况下，在 Linux 上编辑的文本，在 Windows 系统上打开可能看起来是没有换行的。如果你想让你在 Linux 创建的 zip 压缩文件在 Windows 上解压后没有任何问题，那么你还需要对命令做一些修改：

  ```bash
  zip -r -l -o shiyanlou.zip /home/shiyanlou/Desktop
  ```

  需要加上 `-l` 参数将 `LF` 转换为 `CR+LF` 来达到以上目的。

- 解压

  - 将 `shiyanlou.zip` 解压到当前目录：

    ```bash
    unzip shiyanlou.zip
    ```

    使用安静模式，将文件解压到指定目录：

    ```bash
    unzip -q shiyanlou.zip -d ziptest
    ```

    上述指定目录不存在，将会自动创建。如果你不想解压只想查看压缩包的内容你可以使用 `-l` 参数：

    ```bash
    unzip -l shiyanlou.zip
    ```

    **注意：** 使用 unzip 解压文件时我们同样应该注意兼容问题，不过这里我们关心的不再是上面的问题，而是中文编码的问题，通常 Windows 系统上面创建的压缩文件，如果有有包含中文的文档或以中文作为文件名的文件时默认会采用 GBK 或其它编码，而 Linux 上面默认使用的是 UTF-8 编码，如果不加任何处理，直接解压的话可能会出现中文乱码的问题（有时候它会自动帮你处理），为了解决这个问题，我们可以在解压时指定编码类型。

    使用 `-O`（英文字母，大写 o）参数指定编码类型：

    ```bash
    unzip -O GBK 中文压缩文件.zip
    ```

#### tar

- 在 Linux 上面更常用的是 `tar` 工具，tar 原本只是一个打包工具，只是同时还是实现了对 7z、gzip、xz、bzip2 等工具的支持，这些压缩工具本身只能实现对文件或目录（单独压缩目录中的文件）的压缩，没有实现对文件的打包压缩，所以我们也无需再单独去学习其他几个工具，tar 的解压和压缩都是同一个命令，只需参数不同，使用比较方便。

  下面先掌握 `tar` 命令一些基本的使用方式，即不进行压缩只是进行打包（创建归档文件）和解包的操作。

  - 创建一个 tar 包：

  ```bash
  cd /home/shiyanlou
  tar -P -cf shiyanlou.tar /home/shiyanlou/Desktop
  ```

  上面命令中，`-P` 保留绝对路径符，`-c` 表示创建一个 tar 包文件，`-f` 用于指定创建的文件名，注意文件名必须紧跟在 `-f` 参数之后，比如不能写成 `tar -fc shiyanlou.tar`，可以写成 `tar -f shiyanlou.tar -c ~`。你还可以加上 `-v` 参数以可视的的方式输出打包的文件。

  - 解包一个文件（`-x` 参数）到指定路径的**已存在**目录（`-C` 参数）：

  ```bash
  mkdir tardir
  tar -xf shiyanlou.tar -C tardir
  ```

  - 只查看不解包文件 `-t` 参数：

  ```bash
  tar -tf shiyanlou.tar
  ```

  - 保留文件属性和跟随链接（符号链接或软链接），有时候我们使用 tar 备份文件当你在其他主机还原时希望保留文件的属性（`-p` 参数）和备份链接指向的源文件而不是链接本身（`-h` 参数）：

  ```bash
  tar -cphf etc.tar /etc
  ```

  对于创建不同的压缩格式的文件，对于 tar 来说是相当简单的，需要的只是换一个参数，这里我们就以使用 `gzip` 工具创建 `*.tar.gz` 文件为例来说明。

  - 我们只需要在创建 tar 文件的基础上添加 `-z` 参数，使用 `gzip` 来压缩文件：

  ```bash
  tar -czf shiyanlou.tar.gz /home/shiyanlou/Desktop
  ```

  - 解压 `*.tar.gz` 文件：

  ```bash
  tar -xzf shiyanlou.tar.gz
  ```

  ![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110120031.png)

  现在我们要使用其它的压缩工具创建或解压相应文件只需要更改一个参数即可：

  | 压缩文件格式 | 参数 |
  | ------------ | ---- |
  | `*.tar.gz`   | `-z` |
  | `*.tar.xz`   | `-J` |
  | `*tar.bz2`   | `-j` |

  > tar 命令的参数很多，不过常用的就是上述这些，需要了解更多你可以查看 man 手册获取帮助。



#### 总结

说了这么多，其实平常使用的参数并没有那么复杂，只需要记住常用的组合就可以了。 常用命令：

- zip：
- 打包 ：zip something.zip something （目录请加 -r 参数）
- 解包：unzip something.zip
- 指定路径：-d 参数
- tar：
- 打包：tar -cf something.tar something
- 解包：tar -xf something.tar
- 指定路径：-C 参数

## 文件系统操作与磁盘管理

- `du`
  - 查看目录的容量
- `df`
  - 查看磁盘的容量
- `dd`
  - 用于转换和复制文件，不过它的复制不同于 `cp`。
  - `dd` 的命令行语句与其他的 Linux 程序不同，因为它的命令行选项格式为 **选项=值**，而不是更标准的 **--选项 值** 或 **-选项=值**。`dd` 默认从标准输入中读取，并写入到标准输出中，但可以用选项 `if`（input file，输入文件）和 `of`（output file，输出文件）改变。

## Linux下的帮助命令

### 内建命令与外部命令

什么是内建命令，什么是外部命令呢？这和帮助命令又有什么关系呢？

因为有一些查看帮助的工具在内建命令与外建命令上是有区别对待的。

> **内建命令**实际上是 shell 程序的一部分，其中包含的是一些比较简单的 Linux 系统命令，这些命令是写在 bash 源码的 builtins 里面的，由 shell 程序识别并在 shell 程序内部完成运行，通常在 Linux 系统加载运行时 shell 就被加载并驻留在系统内存中。而且解析内部命令 shell 不需要创建子进程，因此其执行速度比外部命令快。比如：history、cd、exit 等等。

> **外部命令**是 Linux 系统中的实用程序部分，因为实用程序的功能通常都比较强大，所以其包含的程序量也会很大，在系统加载时并不随系统一起被加载到内存中，而是在需要时才将其调入内存。虽然其不包含在 shell 中，但是其命令执行过程是由 shell 程序控制的。外部命令是在 Bash 之外额外安装的，通常放在/bin，/usr/bin，/sbin，/usr/sbin 等等。比如：ls、vi 等。

简单来说就是：一个是天生自带的天赋技能，一个是后天得来的附加技能。我们可以使用　 type 命令来区分命令是内建的还是外部的。例如这两个得出的结果是不同的

```bash
type exit

type vim
```

得到的是两种结果，若是对 ls 你还能得到第三种结果

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110204054.png)

```bash
# 得到这样的结果说明是内建命令，正如上文所说内建命令都是在 bash 源码中的 builtins 的.def中
xxx is a shell builtin
# 得到这样的结果说明是外部命令，正如上文所说，外部命令在/usr/bin or /usr/sbin等等中
xxx is /usr/bin/xxx
# 若是得到alias的结果，说明该指令为命令别名所设定的名称；
xxx is an alias for xx --xxx
```

### help 命令

本实验环境是 zsh，而 zsh 中内置并没有 help 命令，我们可以进入 bash 中，在 bash 中内置有该命令

```bash
bash
```

做好了以上的准备，我们就可以愉快的使用 help 命令了，我们可以尝试下这个命令:

```bash
help ls
```

得到的结果如图所示，为什么是这样的结果？

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110204527.png)

因为 help 命令是用于显示 shell 内建命令的简要帮助信息。帮助信息中显示有该命令的简要说明以及一些参数的使用以及说明，一定记住 help 命令只能用于显示内建命令的帮助信息，不然就会得到你刚刚得到的结果。

那如果是外部命令怎么办，不能就这么抛弃它呀。其实外部命令基本上都有一个参数 `--help`，这样就可以得到相应的帮助，看到你想要的东西了。试试下面这个命令是不是能看到你想要的东西了。

```bash
ls --help
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110204530.png)

###  man 命令

你可以尝试下这个命令

```bash
man ls
```

![实验楼](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110204607.png)

得到的内容比用 help 更多更详细，而且　 man 　没有内建与外部命令的区分，因为 man 工具是显示系统手册页中的内容，也就是一本电子版的字典，这些内容大多数都是对命令的解释信息，还有一些相关的描述。通过查看系统文档中的 man 也可以得到程序的更多相关信息和 Linux 的更多特性。

是不是好用许多，当然也不代表 help 就没有存在的必要，当你非常紧急只是忘记该用哪个参数的时候，help 这种显示简单扼要的信息就特别实用，若是不太紧急的时候就可以用 man 这种详细描述的查询方式

在尝试上面这个命令时我们会发现最左上角显示“ LS （1）”，在这里，“ LS ”表示手册名称，而“（1）”表示该手册位于第一章节。这个章节又是什么？在 man 手册中一共有这么几个章节

| 章节数 | 说明                                                |
| ------ | --------------------------------------------------- |
| `1`    | Standard commands （标准命令）                      |
| `2`    | System calls （系统调用）                           |
| `3`    | Library functions （库函数）                        |
| `4`    | Special devices （设备说明）                        |
| `5`    | File formats （文件格式）                           |
| `6`    | Games and toys （游戏和娱乐）                       |
| `7`    | Miscellaneous （杂项）                              |
| `8`    | Administrative Commands （管理员命令）              |
| `9`    | 其他（Linux 特定的）， 用来存放内核例行程序的文档。 |

打开手册之后我们可以通过 pgup 与 pgdn 或者上下键来上下翻看，可以按 q 退出当前页面

### info 命令

要是你觉得 man 显示的信息都还不够，满足不了你的需求，那试试 info 命令，注意实验楼的环境中没有安装 info，可以手动安装，安装和操作步骤如下：

```bash
# 安装 info
sudo apt-get update
sudo apt-get install info
# 查看 ls 命令的 info
info ls
```

![Info_for_ls](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110204651.png)

得到的信息是不是比 man 还要多了，info 来自自由软件基金会的 GNU 项目，是 GNU 的超文本帮助系统，能够更完整的显示出 GNU 信息。所以得到的信息当然更多

man 和 info 就像两个集合，它们有一个交集部分，但与 man 相比，info 工具可显示更完整的　 GNU 　工具信息。若 man 页包含的某个工具的概要信息在 info 中也有介绍，那么 man 页中会有“请参考 info 页更详细内容”的字样。

## Linux任务计划`crontab`

> `crontab` 命令常见于 `Unix` 和类 `Unix` 的操作系统之中（`Linux` 就属于类 `Unix` 操作系统），用于设置周期性被执行的指令。

###  `crontab` 简介

crontab 命令从输入设备读取指令，并将其存放于 crontab 文件中，以供之后读取和执行。通常，crontab 储存的指令被守护进程激活，crond 为其守护进程，crond 常常在后台运行，每一分钟会检查一次是否有预定的作业需要执行。

通过 crontab 命令，我们可以在固定的间隔时间执行指定的系统指令或 shell 脚本。时间间隔的单位可以是分钟、小时、日、月、周的任意组合。

这里我们看一看 crontab 的格式：

```bash
# Example of job definition:
# .---------------- minute (0 - 59)
# |  .------------- hour (0 - 23)
# |  |  .---------- day of month (1 - 31)
# |  |  |  .------- month (1 - 12) OR jan,feb,mar,apr ...
# |  |  |  |  .---- day of week (0 - 6) (Sunday=0 or 7) OR sun,mon,tue,wed,thu,fri,sat
# |  |  |  |  |
# *  *  *  *  * user-name command to be executed
```

### `crontab` 准备

crontab 在本实验环境中需要做一些特殊的准备，首先我们会启动 `rsyslog`，以便我们可以通过日志中的信息来了解我们的任务是否真正的被执行了（在本实验环境中需要手动启动，而在自己本地中 Ubuntu 会默认自行启动不需要手动启动）。

```bash
sudo apt-get install -y rsyslog
sudo service rsyslog start
```

![service-rsyslog-start](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211239.png)

在本实验环境中 crontab 也是不被默认启动的，同时不能在后台由 upstart 来管理，所以需要我们来启动它:

```bash
sudo cron －f &
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211239.png)

### `crontab` 使用

下面将开始 crontab 的使用了，我们通过下面一个命令来添加一个计划任务：

```bash
crontab -e
```

第一次启动会出现这样一个画面，这是让我们选择编辑的工具，选择第二个基本的 vim 就可以了。

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211435.png)

而选择后我们会进入这样一个画面，这就是添加计划的地方了，与一般的配置文档相同，以#号开头的都是注释，通过文档的最后一排我们可以猜猜 crontab 的格式是什么样的呢？

![实验楼](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211431.png)

详细的格式可以使用上一节中学习到的 man 命令查看：

```bash
man crontab
```

在了解命令格式之后，我们通过这样的一个例子来完成一个任务的添加，在文档的最后一排加上这样一排命令，该任务是每分钟我们会在/home/shiyanlou 目录下创建一个以当前的年月日时分秒为名字的空白文件

```bash
*/1 * * * * touch /home/shiyanlou/$(date +\%Y\%m\%d\%H\%M\%S)
```

**注意：**

> “ % ” 在 crontab 文件中，有结束命令行、换行、重定向的作用，前面加 ” \ ” 符号转义，否则，“ % ” 符号将执行其结束命令行或者换行的作用，并且其后的内容会被做为标准输入发送给前面的命令。

添加成功后我们会得到最后一排 installing new crontab 的一个提示：

![实验楼](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211426.png)

当然我们也可以通过这样的一个指令来查看我们添加了哪些任务：

```bash
crontab -l
```

通过图中的显示，我们也可以看出，我们正确的保存并且添加成功了该任务的：

![实验楼](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211421.png)

虽然我们添加了任务，但是如果 `cron` 的守护进程并没有启动，它根本都不会监测到有任务，当然也就不会帮我们执行，我们可以通过以下 2 种方式来确定我们的 `cron` 是否成功的在后台启动，默默的帮我们做事，若是没有就得执行上文准备中的第二步了。

```bash
ps aux | grep cron

# or

pgrep cron
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211417.png)

通过下图可以看到任务在创建之后，执行了几次，生成了一些文件，且每分钟生成一个：

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211413.png)

我们通过这样一个命令可以查看到执行任务命令之后在日志中的信息反馈：

```bash
sudo tail -f /var/log/syslog
```

从图中我们可以看到分别在 13 点 28、29、30 分的 01 秒为我们在 shiyanlou 用户的家目录下创建了文件。

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211409.png)

当我们并不需要这个任务的时候我们可以使用这么一个命令去删除任务：

```bash
crontab -r
```

通过图中我们可以看出我们删除之后再查看任务列表，系统已经显示该用户并没有任务哦。

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211406.png)

### `crontab` 的深入

每个用户使用 `crontab -e` 添加计划任务，都会在 `/var/spool/cron/crontabs` 中添加一个该用户自己的任务文档，这样目的是为了隔离。

![实验楼](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211511.png)

如果是系统级别的定时任务，需要 root 权限执行的任务应该怎么处理？

只需要使用 `sudo` 编辑 `/etc/crontab` 文件就可以。

`cron` 服务监测时间最小单位是分钟，所以 `cron` 会每分钟去读取一次 `/etc/crontab` 与 `/var/spool/cron/crontabs` 里面的內容。

在 `/etc` 目录下，`cron` 相关的目录有下面几个：

![实验楼](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110211516.png)

每个目录的作用：

1. `/etc/cron.daily`，目录下的脚本会每天执行一次，在每天的 6 点 25 分时运行；
2. `/etc/cron.hourly`，目录下的脚本会每个小时执行一次，在每小时的 17 分钟时运行；
3. `/etc/cron.monthly`，目录下的脚本会每月执行一次，在每月 1 号的 6 点 52 分时运行；
4. `/etc/cron.weekly`，目录下的脚本会每周执行一次，在每周第七天的 6 点 47 分时运行；

系统默认执行时间可以根据需求进行修改。

## 命令执行顺序控制与管道

#### 命令执行顺序的控制

通常情况下，我们每次只能在终端输入一条命令，按下回车执行，执行完成后，我们再输入第二条命令，然后再按回车执行。当有时候我们会一次输入多条命令，这个时候的执行过程又是如何的呢？下面我们将为大家详细讲解下命令的执行顺序的控制问题。

##### 顺序执行多条命令

当我们需要使用 `apt-get` 安装一个软件，然后安装完成后立即运行安装的软件或命令工具，又恰巧你的主机才更换的软件源还没有更新软件列表（比如之前我们的环境中，每次重新开始实验就得 `sudo apt-get update`，否则可能会报错提示 404），那么你可能会有如下一系列操作：

```bash
sudo apt-get update
# 等待执行完毕，然后输入下面的命令
sudo apt-get install some-tool # 这里 some-tool 需要替换成具体的软件包
# 等待安装完毕，然后输入软件包名称执行
some-tool
```

这时你可能就会想：要是我可以一次性输入完，让它自己去依次执行各命令就好了，这就是我们这一小节要解决的问题。

简单的顺序执行你可以使用 `;` 来完成，比如上述操作你可以：

```bash
sudo apt-get update;sudo apt-get install some-tool;some-tool # 让它自己运行
```

##### 有选择的执行命令

关于上面的操作，不知你有没有思考过一个问题，如果我们在让它自动顺序执行命令时，前面的命令执行不成功，而后面的命令又依赖于上一条命令的结果，那么就会造成花了时间，最终却得到一个错误的结果，而且有时候直观的看你还无法判断结果是否正确。那么我们需要能够有选择性的来执行命令，比如上一条命令执行成功才继续下一条，或者不成功又该做出其它什么处理，比如我们使用 `which` 来查找是否安装某个命令，如果找到就执行该命令，否则什么也不做，虽然这个操作没有什么实际意义，但可帮你更好的理解一些概念：

```bash
which cowsay>/dev/null && cowsay -f head-in ohch~
```

你如果没有安装 `cowsay`，你可以先执行一次上述命令，你会发现什么也没发生，你再安装好之后你再执行一次上述命令，你也会发现一些惊喜。

上面的 `&&` 就是用来实现选择性执行的，它表示如果前面的命令执行结果（不是表示终端输出的内容，而是表示命令执行状态的结果）返回 0 则执行后面的，否则不执行，你可以从 `$?` 环境变量获取上一次命令的返回结果：

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214133.png)

学习过 C 语言的用户应该知道在 C 语言里面 `&&` 表示逻辑与，而且还有一个 `||` 表示逻辑或，同样 Shell 也有一个 `||`，它们的区别就在于，shell 中的这两个符号除了也可用于表示逻辑与和或之外，就是可以实现这里的命令执行顺序的简单控制。`||` 在这里就是与 `&&` 相反的控制效果，当上一条命令执行结果为 `≠0(\$?≠0)` 时则执行它后面的命令：

```bash
which cowsay>/dev/null || echo "cowsay has not been install, please run 'sudo apt-get install cowsay' to install"
```

除了上述基本的使用之外，我们还可以结合着 `&&` 和 `||` 来实现一些操作，比如：

```bash
which cowsay>/dev/null && echo "exist" || echo "not exist"
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214129.png)

我画个流程图来解释一下上面的流程：

![1](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214123.png)

#### 管道

管道是一种通信机制，通常用于进程间的通信（也可通过 socket 进行网络通信），它表现出来的形式就是将前面每一个进程的输出（stdout）直接作为下一个进程的输入（stdin）。

管道又分为匿名管道和具名管道（这里将不会讨论在源程序中使用系统调用创建并使用管道的情况，它与命令行的管道在内核中实际都是采用相同的机制）。我们在使用一些过滤程序时经常会用到的就是匿名管道，在命令行中由 `|` 分隔符表示，`|` 在前面的内容中我们已经多次使用到了。具名管道简单的说就是有名字的管道，通常只会在源程序中用到具名管道。下面我们就将通过一些常用的可以使用管道的过滤程序来帮助你熟练管道的使用。

##### 试用

先试用一下管道，比如查看 `/etc` 目录下有哪些文件和目录，使用 `ls` 命令来查看：

```bash
ls -al /etc
```

有太多内容，屏幕不能完全显示，这时候可以使用滚动条或快捷键滚动窗口来查看。不过这时候可以使用管道：

```bash
ls -al /etc | less
```

通过管道将前一个命令(`ls`)的输出作为下一个命令(`less`)的输入，然后就可以一行一行地看。

##### `cut` 命令，打印每一行的某一字段

打印 `/etc/passwd` 文件中以 `:` 为分隔符的第 1 个字段和第 6 个字段分别表示用户名和其家目录：

```
cut /etc/passwd -d ':' -f 1,6
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214318.png)

打印 `/etc/passwd` 文件中每一行的前 N 个字符：

```bash
# 前五个（包含第五个）
cut /etc/passwd -c -5
# 前五个之后的（包含第五个）
cut /etc/passwd -c 5-
# 第五个
cut /etc/passwd -c 5
# 2 到 5 之间的（包含第五个）
cut /etc/passwd -c 2-5
```

#####  `grep` 命令，在文本中或 `stdin` 中查找匹配字符串

`grep` 命令是很强大的，也是相当常用的一个命令，它结合正则表达式可以实现很复杂却很高效的匹配和查找，不过在学习正则表达式之前，这里介绍它简单的使用，而关于正则表达式后面将会有单独一小节介绍到时会再继续学习 `grep` 命令和其他一些命令。

`grep` 命令的一般形式为：

```bash
grep [命令选项]... 用于匹配的表达式 [文件]...
```

还是先体验一下，我们搜索`/home/shiyanlou`目录下所有包含"shiyanlou"的文本文件，并显示出现在文本中的行号：

```bash
grep -rnI "shiyanlou" ~
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214357.png)

`-r` 参数表示递归搜索子目录中的文件，`-n` 表示打印匹配项行号，`-I` 表示忽略二进制文件。这个操作实际没有多大意义，但可以感受到 `grep` 命令的强大与实用。

当然也可以在匹配字段中使用正则表达式，下面简单的演示：

```bash
# 查看环境变量中以 "yanlou" 结尾的字符串
export | grep ".*yanlou$"
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214357.png)

其中`$`就表示一行的末尾。

#####  `wc` 命令，简单小巧的计数工具

wc 命令用于统计并输出一个文件中行、单词和字节的数目，比如输出 `/etc/passwd` 文件的统计信息：

```bash
wc /etc/passwd
```

分别只输出行数、单词数、字节数、字符数和输入文本中最长一行的字节数：

```bash
# 行数
wc -l /etc/passwd
# 单词数
wc -w /etc/passwd
# 字节数
wc -c /etc/passwd
# 字符数
wc -m /etc/passwd
# 最长行字节数
wc -L /etc/passwd
```

**注意：对于西文字符来说，一个字符就是一个字节，但对于中文字符一个汉字是大于 2 个字节的，具体数目是由字符编码决定的。**

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214428.png)

再来结合管道来操作一下，下面统计 /etc 下面所有目录数：

```bash
ls -dl /etc/*/ | wc -l
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214428.png)

##### `sort` 排序命令

这个命令前面我们也是用过多次，功能很简单就是将输入按照一定方式排序，然后再输出，它支持的排序有按字典排序，数字排序，按月份排序，随机排序，反转排序，指定特定字段进行排序等等。

默认为字典排序：

```bash
cat /etc/passwd | sort
```

反转排序：

```bash
cat /etc/passwd | sort -r
```

按特定字段排序：

```bash
cat /etc/passwd | sort -t':' -k 3
```

上面的`-t`参数用于指定字段的分隔符，这里是以":"作为分隔符；`-k 字段号`用于指定对哪一个字段进行排序。这里`/etc/passwd`文件的第三个字段为数字，默认情况下是以字典序排序的，如果要按照数字排序就要加上`-n`参数：

```bash
cat /etc/passwd | sort -t':' -k 3 -n
```

注意观察第二个冒号后的数字： ![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214513.png)

##### `uniq` 去重命令

`uniq` 命令可以用于过滤或者输出重复行。

- 过滤重复行

我们可以使用 `history` 命令查看最近执行过的命令（实际为读取 `${SHELL}_history` 文件，如我们环境中的 `.zsh_history` 文件），不过你可能只想查看使用了哪个命令而不需要知道具体干了什么，那么你可能就会要想去掉命令后面的参数然后去掉重复的命令：

```bash
history | cut -c 8- | cut -d ' ' -f 1 | uniq
```

然后经过层层过滤，你会发现确是只输出了执行的命令那一列，不过去重效果好像不明显，仔细看你会发现它确实去重了，只是不那么明显，之所以不明显是因为 `uniq` 命令只能去连续重复的行，不是全文去重，所以要达到预期效果，我们先排序：

```bash
history | cut -c 8- | cut -d ' ' -f 1 | sort | uniq
# 或者
history | cut -c 8- | cut -d ' ' -f 1 | sort -u
```

这就是 Linux/UNIX 哲学吸引人的地方，大繁至简，一个命令只干一件事却能干到最好。

- 输出重复行

```bash
# 输出重复过的行（重复的只输出一个）及重复次数
history | cut -c 8- | cut -d ' ' -f 1 | sort | uniq -dc
# 输出所有重复的行
history | cut -c 8- | cut -d ' ' -f 1 | sort | uniq -D
```

文本处理命令还有很多，下一节将继续介绍一些常用的文本处理的命令。

#### 轻松一下

使用以前介绍过的方法，安装`aview`和`imagemagick`，然后用`asciiview`命令显示图片，使用方法可以用 man 命令查看。

Linus 大神的照片地址 https://labfile.oss.aliyuncs.com/courses/1/Linus.png

![1](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214601.png)

执行以下命令安装工具包并下载图片：

```bash
sudo apt update

sudo apt install -y aview imagemagick

wget https://labfile.oss.aliyuncs.com/courses/1/Linus.png
```

执行 `asciiview [图片文件名]` 即可打开图片：

![图片描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210110214553.png)

## 简单的文本处理

### `tr` 命令

tr 命令可以用来删除一段文本信息中的某些文字。或者将其进行转换。

#### 使用方式

```bash
tr [option]...SET1 [SET2]
```

#### 常用的选项有

| 选项 | 说明                                                         |
| ---- | ------------------------------------------------------------ |
| `-d` | 删除和 set1 匹配的字符，注意不是全词匹配也不是按字符顺序匹配 |
| `-s` | 去除 set1 指定的在输入文本中连续并重复的字符                 |

#### 操作举例

```bash
# 删除 "hello shiyanlou" 中所有的'o'，'l'，'h'
$ echo 'hello shiyanlou' | tr -d 'olh'
# 将"hello" 中的ll，去重为一个l
$ echo 'hello' | tr -s 'l'
# 将输入文本，全部转换为大写或小写输出
$ echo 'input some text here' | tr '[:lower:]' '[:upper:]'
# 上面的'[:lower:]' '[:upper:]'你也可以简单的写作'[a-z]' '[A-Z]'，当然反过来将大写变小写也是可以的
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210111152409.png)

### `col` 命令

col 命令可以将`Tab`换成对等数量的空格键，或反转这个操作。

#### 使用方式

```bash
col [option]
```

#### 常用的选项有

| 选项 | 说明                          |
| ---- | ----------------------------- |
| `-x` | 将`Tab`转换为空格             |
| `-h` | 将空格转换为`Tab`（默认选项） |

#### 操作举例

```bash
# 查看 /etc/protocols 中的不可见字符，可以看到很多 ^I ，这其实就是 Tab 转义成可见字符的符号
cat -A /etc/protocols
# 使用 col -x 将 /etc/protocols 中的 Tab 转换为空格，然后再使用 cat 查看，你发现 ^I 不见了
cat /etc/protocols | col -x | cat -A
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210111152443.png)

### `join` 命令

这个命令就是用于将两个文件中包含相同内容的那一行合并在一起。

#### 使用方式

```bash
join [option]... file1 file2
```

#### 常用的选项有

| 选项 | 说明                                                 |
| ---- | ---------------------------------------------------- |
| `-t` | 指定分隔符，默认为空格                               |
| `-i` | 忽略大小写的差异                                     |
| `-1` | 指明第一个文件要用哪个字段来对比，默认对比第一个字段 |
| `-2` | 指明第二个文件要用哪个字段来对比，默认对比第一个字段 |

#### 操作举例

```bash
cd /home/shiyanlou
# 创建两个文件
echo '1 hello' > file1
echo '1 shiyanlou' > file2
join file1 file2
# 将 /etc/passwd 与 /etc/shadow 两个文件合并，指定以':'作为分隔符
sudo join -t':' /etc/passwd /etc/shadow
# 将 /etc/passwd 与 /etc/group 两个文件合并，指定以':'作为分隔符，分别比对第4和第3个字段
sudo join -t':' -1 4 /etc/passwd -2 3 /etc/group
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210111152514.png) ![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210111152510.png)

### `paste`命令

`paste`这个命令与`join` 命令类似，它是在不对比数据的情况下，简单地将多个文件合并一起，以`Tab`隔开。

#### 使用方式

```bash
paste [option] file...
```

#### 常用的选项有

| 选项 | 说明                         |
| ---- | ---------------------------- |
| `-d` | 指定合并的分隔符，默认为 Tab |
| `-s` | 不合并到一行，每个文件为一行 |

#### 操作举例

```bash
echo hello > file1
echo shiyanlou > file2
echo www.shiyanlou.com > file3
paste -d ':' file1 file2 file3
paste -s file1 file2 file3
```

![此处输入图片的描述](https://gitee.com/bgst009/markdownPicUrl/raw/master/20210111152534.png)

### **命令手动完成 dos 文本格式到 UNIX 文本格式的转换。**

