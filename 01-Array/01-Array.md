### 时间复杂度
T1=2*n+2   O(n)
T2=2000*n+10000   O(n)
T3=1*n*n+2    O(n*n)


T1和T2的时间复杂度是一样的，但是看表达式就知道，T2的运行时间肯定比T1高上很多


O(n)是渐进时间复杂度，描述的是n趋近于无穷的情况



关于动态数组的时间复杂度

增  addLast()  O(1)
   addFirst()  O(n)
   add()       O(n/2)  平均是n/2
   总的来说增的整体时间复杂度是O(n)
   
删 跟上面一样，总体是O(n)

查 无索引是O(1) 有索引是O(n)

改 无索引是O(1) 有索引是O(n)


均摊复杂度：我们平常分析复杂度一般是分析一个算法从头运行到尾它的复杂度是怎样的。
但我们在项目中经常会写一个复杂度较高的算法，但是这个高复杂度的算法是为了方便其他操作。
此时我们通常会将这个复杂度较高的算法和其他的操作放在一起来分析复杂度。
这个复杂度较高的算法复杂度将会均摊到其他的操作中。这种复杂度分析法我们就叫做均摊复杂度分析法
      

复杂度震荡：