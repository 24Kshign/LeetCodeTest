## 每日前端基础——全局作用域中，用const和let声明的变量存在哪里

在ES5中，顶层对象的属性与全局变量是等价的，所以使用 `var` 或 `function` 声明的全局属性都是属于顶层对象的属性，而在JS中顶层元素就是 `window`，所以可以通过 `window` 来获取声明的全局属性：

![顶层对象属性](https://upload-images.jianshu.io/upload_images/490111-04879c92037517f1.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

首先我们要知道 `const` 和 `let` 都是在ES6才出的关键字，在ES6之前是没有的，而且在ES6中，新增了一个块级作用域的概念，还有一点就是，使用 `var` 关键字定义的变量会提升到window；我们先举几个例子来说明一下什么是块级作用域：

```
var a = "外层变量"

function test1() {
    console.log(a) // 外层变量
}

// var会变量提升，提升到函数的最上面，就相当于现在函数中声明了a
// 然后在if中初始化了a，需要注意的是，变量提升只提升声明，不提升初始化
function test2() {
    console.log(a) // undefine
    if (false) {
        var a = "内层变量"
    }
    console.log(a) // 输出 undefine（若上面的if条件是true的话则输出 内层变量）
}

// let不会变量提升，所以函数内的a只在if中有效果
function test3() {
    console.log(a) // 外层变量
    if (false) {
        let a = "内层变量"
    }
    console.log(a) // 外层变量
}
```

两个大括号之间的就称之为一个块，块级作用域也就指的是在当前大括号内声明的变量只在当前大括号中有用，出了大括号就访问不到了，我们来看一下使用 `const/let` 声明的变量能不能用顶层对象访问到：

![非顶层对象属性](https://upload-images.jianshu.io/upload_images/490111-e24596a7701e2cd8.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

我们可以看到，使用 `const/let` 声明的全局变量，不属于顶层对象的属性，访问不到，那么他们存在于哪里呢？怎么能获取到呢？

![const/let声明的变量](https://upload-images.jianshu.io/upload_images/490111-e57cf720c31a8fca.png?imageMogr2/auto-orient/strip%7CimageView2/2/w/1240)

我们可以看到，使用console.dir打印了Function中所有的属性与方法，我们用 `const/let` 声明的对象存在于这里面，这个Function是个什么东西呢？前面我们说到块级作用域，函数内部都是属于块级作用域，所以最后的结论就是 **用 `const/let` 声明的全局变量存在于块级作用域中**。同时也能看出，从ES6开始，全局变量将慢慢的与顶层对象的属性脱离关系。