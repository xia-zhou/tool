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
    class ListOptionParserTest {
        /**
         * happy path
         * <p>
         * -g this is a list
         */
        @Test
        public void shoutParseStringArrayAsOptionValue() {
            assertArrayEquals(new String[]{"this", "is", "a", "list"},
                              OptionParserFactory.listOptionParser(String[]::new, String::valueOf)
                                      .parse(List.of("-g", "this", "is", "a", "list"), option("g")));
        }

        /**
         * default value String[]
         */
        @Test
        public void shoutParseStringArrayDefaultValue() {
            assertArrayEquals(new String[0], OptionParserFactory.listOptionParser(String[]::new, String::valueOf)
                    .parse(List.of(), option("g")));
        }

        /**
         * happy path
         * <p>
         * -d 1 2 -3 5
         */
        @Test
        public void shoutParseIntArrayAsOptionValue() {
            assertArrayEquals(new Integer[]{1, 2, -3, 5},
                              OptionParserFactory.listOptionParser(Integer[]::new, Integer::parseInt)
                                      .parse(List.of("-d", "1", "2", "-3", "5"), option("d")));
        }

        /**
         * default value int[]
         */
        @Test
        public void shoutParseIntArrayDefaultValue() {
            assertArrayEquals(new Integer[0], OptionParserFactory.listOptionParser(Integer[]::new, String::valueOf)
                    .parse(List.of(), option("d")));
        }
    }


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