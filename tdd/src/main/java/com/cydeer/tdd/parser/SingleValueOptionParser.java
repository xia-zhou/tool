package com.cydeer.tdd.parser;

import com.cydeer.tdd.Option;
import com.cydeer.tdd.exception.NonArgumentsException;
import com.cydeer.tdd.exception.TooManyArgumentsException;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author song.z
 * @date 2023/6/20 22:47
 */
public class SingleValueOptionParser<T> implements OptionParser<T> {
    private T defaultValue;
    private Function<String, T> valueParser;


    public SingleValueOptionParser(T defaultValue, Function<String, T> valueParser) {
        this.defaultValue = defaultValue;
        this.valueParser = valueParser;
    }

    @Override
    public T parse(List<String> args, Option option) {
        int index = args.indexOf("-" + option.value());
        if (index == -1) {
            return defaultValue;
        }
        List<String> values = ValueParseUtils.valueFrom(args, index);
        if (values.size() > 1) {
            throw new TooManyArgumentsException();
        }
        if (values.size() < 1) {
            throw new NonArgumentsException();
        }
        return valueParser.apply(values.get(0));
    }

}
