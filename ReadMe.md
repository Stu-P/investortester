#### Objective

Suppose we could access yesterday's stock prices as a list, where:

The indices are the time in minutes past trade opening time, which was 10:00am local time.
The values are the price in dollars of the stock at that time.
So if the stock cost $5 at 11:00am, stock_prices_yesterday[60] = 5.
Write an efficient function that takes an array of stock prices and returns the best profit could have been made from 1 purchase and 1 sale of 1 stock.

For example:
```
int[] stockPrices = {10, 7, 5, 8, 11, 9};
Assert.assertEquals (6, getMaxProfit(stockPrices)); // returns 6 (buy at $5 sell at $11)
```

You must buy before you sell. You may not buy and sell in the same time step (at least 1 minute must pass).

Expectations

* Implement a solution in Java.
* Prove it works by creating unit tests that test the possible scenarios that the numbers could present.
* Include any comments that you think will be relevant to provide any context around the approach taken / solution developed.
* We prefer the response as a Git repo or ZIP File.

#### Author comments

* Given the sample input refers to integer I've used this data type though not the most suitable to represent something like share prices, which can trade in decimals.
* There are scenarios where no profit is possible, in which case I took the requirement to be to return the least loss on trade, understanding that a buy and sell must occur.
* This solution should give linear performance.  