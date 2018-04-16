# [String](#String ) &[StringBuffer](#StringBuffer ) &[StringBuilder](#StringBuilder )


<h2 id="String">String</h2>

## 属性
 * private final char value[];
 * private int hash;
 * private int hash;

* 对象不可改变
* 

```java
public final class String
    implements java.io.Serializable, Comparable<String>, CharSequence {
    // ...
}
```


<h2 id="StringBuffer">StringBuffer</h2>
```java
 public final class StringBuffer
    extends AbstractStringBuilder
    implements java.io.Serializable, CharSequence{
    // ...
}
```
## 属性
 * value char[]
 * count int
 * capacity 
 * toStringCache
 * 
 
## 扩容逻辑



<h2 id="StringBuilder">StringBuilder</h2>