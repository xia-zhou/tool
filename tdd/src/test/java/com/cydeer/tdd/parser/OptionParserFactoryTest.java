package com.cydeer.tdd.parser;

import com.cydeer.tdd.Option;
import com.cydeer.tdd.exception.NonArgumentsException;
import com.cydeer.tdd.exception.TooManyArgumentsException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.lang.annotation.Annotation;
import java.util.List;
import java.util.function.Function;

import static com.cydeer.tdd.parser.OptionParserFactoryTest.BooleanOptionParserTest.option;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author song.z
 * @date 2023/6/22 15:56
 */
class OptionParserFactoryTest {


    @Nested
    class SingleOptionParserTest {
        /**
         * happy path
         * -p 8080
         */
        @Test
        public void shoutParseIntAsOptionValue() {
            assertEquals(8080, OptionParserFactory.singleOptionParser(0, Integer::parseInt)
                    .parse(List.of("-p", "8080"), option("p")));
        }

        /**
         * default value
         */
        @Test
        public void shouldBeSetDefaultValueTo0IfNotPresent() {
            assertEquals(0, OptionParserFactory.singleOptionParser(0, Integer::parseInt).parse(List.of(), option("p")));
        }

        /**
         * sad path
         * -p
         * -p -l
         */
        @ParameterizedTest
        @ValueSource(strings = {"-p", "-p -l"})
        public void shouldThrowNonOptionExceptionWithNonOption(String value) {
            assertThrows(NonArgumentsException.class, () -> OptionParserFactory.singleOptionParser(0, Integer::parseInt)
                    .parse(List.of(value.split(" ")), option("p")));

        }

        /**
         * sad path
         * -p 8080 8081
         */
        @Test
        public void shouldThrowManyOptionExceptionWithMultiOption() {
            assertThrows(TooManyArgumentsException.class,
                         () -> OptionParserFactory.singleOptionParser(0, Integer::parseInt)
                                 .parse(List.of("-p", "8080", "8081"), option("p")));
        }


        /**
         * happy path
         * -d /usr/logs
         */
        @Test
        public void shouldParseStringAsOptionValue() {
            assertEquals("/usr/logs", OptionParserFactory.singleOptionParser("", String::valueOf)
                    .parse(List.of("-d", "/usr/logs"), option("d")));
        }

        /**
         * default value
         */
        @Test
        public void shouldBeSetDefaultValueToEmptyIfNotPresent() {
            Function<String, Object> whatever = value -> value;
            Object defaultValue = new Object();
            assertSame(defaultValue,
                       OptionParserFactory.singleOptionParser(defaultValue, whatever).parse(List.of(), option("d")));
        }

        /**
         * sad path
         * -d /usr/logs /usr/log
         */
        @Test
        public void shouldThrowManyOptionExceptionWithMultiStringOption() {
            assertThrows(TooManyArgumentsException.class,
                         () -> OptionParserFactory.singleOptionParser("", String::valueOf)
                                 .parse(List.of("-d", "/usr/logs", "/usr/log"), option("d")));
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
            assertThrows(NonArgumentsException.class, () -> OptionParserFactory.singleOptionParser(0, Integer::parseInt)
                    .parse(List.of(value.split(" ")), option("d")));
        }
    }

    @Nested
    class BooleanOptionParserTest {

        /**
         * happy path
         * <p>
         * -l
         */
        @Test
        public void shouldSetBooleanOptionsToTrueIfPresent() {
            assertTrue(OptionParserFactory.boolParser().parse(List.of("-l"), option("l")));
        }

        /**
         * default value
         */
        @Test
        public void shouldSetBooleanOptionsToFalseIfNotPresent() {
            assertFalse(OptionParserFactory.boolParser().parse(List.of(), option("l")));
        }


        /**
         * sad path
         * -l t
         * -l t s
         */
        @Test
        public void shouldBeThrowManyArgumentsExceptionWithOneOptionValue() {
            assertEquals("l", option("l").value());
            assertThrows(TooManyArgumentsException.class,
                         () -> OptionParserFactory.boolParser().parse(List.of("-l", "t"), option("l")));

        }


        public static Option option(String value) {
            return new Option() {

                @Override
                public Class<? extends Annotation> annotationType() {
                    return Option.class;
                }

                @Override
                public String value() {
                    return value;
                }
            };
        }

    }
}