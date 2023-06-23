package com.cydeer.tdd.parser;

import com.cydeer.tdd.Option;
import com.cydeer.tdd.exception.TooManyArgumentsException;

import java.util.List;

/**
 * @author song.z
 * @date 2023/6/20 22:46
 */
public class BooleanOptionParser implements OptionParser<Boolean> {


    @Override
    public Boolean parse(List<String> args, Option option) {
        int index = args.indexOf(HYPHEN + option.value());
        if (index == -1) {
            return false;
        }
        List<String> values = ValueParseUtils.valueFrom(args, index);
        if (values.size() > 0) {
            throw new TooManyArgumentsException();
        }
        return true;
    }

}
