package com.cydeer.tdd;

import com.cydeer.tdd.exception.IllegalOptionException;
import com.cydeer.tdd.exception.IllegalTypeException;
import com.cydeer.tdd.parser.BooleanOptionParser;
import com.cydeer.tdd.parser.SingleValueOptionParser;
import com.cydeer.tdd.parser.OptionParser;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author song.z
 * @date 2023/6/18 22:05
 */
public class Args {

    private final static Map<Class<?>, OptionParser> PARSER = Map.of(boolean.class, new BooleanOptionParser(),
                                                                     int.class, new SingleValueOptionParser<>(0,
                                                                                                              Integer::parseInt),
                                                                     String.class, new SingleValueOptionParser<>("",
                                                                                                                 String::valueOf));

    public static <T> T parse(Class<T> optionClass, String... args) {
        Constructor<?> constructor = optionClass.getDeclaredConstructors()[0];
        try {
            List<String> argsList = Arrays.asList(args);
            Object[] values = Arrays.stream(constructor.getParameters()).map(
                    parameter -> parseValue(argsList, parameter)).toArray();
            return (T) constructor.newInstance(values);
        } catch (IllegalOptionException illegalOptionException) {
            throw illegalOptionException;
        } catch (IllegalTypeException illegalTypeException) {
            throw illegalTypeException;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static Object parseValue(List<String> args, Parameter parameter) {
        Option option = parameter.getAnnotation(Option.class);
        if (option == null) {
            throw new IllegalOptionException();
        }
        OptionParser optionParser = PARSER.get(parameter.getType());
        if (optionParser == null) {
            throw new IllegalTypeException();
        }
        return optionParser.parse(args, parameter.getAnnotation(Option.class));
    }


}
