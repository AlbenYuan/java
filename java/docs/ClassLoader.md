# ClassLoader
类加载器，根据一个类的全限定名来读取此类的二进制字节流到JVM中，然后转换为一个与目标类对应的`java.lang.Class`对象实例。
开发人员每封装的一个类(包括其静态变量、静态方法、声明的属性和行为)，在使用前，虚拟机都会把其加载中，为其创建一个`Class`对象。

## Java运行过程


### java执行过程
新建一个未加载类的对象是的执行过程：如下
1. 静态代码（静态属性，静态代码块，依次执行）
1. 属性代码（成员属性，构造代码块，依次执行）
3. 构造方法。

### java编译过程

### 编译过程
 
词法分析和输入到符号表、注解处理、语义分析和生成字节码。具体流程如下：
1. .java文件
1. 词法分析器 
1. tokens流 
1. 语法分析器 
1. 语法树/抽象语法树 
1. 语义分析器 
1. 注解抽象语法树 
1. 字节码生成器 
1. .class文件

### class文件
class文件为JVM加载的源文件，其内容包含一下内容
  - 结构信息：class文件相关信息。
  -  元数据：Java源码中的声明和常量信息。
  -  方法信息：Java源码语句和表达式对应的字节码。
  
  
### JIT编译器的工作流程
1. JVM字节码 
1. 机器无关优化 
1. 中间代码 
1. 机器相关优化 
1. 中间代码 
1. 寄存器分配器 
1. 中间代码 
1. 目标机器码生成器 
1. 目标机器码
  
## 类加载过程

1. 加载
   
   记载字节码文件，为其创建`Class`对象

1. 验证
   
   目的在于确保`Class`文件的字节流中包含信息符合当前虚拟机要求，不会危害虚拟机自身安全。主要包括四种验证，文件格式验证，元数据验证，字节码验证，符号引用验证。

1. 准备
   
   为类变量(即`static`修饰的字段变量)分配内存并且设置该类变量的初始值即0(如`static int i=5;`这里只将i初始化为0，至于5的值将在初始化时赋值)，这里不包含用`final`修饰的`static`，因为`final`在编译的时候就会分配了，注意这里不会为实例变量分配初始化，类变量会分配在方法区中，而实例变量是会随着对象一起分配到Java堆中。

1. 解析
   
   主要将常量池中的符号引用替换为直接引用的过程。符号引用就是一组符号来描述目标，可以是任何字面量，而直接引用就是直接指向目标的指针、相对偏移量或一个间接定位到目标的句柄。有类或接口的解析，字段解析，类方法解析，接口方法解析

1. 初始化
   
   类加载最后阶段，若该类具有超类，则对其进行初始化，执行静态初始化器和静态初始化成员变量(如前面只初始化了默认值的`static`变量将会在这个阶段赋值，成员变量也将被初始化)。

## 加载
  在虚拟机提供了3种类加载器1、引导（Bootstrap）类加载器，2、扩展（Extension）类加载器，3、系统（System）类加载器（也称应用类加载器）。

### 启动（Bootstrap）类加载器
顶层的加载类，由使用C++语言实现，是虚拟机自身的一部分。加载的是JVM自身需要的类，`%JRE_HOME%\lib\`下的`rt.jar`、`resources.jar`、`charsets.jar`和class等。
也可`-Xbootclasspath`参数指定的路径下的jar包加载到内存中。指定目录时，文件名必须为虚拟机可识别的文件名。出于安全考虑，Bootstrap启动类加载器只加载包名为java、javax、sun等开头的类

### 扩展（Extension）类加载器
扩展类加载器负责加载%JAVA_HOME%/lib/ext中的所有类库，只要jar包放置这个位置，就会被虚拟机加载。

### 系统（System）类加载器
系统加载器，又称Application ClassLoader，负责加载`%CLASSPATH%`路径的类库,以及其它自定义的ClassLoader。缺省情况下，它是用户创建的任何ClassLoader的父ClassLoader。

### 自定义类加载器


## 加载模式

### 双亲委派模式工作原理
双亲委派模式要求除了顶层的启动类加载器外，其余的类加载器都应当有自己的父类加载器，请注意双亲委派模式中的父子关系并非通常所说的类继承关系，而是采用组合关系来复用父类加载器的相关代码，类加载器间的关系如下
#### 执行逻辑
当一个类加载器被调用去加载一个类时:
1. 查询当前类加载器中是否已经加载该类，
2. 如果已经加载，则返回已经加载的类，如果无则执行下一步
3. 检查当前类加载器是否有父加载器，如果有则调用父加载器加载该类
4. 父类加载器加载失败或者无父类加载器，则该类加载器开始加载该类并返回
  ```
protected Class<?> loadClass(String name, boolean resolve)
        throws ClassNotFoundException
    {
        synchronized (getClassLoadingLock(name)) {
            // First, check if the class has already been loaded
            Class<?> c = findLoadedClass(name);
            if (c == null) {
                long t0 = System.nanoTime();
                try {
                    if (parent != null) {
                        c = parent.loadClass(name, false);
                    } else {
                        c = findBootstrapClassOrNull(name);
                    }
                } catch (ClassNotFoundException e) {
                    // ClassNotFoundException thrown if class not found
                    // from the non-null parent class loader
                }

                if (c == null) {
                    // If still not found, then invoke findClass in order
                    // to find the class.
                    long t1 = System.nanoTime();
                    c = findClass(name);

                    // this is the defining class loader; record the stats
                    sun.misc.PerfCounter.getParentDelegationTime().addTime(t1 - t0);
                    sun.misc.PerfCounter.getFindClassTime().addElapsedTimeFrom(t1);
                    sun.misc.PerfCounter.getFindClasses().increment();
                }
            }
            if (resolve) {
                resolveClass(c);
            }
            return c;
        }
    }
  ```
### 双亲委派模式优势
1. 避免重复加载
   > 当父亲已经加载了该类时，就没有必要子ClassLoader再加载一次
2. 避免核心类被篡改
   > 当加载与核心类库同名的类时，这种模式会返回已经加载的类，而不会重新加载该类。

### 调用方法

* `public Class<?> loadClass(String name) throws ClassNotFoundException`

   加载类，

* `protected final Class<?> findLoadedClass(String name) `

  查找已经加载类

* `protected Class<?> findClass(String name) throws ClassNotFoundException`

  查找类，自定义类加载器时，需要实现该部分业务需求

* `protected final Class<?> defineClass(String name, byte[] b, int off, int len, ProtectionDomain protectionDomain)
           throws ClassFormatError`
           
  将byte字节流解析成JVM能够识别的Class对象

* `protected final void resolveClass(Class<?> c)`

  使用该方法可以使用类的Class对象创建完成也同时被解析。前面我们说链接阶段主要是对字节码进行验证，为类变量分配内存并设置初始值同时将字节码文件中的符号引用转换为直接引用。
  
  
## 类加载器的关系

类加载器之间的关系，是指parent属性的依赖关系，而非继承关系。

1. 启动类加载器，由C++实现，没有父类。

2. 拓展类加载器(ExtClassLoader)，由Java语言实现，父类加载器为null

3. 系统类加载器(AppClassLoader)，由Java语言实现，父类加载器为ExtClassLoader

4. 自定义类加载器，父类加载器肯定为AppClassLoader。


