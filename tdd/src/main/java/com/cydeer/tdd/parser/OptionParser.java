package com.cydeer.tdd.parser;

import com.cydeer.tdd.Option;

import java.util.List;

/**
 * @author song.z
 * @date 2023/6/20 22:46
 */
public interface OptionParser<T> {

    String HYPHEN = "-";

    /**
     * 解析单个参数
     *
     * @param args   参数
     * @param option 具体的某个参数标识
     * @return 参数对应的value
     */
    T parse(List<String> args, Option option);
}
