package com.lynn.datastructure.msbedu.hash;

/**
 * 一个文件包含40亿个无符号整数，给定1G内存，统计出现次数最多的数。
 */
public class BigNumberCount {
    /*
    思路1： HashMap 不可行，number为key，出现次数为value，内存不够。
     */

    /*
    思路2：
    1. 每个数计算hash，每个hash%100，将结果相同的数放入同一个组，由于hash函数的特性，每组数据数量应该差不多
    2. 相同的数会进入同一个文件，不同的数均匀分布到不同的文件
    3. 分别统计每个小文件的词频，内存不爆，问题解决。
     */





}
