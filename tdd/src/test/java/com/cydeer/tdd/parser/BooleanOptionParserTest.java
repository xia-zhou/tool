package com.cydeer.tdd.parser;

import com.cydeer.tdd.Args;
import com.cydeer.tdd.ArgsTest;
import com.cydeer.tdd.Option;
import com.cydeer.tdd.exception.TooManyArgumentsException;
import org.junit.jupiter.api.Test;

import java.lang.annotation.Annotation;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author song.z
 * @date 2023/6/22 15:48
 */
public class BooleanOptionParserTest {

    /**
     * happy path
     * <p>
     * -l
     */
    @Test
    public void shouldSetBooleanOptionsToTrueIfPresent() {
        assertTrue(new BooleanOptionParser().parse(List.of("-l"), option("l")));
    }

    /**
     * default value
     */
    @Test
    public void shouldSetBooleanOptionsToFalseIfNotPresent() {
        assertFalse(new BooleanOptionParser().parse(List.of(), option("l")));
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
                     () -> new BooleanOptionParser().parse(List.of("-l", "t"), option("l")));

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