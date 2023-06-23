package com.cydeer.tdd.parser;

import com.cydeer.tdd.exception.NonArgumentsException;
import com.cydeer.tdd.exception.TooManyArgumentsException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.function.Function;

import static com.cydeer.tdd.parser.BooleanOptionParserTest.option;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author song.z
 * @date 2023/6/22 15:56
 */
class SingleValueOptionParserTest {

    /**
     * happy path
     * -p 8080
     */
    @Test
    public void shoutParseIntAsOptionValue() {
        assertEquals(8080,
                     new SingleValueOptionParser<>(0, Integer::parseInt).parse(List.of("-p", "8080"), option("p")));
    }

    /**
     * default value
     */
    @Test
    public void shouldBeSetDefaultValueTo0IfNotPresent() {
        assertEquals(0, new SingleValueOptionParser<>(0, Integer::parseInt).parse(List.of(), option("p")));
    }

    /**
     * sad path
     * -p
     * -p -l
     */
    @ParameterizedTest
    @ValueSource(strings = {"-p", "-p -l"})
    public void shouldThrowNonOptionExceptionWithNonOption(String value) {
        assertThrows(NonArgumentsException.class,
                     () -> new SingleValueOptionParser<>(0, Integer::parseInt).parse(List.of(value.split(" ")),
                                                                                     option("p")));

    }

    /**
     * sad path
     * -p 8080 8081
     */
    @Test
    public void shouldThrowManyOptionExceptionWithMultiOption() {
        assertThrows(TooManyArgumentsException.class,
                     () -> new SingleValueOptionParser<>(0, Integer::parseInt).parse(List.of("-p", "8080", "8081"),
                                                                                     option("p")));
    }


    /**
     * happy path
     * -d /usr/logs
     */
    @Test
    public void shouldParseStringAsOptionValue() {
        assertEquals("/usr/logs",
                     new SingleValueOptionParser<>("", String::valueOf).parse(List.of("-d", "/usr/logs"), option("d")));
    }

    /**
     * default value
     */
    @Test
    public void shouldBeSetDefaultValueToEmptyIfNotPresent() {
        Function<String, Object> whatever = value -> value;
        Object defaultValue = new Object();
        assertSame(defaultValue, new SingleValueOptionParser<>(defaultValue, whatever).parse(List.of(), option("d")));
    }

    /**
     * sad path
     * -d /usr/logs /usr/log
     */
    @Test
    public void shouldThrowManyOptionExceptionWithMultiStringOption() {
        assertThrows(TooManyArgumentsException.class, () -> new SingleValueOptionParser<>("", String::valueOf).parse(
                List.of("-d", "/usr/logs", "/usr/log"), option("d")));
    }

    /**
     * sad path
     * -d
     * -d -l
     *
     * @param value 测试参数
     */
    @ParameterizedTest
    @ValueSource(strings = {"-d", "-d -l"})
    public void shouldThrowNonOptionExceptionWithNonStringOption(String value) {
        assertThrows(NonArgumentsException.class,
                     () -> new SingleValueOptionParser<>(0, Integer::parseInt).parse(List.of(value.split(" ")),
                                                                                     option("d")));
    }


}