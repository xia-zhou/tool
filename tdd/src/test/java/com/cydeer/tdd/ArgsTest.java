package com.cydeer.tdd;

import com.cydeer.tdd.exception.IllegalOptionException;
import com.cydeer.tdd.exception.IllegalTypeException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author song.z
 * @date 2023/6/18 21:56
 */
public class ArgsTest {
    /**
     * happy path
     * <p>
     * -l -p 8080 -d /usr/logs
     */
    @Test
    public void shouldParseMultiOption() {
        MultiOptions multiOptions = Args.parse(MultiOptions.class, "-l", "-p", "8080", "-d", "/usr/logs");
        assertTrue(multiOptions.logging());
        assertEquals(8080, multiOptions.port());
        assertEquals("/usr/logs", multiOptions.direction());
    }

    @Test
    public void shouldThrowsIllegalOptionExceptionWithOutOptionAnnotation() {
        assertThrows(IllegalOptionException.class, () -> {
            Args.parse(MultiOptionsWithOutOption.class, "-l", "-p", "8080", "-d", "/usr/logs");
        });
    }

    @Test
    public void shouldThrowsIllegalTypeExceptionWithNotSupportType() {
        assertThrows(IllegalTypeException.class, () -> {
            Args.parse(MultiOptionsWithNotSupportType.class, "-l", "-p", "8080", "-d", "/usr/logs");
        });
    }


    public record MultiOptions(@Option("l") boolean logging, @Option("p") int port, @Option("d") String direction) {

    }

    public record MultiOptionsWithOutOption(@Option("l") boolean logging, int port, @Option("d") String direction) {

    }

    public record MultiOptionsWithNotSupportType(@Option("l") boolean logging, @Option("p") int port,
                                                 @Option("d") Long number) {

    }

}
