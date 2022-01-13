package com;

/**
 * @program: dataStructure
 * @author: yjl
 * @created: 2021/12/22
 *
 * Master公式
 *
 * T(N) = a * T(N/b)+O(N^d)  其中a 、b 、d都是常数的递归函数，可以直接算时间复杂度
 *
 * log（b，a） < d ,时间复杂度是O(N^d)
 *log（b，a） > d ,时间复杂度是O(N^log(b,a))
 * log（b，a） ==  d ,时间复杂度是O(N^d*logN)
 *
 * Master只适用于递归子问题一致的情况下使用
 */
public class Recursion {


}
