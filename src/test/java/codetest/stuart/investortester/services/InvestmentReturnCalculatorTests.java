package codetest.stuart.investortester.services;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.stream.Stream;
import static org.junit.jupiter.api.Assertions.*;

class InvestmentReturnCalculatorTests {

    @ParameterizedTest
    @MethodSource("priceFluctuationScenarios")
    void returnsBestProfit_givenPriceFluctuationsThroughDay(String scenario, int[] input, int expected ) {
        // arrange
        var sut = new InvestmentReturnCalculator();

        // act
        var actual = sut.getMaxTradeProfit(input);

        // assert
        assertEquals(expected, actual, scenario);
    }

    @ParameterizedTest
    @MethodSource("priceDecreaseScenarios")
    void returnsLeastWorstTradeLoss_givenNoProfitIsPossible(String scenario, int[] input, int expected ) {
        // arrange
        var sut = new InvestmentReturnCalculator();

        // act
        var actual = sut.getMaxTradeProfit(input);

        // assert
        assertEquals(expected, actual, scenario);
    }

    @ParameterizedTest
    @MethodSource("invalidInputScenarios")
    void throwsArgumentException_givenLessThanTwoPricesProvided(String scenario, int[] input) {
        // arrange
        var sut = new InvestmentReturnCalculator();

        // Act
        Exception exception = assertThrows(RuntimeException.class, () -> {
            var actual = sut.getMaxTradeProfit(input);
        });

        // Assert
        String expectedMessage = "input must contain at least 2 prices";
        String actualMessage = exception.getMessage();

        assertTrue(actualMessage.contains(expectedMessage));
    }

    private static Stream<Arguments> priceFluctuationScenarios() {
        return Stream.of(
                Arguments.of("min number of prices", new int[]{9, 10}, 1),
                Arguments.of("uneven number of prices", new int[]{9, 10, 15}, 6),
                Arguments.of("price up and down, ending down", new int[]{10, 12, 8, 11, 9, 7, 9}, 3),
                Arguments.of("lowest price occurs after best profit", new int[]{ 11, 7, 20, 1, 8, 9 , 5, 7, 3},13),
                Arguments.of("price down and up, with plateau, ending down", new int[]{10, 7, 5, 8, 11, 9, 9, 9, 3}, 6),
                Arguments.of("price up and down, ending up", new int[]{10, 12, 8, 11, 9, 10, 15}, 7),
                Arguments.of("price ending unchanged after decreasing", new int[]{10, 9, 8, 5, 8, 9, 10}, 5),
                Arguments.of("price ending unchanged after increasing", new int[]{10, 11, 12, 13, 12, 11, 10}, 3),
                Arguments.of("no movement in price", new int[]{10, 10, 10, 10, 10, 10, 10}, 0),
                Arguments.of("constant price increases",new int[]{4, 6, 7, 9, 9, 10, 11, 18}, 14));
    }

    private static Stream<Arguments> priceDecreaseScenarios() {
        return Stream.of(
                Arguments.of("Least worst trade in steady decrease", new int[]{10, 9, 8, 7, 6}, -1),
                Arguments.of("price plateau during decrease",new int[]{10, 9, 9, 9, 8, 7, 6}, 0));
    }

    private static Stream<Arguments> invalidInputScenarios() {
        return Stream.of(
                Arguments.of("null array", null),
                Arguments.of("empty array", new int[]{}),
                Arguments.of("array has less than 2 prices",new int[]{10}));
    }
}