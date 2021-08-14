package q1_jca_l14;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ArraysComputeTest {
    ArraysCompute ac;
    public static final int NUM = 4;
    public static final int FIRST_NUM = 1;
    public static final int SECOND_NUM = 4;

    @BeforeEach
    void initEach() {
        ac = new ArraysCompute();
    }

    @Test
    void getNewArray() {
        Assertions.assertThrows(RuntimeException.class, () -> ac.getNewArray(NUM, new int[]{1, 3, 3, 7, 9, 5, 3, 0, 6}));
    }

    @MethodSource("testArraysGenerator")
    @ParameterizedTest
    void massGetNewArrayTest(int[] result, int[] array) {
        Assertions.assertArrayEquals(result, ac.getNewArray(NUM, array));
    }

    public static Stream<Arguments> testArraysGenerator() {
        return Stream.of(
                Arguments.of(new int[]{0, 3, 8}, new int[]{2, 5, 4, 0, 3, 8}),
                Arguments.of(new int[]{1, 2, 0, 3}, new int[]{1, 3, 3, 7, 9, 5, 4, 4, 6, 4, 1, 2, 0, 3}),
                Arguments.of(new int[]{1, 1, 9, 3, 0, 2}, new int[]{9, 9, 2, 1, 4, 1, 1, 9, 3, 0, 2}),
                Arguments.of(new int[]{5}, new int[]{7, 8, 0, 1, 7, 7, 3, 4, 5})
        );
    }

    @Test
    void checkArrayNumberFirst() {
        Assertions.assertTrue(ac.checkArrayNumbers(FIRST_NUM, SECOND_NUM, new int[]{1, 1, 1, 4, 4, 1, 4, 4}));
    }

    @Test
    void checkArrayNumberSecond() {
        Assertions.assertFalse(ac.checkArrayNumbers(FIRST_NUM, SECOND_NUM, new int[]{1, 4, 4, 1, 1, 4, 3}));
    }

    @Test
    void checkArrayNumberThird() {
        Assertions.assertFalse(ac.checkArrayNumbers(FIRST_NUM, SECOND_NUM, new int[]{1, 1, 1, 1, 1}));
    }
}