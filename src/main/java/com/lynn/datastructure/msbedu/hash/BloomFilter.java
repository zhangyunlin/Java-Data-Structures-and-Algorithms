package com.lynn.datastructure.msbedu.hash;

public class BloomFilter {
    public static void main(String[] args) {

    }

    /*
    长度为m的bit数组占用内存为m/8 byte
    url加入黑名单操作：
    1.url计算k个hash值，每个hash函数不一样，计算得到k个(hashCode % m)值，
    2.将k个(hashCode % m)值对应的bitMap上的bit位置为1。此时这个url就加入黑名单了。
    3.将所有url都进行以上处理，将对应的所有bit位全部置为1。得到完整的黑名单过滤器。
    4.当有用户访问的时候，将用户url调用k个hash函数，计算得到k个(hashCode % m)值，在bloom filter上查看对应的bit位，
    当k个(hashCode % m)值与bloom filter中的bit位状态一致的时候，则表明当前url在黑名单中，不能访问。
     可能将不是黑名单的url，误判为黑名单url。

     【问题】m定多大？k选多少个hash函数？
     影响的参数：样本量n，失误率p.
     m = -(n * lnp)/(ln2)^2
     k = ln2 * (m/n) ≈ 0.7*(m/n)
     p=(1−e^(−k*n/m))^k
     */

}
