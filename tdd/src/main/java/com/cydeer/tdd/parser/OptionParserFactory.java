package com.cydeer.tdd.parser;

import com.cydeer.tdd.Option;
import com.cydeer.tdd.exception.NonArgumentsException;
import com.cydeer.tdd.exception.TooManyArgumentsException;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

/**
 * @author song.z
 * @date 2023/6/20 22:47
 */
public class OptionParserFactory {

    public static OptionParser<Boolean> boolParser() {
        return (args, option) -> values(args, option, 0).isPresent();
    }

    public static <T> OptionParser<T> singleOptionParser(T defaultValue, Function<String, T> valueParser) {
        return (List<String> args, Option option) -> values(args, option, 1).map(
                values -> valueParser.apply(values.get(0))).orElse(defaultValue);
    }

    public static <T> OptionParser<T[]> listOptionParser(IntFunction<T[]> generate, Function<String, T> valueParser) {
        return (List<String> args, Option option) -> values(args, option).orElse(List.of())
                .stream()
                .map(valueParser)
                .toArray(generate);
    }

    private static Optional<List<String>> values(List<String> args, Option option) {
        int index = args.indexOf(OptionParser.HYPHEN + option.value());
        if (index == -1) {
            return Optional.empty();
        }
        int nextFlagIndex = IntStream.range(index + 1, args.size())
                .filter(i -> args.get(i).matches("^-[a-zA-Z-]+$"))
                .findFirst()
                .orElse(args.size());
        List<String> values = args.subList(index + 1, nextFlagIndex);
        return Optional.of(values);
    }

    private static Optional<List<String>> values(List<String> args, Option option, int expectSize) {
        Optional<List<String>> result = values(args, option);
        result.map(values -> {
            checkSize(expectSize, values);
            return values;
        });
        return result;
    }

    private static void checkSize(int expectSize, List<String> values) {
        if (values.size() > expectSize) {
            throw new TooManyArgumentsException();
        }
        if (values.size() < expectSize) {
            throw new NonArgumentsException();
        }
    }
}
