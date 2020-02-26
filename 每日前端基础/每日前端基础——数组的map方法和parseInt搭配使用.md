## 每日前端基础——数组的map方法和parseInt搭配使用

在你刷算法题刷的太无聊之后，可以试着去看看别的基础知识，选几个自己感兴趣的语言，把基础知识巩固好，今天给大家分享一个比较有意思的前端题目：

```
['1', '2', '3'].map(parseInt)最后的输出结果是什么？为什么是这样的？
```
有点js基础的童鞋应该第一反应都是输出 `1，2，3`， 但是如果真是这么简单的话那我就不会单独拎出来给大家分享了，话不多说，我直接上正确答案：

![正确答案](https://upload-images.jianshu.io/upload_images/490111-df0999cbffc8a9b3.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

是不是有点惊讶，为什么会这样呢？先来了解一下js中数组的map方法以及parseInt方法。

### map方法

map() 方法用来遍历一个数组，并且返回一个新数组，新数组中的元素为原始数组元素调用函数处理后的值。

**语法**

```
array.map(function(currentValue, index, arr), thisValue)
```

我们看map中的参数，有两个，第一个参数是一个函数，这个是我们经常用到的，第二个参数为对象作为该执行回调时使用，传递给函数，一般我们都不用，再来看一下函数的三个参数：

- currentValue，必须的，表示当前元素的值
- index，不是必须的，表示当前元素的索引
- arr，不是必须的，表示当前元素属于的数组对象

### parseInt方法

parseInt() 函数可解析一个字符串，并返回一个整数。

**语法**

```
declare function parseInt(s: string, radix?: number): number;
```

这个方法也接收两个参数：

- s，必须的，表示想要转换成数字的字符串
- radix，不是必须的，表示要解析的数字的基数，取值范围是2～36之间。如果省略该参数或其值为 0，则数字将以 10 为基础来解析。如果它以 “0x” 或 “0X” 开头，将以 16 为基数。如果该参数小于 2 或者大于 36，则 parseInt() 将返回 NaN。

也就是说，后面这个参数是进制的意思；所以，我们来看一下下面这组计算：

![24K纯帅](https://upload-images.jianshu.io/upload_images/490111-32391799be914eb4.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

很好理解哈，首先当解析基数为0时，其默认为10进制，于是就有了下面这个公式：

```
假设
let A = parseInt('B', C)

那么，式子表示A的C进制是B

求parseInt('B', C) 就相当于B在C进制下的值是多少
```

打完收工，讲得这么透彻应该都理解了吧，还有一个问题就是，为什么可以把parseInt当作map的参数，回到上面map的参数，第一个参数是一个函数，而我们的parseInt本身就是一个函数，所以可以这样传，而且map函数中的参数又被作为parseInt的参数。