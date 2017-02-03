package com.pli.project.test;

import com.google.common.base.Function;
import com.google.common.base.Functions;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by lipeng on 2017/1/8.
 */
public class FunctionTest {

    public static Function<String, Integer> f = new Function<String, Integer>() {
        public Integer apply(String s) {
            return Integer.parseInt(s);
        }
    };

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<Integer, String>();
        map.put(1, "a");
        map.put(2, "b");
        Function<Integer, String> lookup = Functions.forMap(map);
        System.out.println(lookup.apply(1));
    }


}
