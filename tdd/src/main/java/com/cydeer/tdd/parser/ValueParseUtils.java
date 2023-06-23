package com.cydeer.tdd.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author song.z
 */
public class ValueParseUtils {

    public final static List<String> valueFrom(List<String> args, int index) {
        int nextFlagIndex = IntStream.range(index + 1, args.size()).filter(
                i -> args.get(i).contains(BooleanOptionParser.HYPHEN)).findFirst().orElse(args.size());
        return args.subList(index + 1, nextFlagIndex);
    }
}